#include <iostream>
using namespace std;

int abs(int a){
	return 0 <= a ? a : -a;
}

int main(){
	int n, m;
	cin >> n >> m;
	int a[n], b[n], c[m], d[m];
	for(int i = 0; i < n; i++) cin >> a[i] >> b[i];
	for(int i = 0; i < m; i++) cin >> c[i] >> d[i];
	for(int i = 0; i < n; i++){
		int dist = 1e9, ans;
		for(int j = 0; j < m; j++) if(abs(a[i] - c[j]) + abs(b[i] - d[j]) < dist){
			dist = abs(a[i] - c[j]) + abs(b[i] - d[j]);
			ans = j + 1;
		}
		cout << ans << endl;
	}
}