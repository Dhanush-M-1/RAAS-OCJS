#include<iostream>
#include <cstdio>
using namespace std;

int main(){
	int n, a[52],f;
	char suit[52];
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> suit[i] >> a[i];
	}
	char suitX[] = {'S','H','C','D'};
	//cout << suitX[1]<<endl;
	//cout << suit[5] << "   " << a[5]<<endl;
	for (int s = 0; s < 4; s++){
		for (int t = 1; t < 14; t++){
			f = 0;
			for (int i = 0; i < n; i++){
				if (suitX[s] == suit[i] && t == a[i])f++;
			}
			if (f == 0)cout << suitX[s] << ' ' << t << endl;
		}
	}
	return 0;
}
