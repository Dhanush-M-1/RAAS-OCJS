//35
#include<iostream>
#include<complex>

using namespace std;

typedef complex<double> P;

int main(){
  for(;;){
    P p[4];
    for(int i=0;i<4;i++){
      double x,y;
      if(!((cin>>x).ignore()>>y).ignore())return 0;
      p[i]=P(x,y);
    }
    bool a[2]={};
    for(int i=0;i<4;i++){
      P c=p[i]-p[(i+1)%4],d=p[(i+1)%4]-p[(i+2)%4];
      a[c.real()*d.imag()-c.imag()*d.real()>0]|=true;
    }
    cout<<((a[0]&a[1])?"NO":"YES")<<endl;
  }
  return 0;
}