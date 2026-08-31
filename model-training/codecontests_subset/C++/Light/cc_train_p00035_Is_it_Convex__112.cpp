#include <iostream>
#include <complex>
using namespace std;
typedef complex<double> P;
double cross(P a, P b) {return (a.real() * b.imag() - a.imag() * b.real());}
int main(){
  char z;
  double p,q,r,s,t,u,v,w;
  P a,b,c,d;
  while(cin>>p>>z>>q>>z>>r>>z>>s>>z>>t>>z>>u>>z>>v>>z>>w){
  a = P(p,q);b = P(r,s);c = P(t,u);d = P(v,w);
  if ((cross(b-a,c-a)*cross(d-a,c-a))<0&&(cross(a-b,d-b)*cross(c-b,d-b))<0)cout<<"YES"<<endl;
  else cout << "NO" << endl;}
}