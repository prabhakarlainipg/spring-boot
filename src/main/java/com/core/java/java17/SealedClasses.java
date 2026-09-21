package com.core.java.java17;


public class SealedClasses {
    sealed abstract class Payment
            permits CardPayment, UpiPayment {

        public abstract void pay();
    }

    final class CardPayment extends Payment {
        @Override
        public void pay() {
            System.out.println("Paying by card");
        }
    }

    final class UpiPayment extends Payment {
        @Override
        public void pay() {
            System.out.println("Paying by UPI");
        }
    }
//'com.core.java.java17.SealedClasses.CashPayment' is not allowed in the sealed hierarchy, COMPILOR ERROR
   /* class CashPayment extends Payment {
        @Override
        public void pay() {

        }
    }*/
// Compilation error: CashPayment is not permitted
}
