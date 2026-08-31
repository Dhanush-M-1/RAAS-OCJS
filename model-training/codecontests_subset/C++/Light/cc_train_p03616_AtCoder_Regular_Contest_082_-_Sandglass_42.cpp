#include <bits/stdc++.h>
typedef long long i64;
using std::cout;
using std::endl;
using std::cin;

int main(){
	int X, k, Q; cin >> X >> k; std::vector<int> r(k + 2, (1 << 30));
	for(int i = 0; i < k; i++) cin >> r[i + 1]; r[0] = 0;
	cin >> Q;
	
	int tap = 0, lis = X; // 潰れヴァリュー
	int low = 0, high = X; // 潰れ判定
	int cnt = 0, sum = 0;
	
	for(int i = 0; i < Q; i++) {
		int t, a; cin >> t >> a;
		
		while(r[cnt + 1] <= t) {
			int d = r[cnt + 1] - r[cnt];
			
			if(cnt % 2) {
				int uku = std::max(0, lis + d - X);
				high -= uku;
		
				tap = std::max(0, std::min(X, tap + d));
				lis = std::max(0, std::min(X, lis + d));
			} else {
				int luz = std::max(0, -(tap - d));
				low += luz;
				
				tap = std::max(0, std::min(X, tap - d));
				lis = std::max(0, std::min(X, lis - d));
			}
			
			cnt += 1;
		}
		
		int d = t - r[cnt];
		if(cnt % 2) {
			if(low <= a and a <= high) cout << std::max(0, std::min(X, tap + a - low + d)) << endl;
		 	else if(a < low) cout << std::max(0, std::min(X, tap + d)) << endl;
			else cout << std::max(0, std::min(X, lis + d)) << endl;
		} else {
			if(low <= a and a <= high) cout << std::max(0, std::min(X, tap + a - low - d)) << endl;
			else if(a < low) cout << std::max(0, std::min(X, tap - d)) << endl;
			else cout << std::max(0, std::min(X, lis - d)) << endl;	
		}
	}
	return 0;
}
