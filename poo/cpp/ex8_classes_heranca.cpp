#include <iostream>
using namespace std;

/* Variaveis globais */
int contador = 1;

/* Classe Ponto2D */
class Ponto2D {
  public:
    Ponto2D(double x, double y);
    ~Ponto2D();
  protected:
    double fx;
    double fy;
    int id = contador++;
};
Ponto2D::Ponto2D(double x, double y) {
  fx = x;
  fy = y;
  //std::cout << "\n ****** Construtor Ponto2D(" << id << ") ******** \n";
}
Ponto2D::~Ponto2D() {
  std::cout << "\n ****** Destrutor Ponto2D(" << id << ") ******** \n";
}

/* Classe Ponto3D herda de Ponto2D */
class Ponto3D : public Ponto2D {
  public:
    Ponto3D(double x, double y, double z);
    ~Ponto3D();
    double coord_x() { return fx; }
    double coord_y() { return fy; }
    double coord_z() { return fz; }
  private:
    double fz;
};
Ponto3D::Ponto3D(double x, double y, double z): Ponto2D(x, y) {
  fz = z;
  //std::cout << "\n ****** Construtor Ponto3D(" << id << ") ******** \n";
}
Ponto3D::~Ponto3D() {
  std::cout << "\n ****** Destrutor Ponto3D(" << id << ") ******** \n";
}

/* Funcao principal de inicio */
int main(void) {
  double x,y,z;
  cout << "Coordenadas: " << "\n" << "x = ";
  cin >> x;
  cout << "y = ";
  cin >> y;
  cout << "z = ";
  cin >> z;
  Ponto3D *c = new Ponto3D(x,y,z);
  cout << "(" << c->coord_x() << "," << c->coord_y() << ",";
  cout << c->coord_z() << ")" << endl;

  Ponto3D d = Ponto3D(x,y,z);
  cout << "(" << d.coord_x() << "," << d.coord_y() << ",";
  cout << d.coord_z() << ")" << endl;

  delete(c);

  return 0;
}
