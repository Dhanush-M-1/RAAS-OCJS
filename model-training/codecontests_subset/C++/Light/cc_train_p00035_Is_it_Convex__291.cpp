#include<iostream>
#include<vector>
#include<string>
#include<cmath>
#include<numeric>
#include<complex>
#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define rep(i,n) for(int i=0;i<n;i++)
#define repn(i,n) for(int i=1;i<=n;i++)
#define reps(i,s,n) for(int i=s;i<n;i++)
using namespace std;
typedef long long ll;
typedef long double ld;

typedef complex<double> P;
int main(){
  IOS;
  // ld a[2],b[2],c[2],d[2]

  ld x,y;
  char c;
  P p[4];
  while(1){
    int che=0;
    rep(i,4){
      // cin>>x>>c>>y;
      if(!((cin>>x).ignore()>>y).ignore()) return 0;
      p[i]=P(x,y);
    }
    bool a[2]={};
    rep(i,4){
      // cout<<i<< " "<<p[i]<<endl;
      P c=p[i]-p[(i+1)%4], d=p[(i+1)%4]-p[(i+2)%4];
      // cout<< c<<" "<<d<<endl;
      // cout<<i<<c<<d<<endl;
      if(c.real()*d.imag()-c.imag()*d.real()>0){
        che+=1;
        // cout<<i<<c<<d<<endl;
      }
      // cout<<a[0]<<" "<<a[1]<<endl;
    }
    cout << ((che<4&&che>0)?"NO":"YES")<<endl;
  }
  return 0;
}
