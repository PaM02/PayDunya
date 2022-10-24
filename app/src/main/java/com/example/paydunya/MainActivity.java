package com.example.paydunya;

import androidx.appcompat.app.AppCompatActivity;
import com.paydunya.neptune.*;
import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PaydunyaSetup setup = new PaydunyaSetup();
        setup.setMasterKey("P8Y3fCil-6ecy-JzwH-6McE-ah0b5SCaiEuI");
        setup.setPrivateKey("test_private_UpHU0vaZ2fCTJprY9VORnukZio8");
        setup.setPublicKey("test_public_21KIFUfnj6RgdtEy3EaCCSi5YKw");
        setup.setToken("qPdev52WW2p35mKsqDx9");
        setup.setMode("test"); // Optionnel. Utilisez cette option pour les paiements tests.

        //Configuration des informations de votre service/entreprise
        PaydunyaCheckoutStore store = new PaydunyaCheckoutStore();
        store.setName("Magasin Chez Sandra"); // Seul le nom est requis
        store.setTagline("L'élégance n'a pas de prix");
        store.setPhoneNumber("336530583");
        store.setPostalAddress("Dakar Plateau - Etablissement kheweul");
        store.setWebsiteUrl("http://www.chez-sandra.sn");
        store.setLogoUrl("http://www.chez-sandra.sn/logo.png");

        PaydunyaOnsiteInvoice invoice = new PaydunyaOnsiteInvoice(setup, store);
        /* L'ajout d'éléments à votre facture est très basique.
        Les paramètres attendus sont nom du produit, la quantité, le prix unitaire,
        le prix total et une description optionelle. */
        invoice.addItem("Clavier DELL", 2, 3000, 6000);
        invoice.addItem("Ordinateur Lenovo L440", 1, 400000, 400000, "Description optionelle");
        invoice.addItem("Casque Logitech", 1, 8000, 8000);

        /* Vous pouvez de manière optionelle définir une description générale de facture
        qui sera utilisée dans les cas où vous avez besoin d'inclure
        des informations supplémentaires à votre facture. */
        invoice.setDescription("Description Optionnelle");
        invoice.setTotalAmount(414000);

    }


}
