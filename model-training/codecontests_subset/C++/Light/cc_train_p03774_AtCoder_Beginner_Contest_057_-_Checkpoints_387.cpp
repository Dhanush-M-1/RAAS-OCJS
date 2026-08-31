#include <bits/stdc++.h>
using namespace std;

int n, m, b, c, sx[50], sy[50], cx[50], cy[50];
int main(){
	cin >> n >> m;
	for(int i = 0; i < n; i++) cin >> sx[i] >> sy[i];
	for(int i = 0; i < m; i++) cin >> cx[i] >> cy[i];
	for(int i = 0; i < n; i++){
		b = INT_MAX;
		for(int j = 0; j < m; j++){
			if(abs(sx[i]-cx[j])+abs(sy[i]-cy[j]) < b){
				b = abs(sx[i]-cx[j])+abs(sy[i]-cy[j]);
				c = j+1;
			}
		}
		cout << c << "\n";
	}
}