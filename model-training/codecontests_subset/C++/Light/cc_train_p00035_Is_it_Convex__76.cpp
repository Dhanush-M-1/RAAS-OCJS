#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <map>
#include <bitset>
#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cmath>

#define X first
#define Y second
#define dis(a, b) (b.X - a) * (b.X - a) + (b.Y - a) * (b.Y - a)

using namespace std;

double cross(pair<double, double> lineA, pair<double, double> lineB){
	return (lineA.X * lineB.Y - lineB.X * lineA.Y) / sqrt(dis(0, lineB));
}

int main(){
	pair<double, double> pointA, pointB, pointC, pointD;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &pointA.X, &pointA.Y, &pointB.X, &pointB.Y, &pointC.X, &pointC.Y, &pointD.X, &pointD.Y) != EOF){
		vector<pair<double, double> > point;
		point.push_back(pointA);
		point.push_back(pointB);
		point.push_back(pointC);
		point.push_back(pointD);
		int count = 0;
		for(int i = 0; i < point.size(); i++){
			pair<double, double> lineA(point[(i + 1) % 4].X - point[i].X, point[(i + 1) % 4].Y - point[i].Y); 
			pair<double, double> lineB(point[(i + 2) % 4].X - point[i].X, point[(i + 2) % 4].Y - point[i].Y);
			cross(lineA, lineB) > 0 ? count++ : count--;
		}

		cout << (count == 4 || count == -4 ? "YES" : "NO") << endl;
	}
	return 0;
}