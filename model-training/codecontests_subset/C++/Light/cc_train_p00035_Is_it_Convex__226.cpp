#include<iostream>
#include<cmath>
struct vector
{
	double x, y;
	double norm()
	{
		return hypot(x, y);
	}
	vector operator-(vector v)
	{
		vector result;
		result.x = x - v.x;
		result.y = y - v.y;
		return result;
	}
	double operator*(vector v)
	{
		return x * v.x + y * v.y;
	}
};
double area(vector v1, vector v2, vector v3)
{
	vector side1 = v2 - v1, side2 = v3 - v1;
	return sqrt(pow(side1.norm() * side2.norm(), 2) - pow(side1 * side2, 2)) / 2;
}
int main()
{
	while (true)
	{
		vector A, B, C, D;
		char foo;
		std::cin >> A.x >> foo >> A.y >> foo >> B.x >> foo >> B.y >> foo >> C.x >> foo >> C.y >> foo >> D.x >> foo >> D.y;
		if (std::cin.eof())
		{
			break;
		}
		double ABC = area(A, B, C),
			ACD = area(A, C, D),
			BCD = area(B, C, D),
			ABD = area(A, B, D);
		std::cout << (ABC + ACD > ABD && ABC + ACD > BCD && ABD + BCD > ABC && ABD + BCD > ACD ? "YES" : "NO") << std::endl;
	}
	return 0;
}
