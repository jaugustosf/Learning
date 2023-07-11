#include<stdio.h>
#include<stdlib.h>

typedef struct no{
    int idade;
    float peso;
    float altura;
    struct no * prox;
}NO;

NO * inicio = NULL;
int tam = 0;


void add(int pos, int idade, float peso, float altura){
        //1 - COMPILADOR! cria espaco na memoria para o no e nao desaloca!!!! Por favor!
    
    if(pos >= 0 && pos <= tam){
        NO * novo = malloc(sizeof(NO));
        //2 - seto os valores desse no
        novo->idade = idade;
        novo->peso = peso;
        novo->altura = altura;
        novo->prox = NULL;
        //3 - encaixo esse no na lista
        if(inicio == NULL){//vazia
            inicio = novo;
            tam++;
        }else{
            if(pos == 0){  //inicio
                novo->prox = inicio;
                inicio = novo;
                tam++;
            }else if(pos == tam){//fim!
                NO * aux = inicio;
                
                for(int i = 0; i<tam-1; i++){
                    aux = aux->prox; //caminhada
                }
                
                //operacao de encaixe
                aux->prox = novo;
                tam++;
                
            }else{//entre ao inves de meio

                NO * aux = inicio;
                
                for(int i = 0; i<pos-1; i++){
                    aux = aux->prox; //caminhada
                }
                //operacoes de encaixe! CUIDADE A ORDEM IMPORTA!
                novo->prox = aux->prox;
                aux->prox = novo;
                tam++;
            }
        }
    }
}

void imprimir(){
    
    //logica para percorrer a lista imprimindo os dados (altura, peso e idade) de cada elemento da lista
    //DICA:
     NO * aux = inicio;
                   
    for(int i = 0; i<tam; i++){
        printf("idade: %d\n", aux->idade);
        aux = aux->prox; //caminhada
    }
    
    
}

int main(){
    add(0, 18, 59.5, 1.7);
    add(0, 19, 61.7, 1.65);
    add(0, 17, 72.1, 1.8);
    add(3, 21, 62.4, 1.73);
    add(3, 19, 82.4, 1.83);
    add(2, 20, 73.4, 1.63);
    imprimir();
    
    return 0;
}


