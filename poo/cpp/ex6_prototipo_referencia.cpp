#include <iostream>

using namespace std;

double quadrado(double a);

//prototipos
int subtrair1(int x, int y);  // valor
int subtrair2(int& x, int& y); // referencia
void imprime(void);

int main(void) {
  int a = 4, b = 8;
  printf("quadrado(%d): %.2f\n", a, quadrado(a));
  printf("subtrair %d - %d = ", b, a);
  printf("%d\n", subtrair2(a, b));
  printf("a=%d b=%d\n", a, b);
  return 0;
}

double quadrado(double a) {
  return a * a;
}

int subtrair1(int x, int y) {
  int r;
  r = y-x;
  x++;
  y--;
  return r;
}
int subtrair2(int &x, int &y) {
  int r;
  r = y-x;
  x++;
  y--;
  return r;
}
