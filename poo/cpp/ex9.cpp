// Heranca de multiplos niveis
#include <iostream>
#include <string.h>
using namespace std;

/* Servidor */
class Servidor {
  public:
    Servidor(const char *nome, int idade) ;
    void mostra_servidor(void) ;
  private:
    char nome[64] ;
    int idade;
};
Servidor::Servidor(const char *nome, int idade) {
  strcpy(Servidor::nome, nome) ;
  Servidor::idade = idade;
}
void Servidor::mostra_servidor(void) {
  cout << "Nome: " << nome << endl;
  cout << "Idade: " << idade << endl;
}

/* Professor */
class Professor: public Servidor {
  public:
    Professor(const char *nome, int idade, double salario);
    void mostra_professor(void) ;
  private:
    double salario;
};
Professor::Professor(const char *nome, int idade, double salario): Servidor(nome, idade) {
  Professor::salario = salario;
}
void Professor::mostra_professor(void) {
  mostra_servidor();
  cout << "Salario: " << salario << endl;
}

/* Pesquisador */
class Pesquisador : public Professor {
  public:
    Pesquisador(const char *nome, int idade, double salario, const char *pesquisa) ;
    void mostra_pesquisador(void) ;
  private:
    char pesquisa[64];
};
Pesquisador::Pesquisador(const char *nome, int idade, double salario, const char *pesquisa): Professor(nome, idade, salario) {
  strcpy(Pesquisador::pesquisa, pesquisa);
}
void Pesquisador::mostra_pesquisador(void) {
  mostra_professor();
  cout << "Linha de Pesquisa: " << pesquisa << endl;
}

int main(void) {
  Professor pedro = Professor("Pedro", 56, 3000.00);
  Pesquisador ana = Pesquisador("Ana", 34, 2400.00, "Elementos finitos");
  pedro.mostra_professor();
  ana.mostra_pesquisador();
  return 0;
}
