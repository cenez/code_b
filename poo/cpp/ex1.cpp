#include <iostream>
#include <iomanip>
//Obs para o namespace abaixo, podemos remover?
//Eh necessario std::ALGO se deixarmos a linha abaixo?
using namespace std;

int main(int argc, char *argv[]) {
	std::cout << std::setiosflags(std::ios::fixed) << 234.45 << std::endl;
	std::cout << 23445.8967 << std::endl;
	std::cout << std::resetiosflags(std::ios::fixed);
	std::cout << std::setiosflags(std::ios::scientific);
	std::cout << 234.45 << std::endl;
	std::cout << std::setprecision(4);
	std::cout << 23445.8967 << std::endl;
	return 0;
}




