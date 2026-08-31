#include <bits/stdc++.h>
#define rep(i,n) for (int i = 0; i< (n); i++)
using ll = long long;
using namespace std;

int main(){
	int N, M;
	cin >> N >> M;
	int a[N], b[N];
	int c[M], d[M];
	rep(i,N) cin >> a[i] >> b[i];
	rep(i,M) cin >> c[i] >> d[i];

	rep(i,N) {
		int dist_min = 1e9;
		int cp;
		rep(j,M) {
			int dist = abs(a[i]-c[j]) + abs(b[i]-d[j]);
			if (dist < dist_min) {
				dist_min = dist;
				cp = j+1;
			}
		}
		cout << cp << endl;
	}
	return 0;
}
