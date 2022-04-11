#include <iostream>
#define NOTA_MAXIMA 10
#define TRUE 1
#define FALSE 0

using namespace std;

const int SEG = 2;

enum cor {RED, GREEN, BLUE};

typedef int booleano;

int main(void) {
  enum cor unemat;
  unemat = RED;
  cout << "COR: " << unemat << endl;

  booleano feliz;
  feliz = TRUE;
  if (feliz)
    cout << "Feliz\n";
  else
    cout << "Triste\n";
  return 0;
}
