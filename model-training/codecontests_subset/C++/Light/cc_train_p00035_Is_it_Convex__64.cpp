#include<iostream>
#include<complex>
#include<cstdio>
#define EPS 1.0e-10
using namespace std;
typedef complex<double> P;
P a[4];
double cross(P a, P b) {
  return (a.real() * b.imag() - a.imag() * b.real());
}
int is_intersected_ls(P a1, P a2, P b1, P b2) {
  return ( cross(a2-a1, b1-a1) * cross(a2-a1, b2-a1) < EPS ) &&
         ( cross(b2-b1, a1-b1) * cross(b2-b1, a2-b1) < EPS );
}
int main(){
	double x,y;
	char c;
	while(scanf("%lf,%lf",&x,&y)!=EOF){
		a[0]=P(x,y);
		for(int i=1;i<4;i++){
			scanf(",%lf,%lf",&x,&y);;
			a[i]=P(x,y);
		}
		if(is_intersected_ls(a[0],a[2],a[1],a[3]))
		cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
	return 0;
}