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
        // Caso contrário, percorre a lista até encontrar o último nó e o adiciona como próximo do último nó
        NO* aux = inicio;
        while(aux->prox != NULL){
            aux = aux->prox;
        }
        aux->prox = NOVO;
        NOVO->ant = aux;
    }
}

// Função para reproduzir a lista de músicas
int play(NO *aux, int num_repeticoes){
    if(num_repeticoes == 0)
        return 0;
    if(aux == NULL){
        // Se chegou ao final da lista, volta para o início e decrementa o número de repetições
        printf("\n");
        play(inicio, num_repeticoes - 1);
    } else{
        // Imprime o nome da música e a duração e chama recursivamente a função para o próximo nó
        printf("%s - %.2f\n", aux->nome_musica, aux->minutos);
        play(aux->prox, num_repeticoes);
    }

}

// Função para remover o nó com a maior duração
void remover(){
    NO *aux = inicio;
    NO *maior = inicio;
    if (inicio == NULL){
        // Se a lista está vazia, retorna sem fazer nada
        return;
    }
    while(aux->prox != NULL){
        if (aux->minutos > maior->minutos)
            // Encontra o nó com a maior duração
            maior = aux;
        aux = aux->prox;
    }
    // Atualiza os ponteiros dos nós anterior e próximo ao nó a ser removido
    maior->ant->prox = maior->prox;
    maior->prox->ant = maior->ant;
    free(maior); // Libera a memória ocupada pelo nó removido
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