#include <iostream>

struct Vec {
    double x;
    double y;

    double operator*(Vec& vec)
    {
        return (x * vec.y - y * vec.x);
    }
};

int sgn(double x);

int main()
{
    double x1, y1, x2, y2, x3, y3, x4, y4;
    char ch;

    while (std::cin >> x1 >> ch >> y1 >> ch >> x2 >> ch >> y2 >> ch
                    >> x3 >> ch >> y3 >> ch >> x4 >> ch >> y4) {
        Vec vec12{x2 - x1, y2 - y1};
        Vec vec23{x3 - x2, y3 - y2};
        Vec vec34{x4 - x3, y4 - y3};
        Vec vec41{x1 - x4, y1 - y4};

        double cross01 = vec12 * vec23;
        double cross02 = vec23 * vec34;
        double cross03 = vec34 * vec41;
        double cross04 = vec41 * vec12;
        int judge = sgn(cross01) + sgn(cross02) + sgn(cross03) + sgn(cross04);

        if (judge == 1 + 1 + 1 + 1 || judge == -1 - 1 - 1 - 1) {
            std::cout << "YES" << std::endl;
        } else {
            std::cout << "NO" << std::endl;
        }
    }

    return 0;
}

int sgn(double x)
{
    return ((x >= 0)? 1: (-1));
}