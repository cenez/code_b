/* Herança Múltipla */
#include <iostream>
#include "poligono.h"
using namespace std;

static int contador = 0;

namespace cnz {
    class Unique {
    protected:
        int id;
    public:
        int hash() { return id; };
        Unique(){
            id = ++contador;
        }
        ~Unique(){
            cout << "Finalizou HashNum!!!" << endl;
        }
    };

    class Retangulo: public Poligono, public Unique {
    protected:
        int side1, side2;
        void print(){ cout << "Meu id: " << this->id << endl; }
    public:
        int area () { return (side1 * side2); }
        void set_sides(int a, int b) { side1 = a; side2 = b; }
        int num_sides() { return 4; }
    };

    class Triangulo: public Poligono, public Unique {
    protected:
        int base, altura;
    public:
        int area () { return (base * altura / 2); }
        void set_base_altura(int b, int a) { base = b; altura= a; }
        int num_sides() { return 3; }
        Triangulo(): Unique(){
            Retangulo *r = new Retangulo;
            //r->print();
        }
    };
}
using namespace cnz;
int main () {
    Retangulo *retangulo = new cnz::Retangulo;
    retangulo->set_sides (10,20);

    Triangulo triangulo;
    triangulo.set_base_altura(15,3);

    cout << retangulo->hash() << endl;
    cout << triangulo.hash() << endl;
    delete retangulo;
    return 0;
}
