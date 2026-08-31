#include <bits/stdc++.h>
#define int long long
#define INF 2e+12
using namespace std;

signed main(){
	int n,m,a,b,p,q,mi;
	vector<int> vec,num;
	cin >> n >> m >> a >> b >> p >> q;
	mi = m;
	if(a == 1 && b == 1){
		if(p + q >= (m + n - 1) / n) cout << min(m % (p + q),p + q - m % (p + q)) << endl;
		else cout << m - (p + q) * n << endl;
		return 0;
	}
	int ta = p,tb = q;
	for(int i = 0;i < n;i++){
		if(ta + tb > INF) break;
		vec.push_back(ta + tb);
		if(ta > (INF + a - 1) / a || tb > (INF + b - 1) / b) break;
		ta *= a;
		tb *= b;
	}
	n = vec.size();
	for(int i = 0;i < (1 << (n / 2));i++){
		int sum = 0;
		for(int j = 0;j < n / 2;j++){
			if((i >> j) & 1) sum += vec[j];
		}
		num.push_back(sum);
	}
	sort(num.begin(),num.end());
	for(int i = 0;i < (1 << ((n + 1) / 2));i++){
		int sum = 0;
		for(int j = 0;j < (n + 1) / 2;j++){
			if((i >> j) & 1) sum += vec[j + n / 2];
		}
		int ind = upper_bound(num.begin(),num.end(),m - sum) - num.begin() - 1;
		if(ind >= 0) mi = min(mi,m - sum - num[ind]);
		if(ind + 1 < n) mi = min(mi,-(m - sum - num[ind + 1]));
	}
	cout << mi << endl;
	return 0;
}
