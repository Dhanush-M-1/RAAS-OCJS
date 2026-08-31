#include <cstdio>
#include <iostream>
#include <complex>

using namespace std;

#define X real()
#define Y imag()
typedef double D;
typedef complex<D> P;
#define EPS (1e-9)

inline D inprd(const P &a, const P &b){ return (conj(a) * b).X; }
inline D outprd(const P &a, const P &b){ return (conj(a) * b).Y; }
inline D sign(D d){ return (d<0)?-1:d>0?1:0; }

int main(){
    string s;
    while(getline(cin, s)){
        double xa,ya,xb,yb,xc,yc,xd,yd;
        sscanf(s.c_str(), "%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd); 
        P a(xa,ya), b(xb,yb), c(xc,yc), d(xd,yd);

        double sa = sign(outprd(b-a, d-a));
        double sb = sign(outprd(c-b, a-b));
        double sc = sign(outprd(d-c, b-c));
        double sd = sign(outprd(a-d, c-d));
        if(sa == sb && sb == sc && sc == sd){
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    return 0;
}