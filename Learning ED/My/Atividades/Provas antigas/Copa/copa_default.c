#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    char *jogador;
    char *funcao;
    int cansaco_mental;
    int cansaco_fisico;
    struct no *prox;
    struct no *ant;
}NO;

NO *inicio = NULL;
NO *fim = NULL;
int tam = 0;

void adicionar(char *jog, char *func, int mental, int fisico){
    NO *novo = malloc(sizeof(NO));
    novo -> jogador = jog;
    novo -> funcao = func;
    novo -> cansaco_mental = mental;
    novo -> cansaco_fisico = fisico;
    novo -> prox = NULL;

    if(inicio == NULL){
        inicio = novo;
        fim = novo;
        tam++;
    }else{
        fim -> prox = novo;
        novo -> ant = fim;
        fim = novo;
        tam++;
    }
}

char *remover(char *funcao){
    char *jogador = "Sem opcoes!";
    if(inicio != NULL){
        NO *lixo = NULL;
        float nivel_stress;
        if(inicio -> funcao == funcao){
            nivel_stress = (inicio -> cansaco_fisico + inicio -> cansaco_mental)/2;
            if(nivel_stress < 5){
                lixo = inicio;
                jogador = inicio -> jogador;
                inicio = inicio -> prox;
                inicio -> ant = NULL;
                free(lixo);
                tam--;
            }
        }

        if(lixo == NULL && fim -> funcao == funcao){
            //...
        }

        if(lixo == NULL && inicio -> prox != NULL){
            //...
        }
    }  
    return jogador; 
}

void imprimir(NO *aux) {
    //...
}

int main(){
    adicionar("Alisson - Liverpool","Goleiro", 9, 8);
    adicionar("Danilo - Juventus","Lateral", 4, 0);
    adicionar("Militao - Real Madrid","Zagueiro", 5, 3);
    adicionar("Fabinho - Liverpool","Goleiro", 2, 1);
    adicionar("Neymar - PSG","Atacante", 8, 9);
    printf("Jogador removido: %s\n", remover("Atacante"));
    printf("Jogadores disponiveis:\n");
    imprimir(inicio);
    return 0;
}