#include<stdio.h>
#include<stdlib.h>

typedef struct no{
    int valor;
    struct no * prox;
    struct no * ant;
}NO;

NO * inicio = NULL;
NO * fim = NULL;
int tam = 0;


void add(int pos, int valor){
    
    if(pos >= 0 && pos <= tam){
        //Passo 1 - aloco espaco de memoria e coloco os valores no NO novo
        NO * novo = malloc(sizeof(NO));
        novo->valor = valor;
        novo->prox = NULL;
        novo->ant = NULL;
        //Passo 2 - encaixo esse no na lista
        if(inicio == NULL){//vazia
            inicio = novo;
            fim = novo;
        }else if(pos == 0){  //inicio
            novo->prox = inicio;
            inicio->ant = novo;
            inicio = novo;
        }else if(pos == tam){//fim!
            fim->prox = novo;
            novo->ant = fim;
            fim = novo;
        }else{//entre os elementos da lista ("meio")
            NO * aux = inicio;
            for(int i = 0; i<pos; i++){
                aux = aux->prox; //caminhada
            }
            //operacoes de encaixe! CUIDADE A ORDEM IMPORTA!
            novo->prox = aux;
            aux->ant->prox = novo;
            aux->ant = novo->ant;
            aux->ant = novo;
        }
        tam++;
    }
}

void imprimir(){
     NO * aux = inicio;   
    for(int i = 0; i<tam; i++){
        printf("idade: %d\n", aux->valor);
        aux = aux->prox;
    } 
}

int remover(pos){
    //DICA e necessario desalocar o no com a funcao free()
    if(pos >=0 && pos <=tam - 1){
        NO * lixo;
        if(tam == 1){ //lista so tem um elemento
            //etapa 1: aponto o lixo para no a ser removido
            lixo = inicio;
            //etapa 2: removo o no da lista (logica)
            inicio = NULL;
            fim = NULL;  
        }else if (pos == 0){//inicio
            //etapa 1: aponto o lixo para no a ser removido
            lixo = inicio;
             //etapa 2: removo o no da lista (logica)
            inicio = inicio->prox;
            inicio->ant = NULL;
        }else if(pos == tam -1){//fim
            //etapa 1: aponto o lixo para no a ser removido
            lixo = fim;
            //etapa 2: removo o no da lista (logica)
            fim = fim->ant;
            fim->prox = NULL;
        }else{//entre os elementos da lista ("meio")
             lixo = inicio;
            for(int i = 0; i<pos; i++){
                lixo = lixo->prox; //caminhada
            }
            lixo->ant->prox = lixo->prox;
            lixo->prox->ant = lixo->ant;
        }
        //etapa 3: removo o no da memoria
        int aux = lixo->valor;
        free(lixo);
        tam--;
        return aux;
    }
    return 0;
}

void add_ordenado(int valor){
    //nesta funcao os elementos devem ser adicionados na lista agora por ordem crescente    
}

void remover_por_valor(int valor){
    //nesta funcao a busca do elemento deve ser pelo seu valor. Considere que na lista nao existem valores iguais.
}

int main(){
    add(0, 18);
    add(0, 19);
    add(0, 17);
    add(3, 21);
    add(3, 15);
    add(2, 20);
    imprimir();
    return 0;
}


