#include<iostream>
#include<stdio.h>
#include<cmath>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;
int main(){
	double xa, ya, xb, yb, xc, yc, xd, yd,s1,s2,s3,s4;
	while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xa,&ya,&xb,&yb,&xc,&yc,&xd,&yd)!=EOF) {
		s1=abs((xc - xa)*(yb - ya) - (xb - xa)*(yc - ya));
		s2 = abs((xc - xa)*(yd - ya) - (xd - xa)*(yc - ya));
		s3 = abs((xb - xa)*(yd - ya) - (xd - xa)*(yb - ya));
		s4 = abs((xb - xc)*(yd - yc) - (xd - xc)*(yb - yc));
		if (s1 + s2 == s3 + s4) {
			cout << "YES" << endl;
		}
		else {
			cout << "NO" << endl;
		}
	}
	return 0;
}