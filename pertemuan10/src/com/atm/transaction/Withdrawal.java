package com.atm.transaction;

import com.atm.model.Account;
import java.util.Scanner;

public class Withdrawal extends Transaction {

    public Withdrawal(Account account) {
        super(account);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Ambil jumlah penarikan dari input
        System.out.print("Masukkan jumlah yang ingin ditarik: ");
        double amountToWithdraw = scanner.nextDouble();
        double currentBalance = this.account.getBalance();

        // Step 2: Periksa apakah saldo setelah penarikan tidak kurang dari saldo minimal
        if (currentBalance - amountToWithdraw < Account.MINIMUM_BALANCE) {
            System.out.println("Penarikan gagal. Saldo setelah penarikan harus minimal Rp50,000.");
        } else {
            // Step 3: Lanjutkan proses penarikan
            this.account.debit(amountToWithdraw);
            System.out.println("Penarikan berhasil. Saldo saat ini: " + this.account.getBalance());
        }
    }
}