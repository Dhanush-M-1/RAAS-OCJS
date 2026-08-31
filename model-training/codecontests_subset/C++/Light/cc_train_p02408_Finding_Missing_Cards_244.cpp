#include <iostream>
using namespace std;
int main () {
	int n, a[4][13]={0}, b;
	char x[4]={'S','H','C','D'}, y;
	cin >> n;
	for(int i=0; i<n; i++) {
		cin >> y;
		for (int j=0; j<4; j++){
			if (y==x[j]) {
				cin >> b;
				a[j][b-1]=1;
			}
		}
	}
	for (int k=0;k<4;k++){
		for (int l=0;l<13;l++){
			if (a[k][l]==0) cout << x[k] << ' ' << l+1 << endl;
		}
	}
}
