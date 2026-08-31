#include <iostream>
#include <cstdio>
#include <complex>

bool read_data(std::complex<double>* points)
{
	double coords[8];
	for (int i = 0; i < 8; ++i) {
		if (scanf((i==0) ? "%lf" : ",%lf", &coords[i]) != 1) {
			return false;
		}
	}
	for (int i = 0; i < 4; ++i) {
		points[i] = std::complex<double>(coords[i*2], coords[i*2+1]);
	}
	return true;
}


int main()
{
	std::complex<double> points[4];
	while (read_data(points)) {
		double imag[4] = {};
		for (int i = 0; i < 4; ++i) {
			imag[i] = ((points[(i+2)%4]-points[(i+1)%4])/(points[i%4]-points[(i+1)%4])).imag();
		}
		if ((imag[0] > 0 && imag[1] > 0 && imag[2] > 0 && imag[3] > 0) || 
			(imag[0] < 0 && imag[1] < 0 && imag[2] < 0 && imag[3] < 0))
		{
			std::cout << "YES\n";
		} else {
			std::cout << "NO\n";
		}
	}

	return 0;
}