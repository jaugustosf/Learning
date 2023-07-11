#include<stdio.h>
#include<stdlib.h>

typedef struct no{
    int valor;
    struct no * prox;
}NO;

NO * inicio = NULL;
NO * fim = NULL;
int tam = 0;


void add(int valor){
    
        NO * novo = malloc(sizeof(NO));
        novo->valor = valor;
        novo->prox = NULL;

        if(inicio == NULL){//fila esta vazia
            inicio = novo;
            fim = novo;
         
        }else {  //fim
                fim->prox = novo;
                fim = novo;
        }
        tam++;
    
}

void imprimir(){
    
     NO * aux = inicio;
                   
    for(int i = 0; i<tam; i++){
        printf("valor: %d\n", aux->valor);
        aux = aux->prox;
    }
    
    
}

int remover(){
   
    NO * aux = inicio->prox;
    NO * maior = inicio;
    int valor;
    while(aux->prox != NULL){
        if(aux->prox->valor > maior->prox->valor){
            maior = aux;
        }
        aux = aux->prox;
    }
    if(maior->prox->valor > inicio->valor){
    
        NO *lixo = maior->prox;
        valor = lixo->valor;
        if(maior->prox->valor == fim->valor){
            fim = maior;
        }
        maior->prox = maior->prox->prox;
        free(lixo);
    
    }else{
            NO *lixo = inicio;
            valor = inicio->valor;
            inicio = inicio->prox;
            free(lixo);
           
    }
     tam--;
    return valor;
}

int main(){
    add(10);
    add(15);
    add(25);
    printf("Valor removido: %d\n", remover());
    return 0;
}


