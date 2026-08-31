#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

#define INPUT_FROM_FILE (0) 
#if INPUT_FROM_FILE
#include <fstream>
#endif

int main(int argc, char **argv){
	double xa, ya, xb, yb, xc, yc, xd, yd;
	

#if INPUT_FROM_FILE
	//std::ifstream ifs("test.txt");
	FILE *fp = fopen("test.txt", "r");
#endif


#if INPUT_FROM_FILE
	while(fscanf(fp, "%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF){
#else
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF){
#endif
		double calc0 = (xb - xa) * (yc - yb) - (xc - xb) * (yb - ya);
		double calc1 = (xc - xb) * (yd - yc) - (xd - xc) * (yc - yb);
		double calc2 = (xd - xc) * (ya - yd) - (xa - xd) * (yd - yc);
		double calc3 = (xa - xd) * (yb - ya) - (xb - xa) * (ya - yd);

		if((calc0 > 0 && calc1 > 0 && calc2 > 0 && calc3 > 0) ||
			(calc0 < 0 && calc1 < 0 && calc2 < 0 && calc3 < 0)){
			std::cout << "YES" << std::endl;
		}
		else{
			std::cout << "NO" << std::endl;
		}
	}

	return 0;
}
