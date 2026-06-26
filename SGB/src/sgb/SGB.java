package sgb;

import dados.Ficheiro;

public class SGB {

    public static void main(String[] args) {
        
        Ficheiro.carregarTudo();
        Biblioteca.bbtc();
        Ficheiro.salvarTudo();
        
    }
    
}
