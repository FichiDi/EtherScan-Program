package org.example;


import io.api.etherscan.core.impl.EtherScanApi;
import io.api.etherscan.error.EtherScanException;
import io.api.etherscan.error.InvalidAddressException;
import io.api.etherscan.model.Tx;

import java.util.List;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        try {
            EtherScanApi api = new EtherScanApi();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            List<Tx> transactions = api.account().txs(address);
            System.out.println(transactions.size());
            int c = 1;
            for (Tx tx : transactions) {
                System.out.println("#" + c + ":" + tx);
                c++;
            }
        } catch (InvalidAddressException e) {
            System.out.println("Invalid Address.");
        } catch (EtherScanException e) {
            e.printStackTrace();
        }
    }
}
