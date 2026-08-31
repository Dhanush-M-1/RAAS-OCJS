
#include "math.h"
#include "stdio.h"
#include <algorithm>
#include <string>
#include <map>
#include <iostream>

using namespace std;

/** Problem0035 : It is Convex? **/
double calcS(double x1, double y1, double x2, double y2, double x3, double y3)
{
	double S, s, ab, bc, ca;
	ab = sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	bc = sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
	ca = sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
	s = 0.5*(ab+bc+ca);
	S=sqrt(s*(s-ab)*(s-bc)*(s-ca));
	return S;
}

int main()
{
	double x1, y1, x2, y2, x3, y3, x4, y4;
	char c;
	
	while (1) {
		cin >> x1 >> c >> y1 >> c >> x2 >> c >> y2 >> c >> x3 >> c >> y3 >> c >> x4 >> c >> y4;
		if (cin.eof()) break;
		
		if (fabs((calcS(x1,y1,x2,y2,x3,y3)+calcS(x1,y1,x4,y4,x3,y3)) - (calcS(x2,y2,x3,y3,x4,y4)+calcS(x2,y2,x1,y1,x4,y4))) <= 0.01)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
	return 0;
}