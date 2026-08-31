#include <iostream>
#include <complex>
using namespace std;

constexpr double EPS = 1e-10;
using Point = complex<double>;
double cross(Point p, Point q) { return (conj(p) * q).imag(); }

int main() {
    cin.tie(0); ios_base::sync_with_stdio(false);
    double a,b,c,d,e,f,g,h;
    char z;
    while(cin>>a>>z>>b>>z>>c>>z>>d>>z>>e>>z>>f>>z>>g>>z>>h) {
        Point p1(a,b),p2(c,d),p3(e,f),p4(g,h);
        if(cross(p3-p1,p2-p1)*cross(p4-p2,p3-p2) > 0 && cross(p1-p3,p4-p3) * cross(p2-p4, p1-p4) > 0){
            cout << "YES" << '\n';
        } else {
            cout << "NO" << '\n';
        }
    }

    return 0;
}
