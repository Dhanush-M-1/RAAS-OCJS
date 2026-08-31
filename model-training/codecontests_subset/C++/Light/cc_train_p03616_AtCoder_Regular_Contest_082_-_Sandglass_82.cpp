#include <iostream>
#include <vector>
#include <algorithm>
#define int long long
#define rep(i, n) for (i = 0; i < n; i++)
using namespace std;
typedef pair<int, int> P;

int X, K;
int r[100000];
int Q;
int t[100000], a[100000];
vector<P> query;	//(時刻, 内容(-1:ひっくり返す, a[i](>=0):求める))

signed main() {
	int i;
	
	cin >> X >> K;
	rep(i, K) cin >> r[i]; cin >> Q; rep(i, Q) cin >> t[i] >> a[i];
	rep(i, K) query.push_back(P(r[i], -1));
	rep(i, Q) query.push_back(P(t[i], a[i]));
	sort(query.begin(), query.end());
	
	int l = 0, r = X, b = 0, c = X;
	int dx = -1, prevT = 0;
	
	rep(i, query.size()) {
		int qt = query[i].first;
		int qa = query[i].second;
		
		//更新
		if (dx == -1) {
			int cnt1 = min(b, qt - prevT);
			int cnt2 = qt - prevT - cnt1;
			b -= cnt1;
			c -= cnt1 + cnt2; if (c < b) c = b;
			l = min(l + cnt2, r);
		}
		else {
			int cnt1 = min(X - c, qt - prevT);
			int cnt2 = qt - prevT - cnt1;
			c += cnt1;
			b += cnt1 + cnt2; if (b > c) b = c;
			r = max(r - cnt2, l);
		}
		prevT = qt;
		
		//cout << "debug[l, r, b, c, dx, prevT, qa] = [" << l << ", " << r << ", " << b << "," << c << ", " << dx << ", " << prevT << ", "<< qa << "]" << endl;
		//クエリ
		if (qa == -1) {
			dx *= -1;
		}
		else {
			if (qa <= l) cout << b << endl;
			else if (qa >= r) cout << c << endl;
			else cout << b + (qa - l) << endl;
		}
	}
	return 0;
}