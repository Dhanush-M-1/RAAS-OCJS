#include <iostream>
#include <complex>

using namespace std;

typedef complex<double> P;

double cross(P a, P b){
  return a.real() * b.imag() - a.imag() * b.real();
}

double dot(P a, P b){
  return a.real() * b.real() + a.imag() * b.imag();
}

int ccw(P a, P b, P c){
  b -= a; c -= a;
  if(cross(b, c) > 0) return 1;
  if(cross(b, c) < 0) return -1;
  if(dot(b, c) < 0) return 2;
  if(norm(b) < norm(c)) return -2;
  return 0;
}

int main()
{
  char j;
  double a,b,c,d,e,f,g,h;
  for(;cin>>a>>j>>b>>j>>c>>j>>d>>j>>e>>j>>f>>j>>g>>j>>h;)
    {
      P x(a,b),y(c,d),z(e,f),p(g,h);
      if(ccw(x,y,z)==ccw(y,z,p) && ccw(y,z,p) == ccw(z,p,x)
	 && ccw(z,p,x) == ccw(p,x,y))
	cout<<"YES"<<endl;
      else
	cout<<"NO"<<endl;
    }
}