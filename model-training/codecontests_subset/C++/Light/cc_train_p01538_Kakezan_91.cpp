#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>
using namespace std;

int Q, N, logn, r, l, turn;

int main(){
	cin >> Q;
	for (int i = 0; i < Q; i++){
		cin >> N;
		if (N == 0) logn = 1;
		else logn = int(log10(N)) + 1; //N????????°?????????
		if (logn == 1) cout << 0 << endl;
		else{
			turn = 0;
			while (logn != 1){
				int max = 0;
				for (int j = 0; j < logn - 1; j++){
					r = N % int(pow(10, j + 1)+0.1);
					l = N / int(pow(10, j + 1) + 0.1);
					if (max < r*l){
						max = r*l;
					}
				}
				N = max;
				if (N == 0) logn = 1;
				else logn = int(log10(N)) + 1; //N????????°?????????
				turn++;
			}
			cout << turn << endl;
		}
	}
	return 0;
}