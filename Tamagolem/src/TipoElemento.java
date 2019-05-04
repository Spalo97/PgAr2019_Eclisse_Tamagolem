public enum TipoElemento{
    ACQUA(0),
    FUOCO(1),
    ERBA(2),
    ARIA(3),
    ETERE(4),
    ELETTRO(5),
    TERRA(6),
    VELENO(7),
    GHIACCIO(8),
    PSICO(9);

    private int indice;

    TipoElemento(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

}