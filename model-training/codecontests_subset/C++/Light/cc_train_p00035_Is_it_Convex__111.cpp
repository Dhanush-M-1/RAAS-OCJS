#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int main(){
	double a[2],b[2],c[2],d[2];
	double atob[2],btoc[2],ctod[2],dtoa[2];
	double edge_ab,edge_bc,edge_cd,edge_da;
	double angle_a,angle_b,angle_c,angle_d;
	for(;;){
		if(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&a[0],&a[1],&b[0],&b[1],&c[0],&c[1],&d[0],&d[1]) == EOF){break;}
		atob[0] = b[0]-a[0];
		atob[1] = b[1]-a[1];
		btoc[0] = c[0]-b[0];
		btoc[1] = c[1]-b[1];
		ctod[0] = d[0]-c[0];
		ctod[1] = d[1]-c[1];
		dtoa[0] = a[0]-d[0];
		dtoa[1] = a[1]-d[1];
		edge_ab = sqrt(atob[0]*atob[0]+atob[1]*atob[1]);
		edge_bc = sqrt(btoc[0]*btoc[0]+btoc[1]*btoc[1]);
		edge_cd = sqrt(ctod[0]*ctod[0]+ctod[1]*ctod[1]);
		edge_da = sqrt(dtoa[0]*dtoa[0]+dtoa[1]*dtoa[1]);
		angle_a = acos(-(atob[0]*dtoa[0]+atob[1]*dtoa[1])/(edge_ab*edge_da));
		angle_b = acos(-(btoc[0]*atob[0]+btoc[1]*atob[1])/(edge_bc*edge_ab));
		angle_c = acos(-(ctod[0]*btoc[0]+ctod[1]*btoc[1])/(edge_cd*edge_bc));
		angle_d = acos(-(dtoa[0]*ctod[0]+dtoa[1]*ctod[1])/(edge_da*edge_cd));
		if(angle_a+angle_b+angle_c+angle_d >6.28318 && angle_a+angle_b+angle_c+angle_d <6.28319){cout <<"YES"<<endl;}
		else{cout<<"NO"<<endl;}
	}
}