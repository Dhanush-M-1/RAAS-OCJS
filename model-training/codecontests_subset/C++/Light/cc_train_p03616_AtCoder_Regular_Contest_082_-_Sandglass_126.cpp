#include <bits/stdc++.h>
using namespace std;
typedef long long LL;

int main(){
	LL x, k;
	cin >> x >> k;
	LL r[k];
	for(int i = 0; i < k; i++) cin >> r[i];
	LL q;
	cin >> q;
	vector<LL> t;
	vector<LL> a;
	for(int i = 0; i < q; i++){
		LL p, r;
		cin >> p >> r;
		t.push_back(p);
		a.push_back(r);
	}

	LL minv = 0;
	LL maxv = x;
	LL dx = 0;
	LL sgn = -1;

	LL s1 = 0;
	LL s2 = 0;
	LL lastt = 0;
	while(s2 < t.size()){
		if(s1 == k || t[s2] < r[s1]){
			// answer
			LL f = max(minv, min(maxv, a[s2] + dx));
			f += sgn*(t[s2] - lastt);
			f = max(0LL, min(x, f));
			cout << f << endl;
			s2++;
		} else {
			LL diff = r[s1] - lastt;
			diff *= sgn;
			minv += diff;
			maxv += diff;
			dx += diff;
			minv = max(0LL, min(x, minv));
			maxv = max(0LL, min(x, maxv));
			sgn *= -1;
			lastt = r[s1];
			s1++;
			//cout << minv << " " << maxv << " " << dx << " " << sgn << endl;
		}
	}
}
