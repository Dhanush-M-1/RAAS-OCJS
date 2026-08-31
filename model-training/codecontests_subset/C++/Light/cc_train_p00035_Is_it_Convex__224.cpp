#include <iostream>
#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

#define EPS (1e-10)

double len(double x1, double y1, double x2, double y2){
	return sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
}
double heron(double a, double b, double c){
	double z = (a+b+c) / 2.0;
	return sqrt(z*(z-a)*(z-b)*(z-c));
}

int main(){
	double x0, x1, x2, x3, y0 ,y1 ,y2, y3;
	double ab, bc, cd ,da, ca, db, abc, bcd, cda, dab, maxS;
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &x0, &y0, &x1, &y1, &x2, &y2, &x3, &y3)){
		ab = len(x0,y0,x1,y1);
		bc = len(x1,y1,x2,y2);
		cd = len(x2,y2,x3,y3);
		da = len(x3,y3,x0,y0);
		ca = len(x0,y0,x2,y2);
		db = len(x1,y1,x3,y3);
		abc = heron(ab, bc, ca);
		bcd = heron(bc, cd, db); 
		cda = heron(cd, da, ca);
		dab = heron(da, ab, db);
		maxS = max(max(abc, bcd), max(cda, dab));
		
		if(fabs(maxS*2.0 - (abc+bcd+cda+dab)) < EPS){
			cout << "NO" << endl;
		}else{
			cout << "YES" << endl; 
		}
	}
	return 0;
}