#include <iostream>

using namespace std;

int main(void) {
  int *ptr;
  int num = 10;
  ptr = &num;
  *ptr = 20;
  cout << *ptr << endl; //derreferenciacao
  cout << num << endl;


  return 0;
}
