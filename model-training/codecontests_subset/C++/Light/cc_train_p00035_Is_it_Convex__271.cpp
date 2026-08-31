#include <iostream>
#include <cmath>
#include <cstdlib>
#include <cstring>
#include <vector>
#include <cstdio>

using namespace std;

struct p{
	double x;
	double y;

	p operator -(p& rh){
		p pnt;
		pnt.x = this->x - rh.x;
		pnt.y = this->y - rh.y;
		return pnt;
	}

	void print(){
		cout << this->x << ", " << this->y << endl;
	}
};

double cross(p a, p b){
	return a.x*b.y - a.y*b.x;
}

bool isLeft(p a, p b, p c){	// c が ab より左ならtrue
	//a.print();
	//b.print();
	//c.print();
	//cout << "cross:" << cross(b-a, c-a) << endl << endl;
	return (cross(b-a, c-a) > 0);
}

bool isInside(p a, p b, p c, p d){ // d が abc 内部なら true
	bool left = false;
	bool right = false;

	bool m, n, l;
	m = isLeft(a, b, d);
	n = isLeft(b, c, d);
	l = isLeft(c, a, d);
	left = m || n || l;
	right = !m || !n || !l;
	
	return left^right;
}

int main(){

	p pnt[4];

	while(scanf("%lf", &pnt[0].x) != EOF){
		scanf(",%lf", &pnt[0].y);
		for(int i = 1; i < 4; i++){
			scanf(",%lf", &pnt[i].x);
			scanf(",%lf", &pnt[i].y);
		}

		bool b = true;

		for(int i = 0; i < 4 && b; i++){
			b &= !isInside(pnt[(i+0)%4], pnt[(i+1)%4], pnt[(i+2)%4], pnt[(i+3)%4]);
		}

		if(b){
			cout << "YES" << endl;
		}else{
			cout << "NO" << endl;
		}
	}

	return 0;
}