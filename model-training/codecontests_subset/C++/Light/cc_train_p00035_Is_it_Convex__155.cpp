#include <iostream>

struct vector2 {
    double x, y;
};

bool is_inner_triangle(const vector2 &p, const vector2 &t1, const vector2 &t2, const vector2 &t3)
{
    vector2 p1 = { t1.x - p.x, t1.y - p.y }, p2 = { t2.x - p.x, t2.y - p.y }, p3 = { t3.x - p.x, t3.y - p.y };
    return (p1.x * p2.y - p1.y * p2.x < 0 && p2.x * p3.y - p2.y * p3.x < 0 && p3.x * p1.y - p3.y * p1.x < 0)
        || (p1.x * p2.y - p1.y * p2.x > 0 && p2.x * p3.y - p2.y * p3.x > 0 && p3.x * p1.y - p3.y * p1.x > 0);
}

int main()
{
    while (true) {
        vector2 p[4];
        char comma;
        std::cin >> p[0].x >> comma >> p[0].y;
        for (int i = 1; i < 4; ++i) std::cin >> comma >> p[i].x >> comma >> p[i].y;
        if (std::cin.eof()) break;

        if (is_inner_triangle(p[0], p[1], p[2], p[3]) || is_inner_triangle(p[1], p[2], p[3], p[0])
                || is_inner_triangle(p[2], p[3], p[0], p[1]) || is_inner_triangle(p[3], p[0], p[1], p[2]))
            std::cout << "NO" << std::endl;
        else
            std::cout << "YES" << std::endl;
    }
}