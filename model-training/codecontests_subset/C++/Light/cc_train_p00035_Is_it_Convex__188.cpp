#include <iostream>

using namespace std;

int main()
{
	double x[4], y[4];
	char dummy;
	
	while ( cin >> x[0] >> dummy >> y[0] >> dummy >> x[1] >> dummy >> y[1] >> dummy >> x[2] >> dummy >> y[2] >> dummy >> x[3] >> dummy >> y[3] ) {
		bool isClockwise;
		if ( x[0] != x[1] ) {
			isClockwise = ((y[2] - y[0]) * (x[1] - x[0]) < (y[1] - y[0]) * (x[2] - x[0]));
		}
		//else if ( x[0] > x[1] ) {
		//	isClockwise = ((y[2] - y[0]) * (x[1] - x[0]) > (y[1] - y[0]) * (x[2] - x[0]));
		//}
		else {
			isClockwise = ((x[2] > x[1]) == (y[1] > y[0]));
		}
		
		//cout << "isClockwise = " << isClockwise << endl;
		
		bool isConvex = true;
		for (int i=1; i<4; i++) {
			if ( x[i] != x[(i+1)%4] ) {
				if ( ((y[(i+2)%4] - y[i]) * (x[(i+1)%4] - x[i]) < (y[(i+1)%4] - y[i]) * (x[(i+2)%4] - x[i])) != isClockwise ) { isConvex = false; break; }
			}
			//else if ( x[i] > x[(i+1)%4] ) {
			//	if ( ((y[(i+2)%4] - y[i]) * (x[(i+1)%4] - x[i]) > (y[(i+1)%4] - y[i]) * (x[(i+2)%4] - x[i])) != isClockwise ) { isConvex = false; break; }
			//}
			else {
				if ( ( (x[(i+2)%4] > x[(i+1)%4]) == (y[(i+1)%4] > y[i]) ) != isClockwise ) { isConvex = false; break; }
			}
			//cout << i << endl;
		}
		if (isConvex) cout << "YES" << endl;
		else cout << "NO" << endl;
	}
	
	return 0;
}