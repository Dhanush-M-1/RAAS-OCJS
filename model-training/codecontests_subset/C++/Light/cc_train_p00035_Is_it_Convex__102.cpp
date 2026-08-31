#include<iostream>

struct Point
{
	double x;

	double y;
};

double Abs(double x)
{
	return x>=0 ? x : -x; 
}

double Square(const Point& P, const Point& Q, const Point& R)
{
	Point A = {Q.x-P.x, Q.y-P.y};

	Point B = {R.x-P.x, R.y-P.y};

	return Abs(A.x*B.y-A.y*B.x); 
}

bool JudgeS(const Point& P, const Point& Q, const Point R, const Point O)//P,Q,R,Sが四角形になる准に
{
	return (Square(P, Q, R) > Square(O, P, Q) + Square(Q, R, O));
}

int main()
{
	Point A, B, C, D;

	char c;

	while(std::cin >> A.x >> c >> A.y >> c >> B.x >> c >> B.y >> c 
			>> C.x >> c >> C.y >> c >> D.x >> c >> D.y)
	{
		if(JudgeS(A,B,C,D) || JudgeS(B,C,D,A) || JudgeS(C,D,A,B) || JudgeS(D,A,B,C))
		{
			std::cout << "NO\n";
		}
		else
		{
			std::cout << "YES\n";
		}
	}
}