#include <iostream>

using namespace std;

long fibo(long n) {
  if (n < 2) return abs(n);
  long a = 0;
  long b = 1;
  long c = a + b;
  for (int i = 3; i <= n; i++) {
    a = b;
    b = c;
    c = a + b;
  }
  return c;
}
int main(void) {
  int n = 4;
  cout << fibo(n) << endl;
  return 0;
}
