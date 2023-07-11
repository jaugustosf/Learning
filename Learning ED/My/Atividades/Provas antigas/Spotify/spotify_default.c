#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    char *nome_musica;
    double minutos;
    struct no *prox;
    struct no *ant;
}NO;

NO *inicio = NULL;

// Função para adicionar um nó à lista duplamente encadeada
void adicionar(char *nome_musica, double minutos){
    NO *NOVO = malloc(sizeof(NO));
    NOVO->nome_musica = nome_musica;
    NOVO->minutos = minutos;
    NOVO->prox = NULL;
    NOVO->ant = NULL;

    if (inicio == NULL){
        // Se a lista está vazia, o nó adicionado é o primeiro nó (início da lista)
        inicio = NOVO;
        NOVO->prox = NULL;
        NOVO->ant = NULL;
    }
    else {
        //...
    }
}

// Função para reproduzir a lista de músicas
int play(NO *aux, int num_repeticoes){
    //...
}

// Função para remover o nó com a maior duração
void remover(){
   //...
}

int main()
{
    adicionar("Evoque Prata", 1.47);
    adicionar("Eu gosto assim", 2.28);
    adicionar("Pacto", 3.03);
    adicionar("Bombomzinho", 2.34);
    remover();
    printf("Top Spotify Brasil hoje:\n");
    play(inicio,2); // Reproduz as músicas por 2 vezes
    return 0;
}