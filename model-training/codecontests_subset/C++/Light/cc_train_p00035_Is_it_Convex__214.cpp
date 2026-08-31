#include <iostream>

class Point
{
public:
	double m_X;
	double m_Y;

	Point(double x, double y)
		: m_X( x )
		, m_Y( y )
	{}
	~Point() {}
	double DiffX(const Point& rhs) const
	{
		return(rhs.m_X - m_X);
	}

	double DiffY(const Point& rhs) const
	{
		return(rhs.m_Y - m_Y);
	}
};

class Vec
{
	double m_X;
	double m_Y;

public:
	Vec(Point start, Point end)
		: m_X(end.m_X - start.m_X)
		, m_Y(end.m_Y - start.m_Y)
	{
	}
	~Vec() {}

	double CrossProduct(const Vec& rhs)
	{
		return(m_X*rhs.m_Y - m_Y*rhs.m_X);
	}
};

int main()
{
	double ax, ay, bx, by, cx, cy, dx, dy;
	char s;
	while (std::cin >> ax >> s >> ay >> s >> bx >> s >> by >> s >> cx >> s >> cy >> s >> dx >> s >> dy)
	{
		Point a(ax, ay);
		Point b(bx, by);
		Point c(cx, cy);
		Point d(dx, dy);

		Vec ab(a, b);
		Vec bc(b, c);
		Vec cd(c, d);
		Vec da(d, a);

		double cp_ab = ab.CrossProduct(bc);
		double cp_bc = bc.CrossProduct(cd);
		double cp_cd = cd.CrossProduct(da);
		double cp_da = da.CrossProduct(ab);

		if ( (cp_ab > 0 && cp_bc > 0 && cp_cd > 0 && cp_da > 0) || ((cp_ab < 0 && cp_bc < 0 && cp_cd < 0 && cp_da < 0)) )
		{
			std::cout << "YES" << std::endl;
		}
		else
		{
			std::cout << "NO" << std::endl;
		}
	}

	return 0;
}