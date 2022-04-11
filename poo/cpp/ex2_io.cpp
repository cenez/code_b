#include <iostream>
using namespace std;

int main(int argc, char **argv) {
	char letra;
	int x, op = 2;

	std::string linha;
	std::getline(std::cin, linha);
	cout << linha << "\n";

	char str[128];
	cin.getline(str, sizeof(str));
	cout << "count: " << cin.gcount() << " : " << str << '\n';
	while (op == 0 && !cin.eof()) {
		letra = cin.get();
		letra = toupper(letra);
		cout << letra;
	}
	while(op==1 && cin >> x) {
		cout << "Digitou: " << x << "\n";
	}
	for (letra = 'A'; letra <= 'Z'; letra++)
		cout.put(letra);
	return 0;
}
