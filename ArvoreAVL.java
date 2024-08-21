public class ArvoreAVL {
    private No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void inserirNo(int dado){
        No novoNo = new No(dado);

        if(raiz == null){
            raiz = novoNo;
        } else {
            int primeiro = raiz.getDado();
            No descida = raiz;

            while (descida != null) {
                if(primeiro > dado){
                    if(descida.getEsquerda() != null){
                        descida = descida.getEsquerda();
                        primeiro = descida.getDado();
                    } else {
                        novoNo.setPai(descida);
                        descida.setEsquerda(novoNo);
                        descida = null;
                    }
                } else {
                    if(descida.getDireita() != null){
                        descida = descida.getDireita();
                        primeiro = descida.getDado();
                    } else {
                        novoNo.setPai(descida);
                        descida.setDireita(novoNo);
                        descida = null;
                    }
                }
            }
        }
    }

    public int altura(No no){
        if(no.getEsquerda() == null && no.getDireita() == null){
            return 0;
        } else if (no.getEsquerda() == null){
            return altura(no.getDireita())+1;
            
        } else if (no.getDireita() == null){
            return altura(no.getEsquerda())+1;
        }

        return Math.max(altura(no.getDireita()), altura(no.getEsquerda())) + 1;
        
    }

    public int fatorBalanciamento(No no){
        if(no.getEsquerda() == null && no.getDireita() == null){
            return 0;
        } else if (no.getEsquerda() == null){
            return -1 - altura(no.getDireita());
        } else if (no.getDireita() == null){
            return -1 - altura(no.getEsquerda());
        }
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    public void rotacaoDireita(No avo){
        avo.getEsquerda().getPai() = avo.getPai();
        if(avo.getPai() != null){
            avo.getPai().getEsquerda() = avo.getEsquerda();
        } else {
            raiz = avo.getEsquerda();
        }
        avo.getPai() = avo.getEsquerda();
        avo.setEsquerda( avo.getEsquerda().getDireita());

        if(avo.getEsquerda() != null){
            avo.getEsquerda().getPai() = avo;
        }
        avo.getPai().getDireita() = avo;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
}
