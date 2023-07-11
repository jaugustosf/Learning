#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    char *heroi;
    int num_filmes;
    int dias_descanso;
    struct no *prox;
}NO;

NO *inicio = NULL;
NO *fim = NULL;
int tam = 0;

void adicionar(char *heroi, int num_filmes){
    NO *novo = malloc(sizeof(NO));
    novo -> heroi = heroi;
    novo -> num_filmes = num_filmes;
    novo -> dias_descanso = 5 + num_filmes;
    novo -> prox = NULL;

    if(inicio == NULL){
        inicio = novo;
        fim = novo;
        tam++;
    }else if(inicio -> num_filmes < num_filmes){
        novo -> prox = inicio;
        inicio = novo;
        tam++;
    }else{
        if(fim -> num_filmes > num_filmes){
            fim -> prox = novo;
            novo = fim;
            tam++;
        }else{
            NO *aux = inicio;
            while(aux -> prox != NULL && num_filmes < aux -> prox -> num_filmes){
                aux = aux -> prox;
            }
            novo -> prox = aux -> prox;
            aux -> prox = novo;
            tam++;
        }
    }
}

char *remover(){
    char *heroi_removido = inicio -> heroi;
    NO *aux = inicio;
    inicio = inicio -> prox;
    free(aux);
    tam--;
    return heroi_removido;
}

int main(){
    adicionar("Doutor Estranho", 6);
    adicionar("Homem Formiga", 4);
    adicionar("Wanda", 5);
    adicionar("Homem Aranha", 11);
    printf("Primeiro heroi que ira descansar: %s\n", remover());
    return 0;
}