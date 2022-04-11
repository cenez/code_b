#include <iostream>

using namespace std;

int main(void) {
  char escolha;
  while(true) {
    cout << "\nMenu: [A]dicionar [D]eletar [O]rdenar [S]air : ";
    cin >> escolha;
    switch(std::toupper(escolha)) {
      case 'A':
        cout << "Voce selecionou adicionar\n";
        break;
      case 'D':
        cout << "Voce selecionou deletar\n";
        break;
      case 'O':
        cout << "Voce selecionou ordenar\n";
        break;
      case 'S':
        exit(0);
      default:
        cout << "Tecla invalida. Tente novamente!\n";
    }
  }
  return 0;
}
