package chainofresponsibility;

public class PaymentProcessingSystem {
    Processor firstProcessor;

    PaymentProcessingSystem(Processor firstProcessor) {
        this.firstProcessor = firstProcessor;
    }

    void processPayment(PaymentRequest paymentRequest) {
        this.firstProcessor.processPayment(paymentRequest);
    }
}

interface Processor {
    void processPayment(PaymentRequest paymentRequest);

    void setNext(Processor processor);
}

class CreditCardProcessor implements Processor {

    Processor next;

    public void processPayment(PaymentRequest paymentRequest) {
        if (paymentRequest.type.equalsIgnoreCase("Credit Card")) {
            System.out.println("Credit Credentials has been sent for further verifications");
        } else {
            System.out.println("This request cannot be handled by Credit Card Processor");
            if (next != null)
                this.next.processPayment(paymentRequest);
        }
    }

    public void setNext(Processor next) {
        this.next = next;
    }
}

class PayPalProcessor implements Processor {
    Processor next;

    public void processPayment(PaymentRequest paymentRequest) {
        if (paymentRequest.type.equalsIgnoreCase("PayPal")) {
            System.out.println("Paypal Credentials has been sent for further verifications");
        }

        else {
            System.out.println("This request cannot be handled by PayPal Processor");
            if (next != null)

                this.next.processPayment(paymentRequest);
        }
    }

    public void setNext(Processor next) {
        this.next = next;
    }

}

class GiftCardProcessor implements Processor {
    Processor next;

    public void processPayment(PaymentRequest paymentRequest) {
        if (paymentRequest.type.equalsIgnoreCase("Gift Card")) {
            System.out.println("Gift Card Credentials has been sent for further verifications");
        } else {
            System.out.println("This request cannot be handled by Gift Card Processor");
            if (next != null)
                this.next.processPayment(paymentRequest);
        }
    }

    public void setNext(Processor next) {
        this.next = next;
    }
}

class PaymentRequest {
    String type;
    String credentials;

    PaymentRequest(String type, String credentials) {
        this.type = type;
        this.credentials = credentials;
    }
}
 class Main {
    public static void main(String[] args) {
        // Create processor instances
        CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        GiftCardProcessor giftCardProcessor = new GiftCardProcessor();
        PayPalProcessor payPalProcessor = new PayPalProcessor();

        // Link the chain of responsibility
        creditCardProcessor.setNext(payPalProcessor);
        payPalProcessor.setNext(giftCardProcessor);

        // Pass the first processor in the chain to the payment processing system
        PaymentProcessingSystem paymentProcessingSystem = new PaymentProcessingSystem(creditCardProcessor);

        // Create a payment request and process it
        paymentProcessingSystem.processPayment(new PaymentRequest("PayPal", "user: blah blah, password: blah123"));
    }
}
