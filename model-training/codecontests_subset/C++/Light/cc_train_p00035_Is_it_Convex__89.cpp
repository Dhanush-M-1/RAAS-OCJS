#include <iostream>
#include <array>

int main()
{
	std::array<double, 4> x;
	std::array<double, 4> y;
	char comma;
	while (std::cin >> x[0] >> comma >> y[0]) {
		for (std::size_t i = 1; i < 4; ++i) {
			std::cin >> comma >> x[i] >> comma >> y[i];
		}
		if ((((y[1] - y[0]) * (x[0] - x[2]) - (y[0] - y[2]) * (x[1] - x[0])) *
			 ((y[3] - y[0]) * (x[0] - x[2]) - (y[0] - y[2]) * (x[3] - x[0])) < 0) and
			(((y[0] - y[1]) * (x[1] - x[3]) - (y[1] - y[3]) * (x[0] - x[1])) *
			 ((y[2] - y[1]) * (x[1] - x[3]) - (y[1] - y[3]) * (x[2] - x[1])) < 0)) {
			std::cout << "YES" << std::endl;
		}
		else {
			std::cout << "NO" << std::endl;
		}
	}
	return 0;
}