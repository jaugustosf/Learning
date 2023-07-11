#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct No{
    char * nome_musica;
    double minutos;
    struct No * prox;
    struct No * ant;
}No;

No * inicio = NULL;

void adicionar(char * nome_musica, double minutos){
    No * novo = malloc(sizeof(No));
    novo->nome_musica = nome_musica;
    novo->minutos = minutos;
    novo->prox = NULL;
    novo->ant = NULL;

    if(inicio == NULL){ //lista vazia!
        inicio = novo;
        novo->prox = novo;
        novo->ant = novo;

    }else{
        inicio->ant->prox = novo;
        novo->prox = inicio;
        novo->ant = inicio->ant;
        inicio->ant = novo;
    }
}

void play(No * aux, int num_repeticoes){

    if(inicio != NULL){
    
        if(num_repeticoes > 0){
            printf("%s, %f\n", aux->nome_musica, aux->minutos);
            if(aux->prox != inicio){
                play(aux->prox, num_repeticoes);
            }else{
                play(aux->prox, num_repeticoes-1);
            }
        }
    
    }else{
        printf("Nao tem musica :'( !!");
    }
}

void remover(){
    if(inicio != NULL){
        
        if(inicio->prox == inicio){ //lista so tem um elemento
            No *lixo = inicio;
            inicio = NULL;
            free(lixo);
        }else{
        
            No * maior_tempo = inicio; //comeca considerando a primeira musica a de maior tempo
            No * aux = inicio->prox; //verifica demais musicas

            while(aux != inicio){ //enquanto existirem outras musicas
        
                if(aux->minutos > maior_tempo->minutos){ //verifica se o tempo eh maior
                maior_tempo = aux; //se sim, armazena o endereco do no com a musica de maior tempo encontrada
                }
                aux = aux->prox; //percorre o proximo no
            }
            //ao final o ponteiro aux estara apontando para musica de maior tempo, remover no
            maior_tempo->ant->prox = maior_tempo->prox; //
            maior_tempo->prox->ant = maior_tempo->ant;
    
            if(maior_tempo == inicio){ //se musica de maior tempo esta no inicio
                //mudar o ponteiro para nao perder o inicio da lista
                inicio = inicio->prox;
            }
            //limpa memoria
            free(maior_tempo);
        }
    }else{
        printf("Lista vazia!\n");
    }
}

int main(){
    adicionar("Evoque Prata", 1.47);
    adicionar("Eu gosto assim", 2.28);
    adicionar("Pacto", 3.03);
    adicionar("Bombonzinho", 2.34);
    remover();
    printf("Top Spotify Brasil hoje:\n");
    play(inicio, 2); 
return 0;
}



