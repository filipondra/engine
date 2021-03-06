package io.lumeer.core.facade;

import static org.assertj.core.api.Assertions.assertThat;

import io.lumeer.api.model.Payment;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author <a href="mailto:marvenec@gmail.com">Martin Večeřa</a>
 */
public class PaymentFacadeTest {

   private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

   @Test
   public void checkPaymentValues() {
      assertThat(
            Period.between(
                  LocalDate.of(2018, 5,31),
                  LocalDate.of(2018, 12, 1)
            ).getMonths()).isEqualTo(6);
      assertThat(
            Period.between(
                  LocalDate.of(2018, 4,30),
                  LocalDate.of(2018, 10, 30)
            ).getMonths()).isEqualTo(6);
      assertThat(
            Period.between(
                  LocalDate.of(2018, 5,31),
                  LocalDate.of(2018, 11, 30)
            ).getMonths()).isEqualTo(5);
      assertThat(
            Period.between(
                  LocalDate.of(2018, 5,31),
                  LocalDate.of(2018, 12, 31)
            ).getMonths()).isEqualTo(7);

      final PaymentFacade paymentFacade = new PaymentFacade();

      assertThat(paymentFacade.checkPaymentValues(new Payment("x",
            getDate("2018-05-31T00:00:00.000+0100"),
            10 * 6 * 8,
            "id",
            getDate("2018-04-30T00:00:00.000+0100"),
            getDate("2018-10-30T00:00:00.000+0100"),
            Payment.PaymentState.CREATED,
            Payment.ServiceLevel.BASIC,
            10,
            "en",
            "EUR",
            "url"
            )).getAmount()).isEqualTo(10 * 6 * 8);

      assertThat(paymentFacade.checkPaymentValues(new Payment("x",
            getDate("2018-05-31T00:00:00.000+0100"),
            Math.round(10 * 12 * 6.7),
            "id",
            getDate("2018-04-30T00:00:00.000+0100"),
            getDate("2019-04-30T00:00:00.000+0100"),
            Payment.PaymentState.CREATED,
            Payment.ServiceLevel.BASIC,
            10,
            "en",
            "EUR",
            "url"
      )).getAmount()).isEqualTo(Math.round(10 * 12 * 6.7));

      assertThat(paymentFacade.checkPaymentValues(new Payment("x",
            getDate("2018-05-31T00:00:00.000+0100"),
            10 * 5 * 8,
            "id",
            getDate("2018-04-30T00:00:00.000+0100"),
            getDate("2018-10-30T00:00:00.000+0100"),
            Payment.PaymentState.CREATED,
            Payment.ServiceLevel.BASIC,
            10,
            "en",
            "EUR",
            "url"
      )).getAmount()).isEqualTo(10 * 6 * 8);

      assertThat(paymentFacade.checkPaymentValues(new Payment("x",
            getDate("2018-05-31T00:00:00.000+0100"),
            10 * 6 * 8 - 1,
            "id",
            getDate("2018-04-30T00:00:00.000+0100"),
            getDate("2018-10-30T00:00:00.000+0100"),
            Payment.PaymentState.CREATED,
            Payment.ServiceLevel.BASIC,
            10,
            "en",
            "EUR",
            "url"
      )).getAmount()).isEqualTo(10 * 6 * 8);
   }

   private Date getDate(final String date) {
      return Date.from(Instant.from(DTF.parse(date)));
   }

}