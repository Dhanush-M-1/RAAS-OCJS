#include <cstdio>
#include <cmath>

double Heron(double,double,double);

int main(){
	double x[4],y[4];
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])!=EOF){
		double l01 = sqrt((x[1]-x[0])*(x[1]-x[0])+(y[1]-y[0])*(y[1]-y[0]));
		double l02 = sqrt((x[2]-x[0])*(x[2]-x[0])+(y[2]-y[0])*(y[2]-y[0]));
		double l03 = sqrt((x[3]-x[0])*(x[3]-x[0])+(y[3]-y[0])*(y[3]-y[0]));
		double l12 = sqrt((x[2]-x[1])*(x[2]-x[1])+(y[2]-y[1])*(y[2]-y[1]));
		double l13 = sqrt((x[1]-x[3])*(x[1]-x[3])+(y[1]-y[3])*(y[1]-y[3]));
		double l23 = sqrt((x[3]-x[2])*(x[3]-x[2])+(y[3]-y[2])*(y[3]-y[2]));
		if(fabs((Heron(l01, l12, l02)+Heron(l02, l23, l03))-(Heron(l13, l01, l03)+Heron(l13, l12, l23)))<1){
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}
}

double Heron(double a,double b,double c){
	double s=(a+b+c)/2;
	return sqrt(s*(s-a)*(s-b)*(s-c));
}