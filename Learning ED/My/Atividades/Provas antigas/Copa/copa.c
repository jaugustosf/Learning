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
            nivel_stress = (fim -> cansaco_fisico + fim -> cansaco_mental)/2;
            if(nivel_stress < 5){
                lixo = fim;
                jogador = fim -> jogador;
                fim = fim -> ant;
                fim -> prox = NULL;
                free(lixo);
                tam--;
            }
        }

        if(lixo == NULL && inicio -> prox != NULL){
            NO *aux = inicio -> prox;
            while(aux != fim){
                if(aux -> funcao == funcao){
                    nivel_stress = (aux -> cansaco_fisico + aux -> cansaco_mental)/2;
                    if(nivel_stress < 5){
                        aux -> ant -> prox = aux -> prox;
                        aux -> prox -> ant = aux -> ant;
                        jogador = aux -> jogador;
                        free(aux);
                        tam--;
                        break;
                    }
                }
                aux = aux -> prox;
            }
        }
    }  
    return jogador; 
}

void imprimir(NO *aux) {
    if (aux == NULL) {
        return;  // Caso base: a lista chegou ao final
    }

    if (aux->cansaco_fisico < 5 && aux->cansaco_mental < 5) {
        printf("%s - %s\n", aux->jogador, aux->funcao);
    }

    imprimir(aux -> prox);  // Chamada recursiva para o próximo nó da lista
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