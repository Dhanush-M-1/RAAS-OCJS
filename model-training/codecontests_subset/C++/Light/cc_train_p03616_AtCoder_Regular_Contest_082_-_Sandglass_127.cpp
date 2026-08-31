#include "bits/stdc++.h"

#pragma warning(disable:4996)
using namespace std;
using ld = long double;
const ld eps = 1e-9;




int main() {
	int X;cin>>X;
	int K;cin>>K;
	vector<int>rs(K+1);
	vector<int>as(K+1),bs(K+1,X);

	int pre=0;
	int a=0;
	int b=0;
	
	for (int i = 0; i < K; ++i) {
		cin>>rs[i+1];
		
	}
	vector<int>mins(K+1);
	vector<int>maxs(K+1,X);
	for (int i = 0; i < K; ++i) {
		int sa = rs[i+1]-rs[i];

		if (i % 2 == 0) {
			mins[i + 1] = max(0, mins[i] - sa);
			maxs[i+1]=max(0,maxs[i]-sa) ;
		}
		else {
			maxs[i + 1] = min(X, maxs[i] + sa);
			mins[i+1]=min(X,mins[i]+sa);
		}
	}
	for (int i = 0; i < K; ++i) {
		int sa = rs[i + 1] - rs[i];

		if (i % 2 == 0) {
			int yoyuu=mins[i];
			as[i+1]=as[i]+max(0,sa-yoyuu);
			bs[i+1]=bs[i];
			as[i+1]=min(as[i+1],bs[i+1]);
		}
		else {
			int yoyuu=X-maxs[i];
			as[i+1]=as[i];
			bs[i + 1] = bs[i]-max(0,sa-yoyuu);
			bs[i+1]=max(bs[i+1],as[i+1]);
		}
	}

	int Q;cin>>Q;
	while (Q--) {
		int t,a;cin>>t>>a;
		auto it=prev(upper_bound(rs.begin(),rs.end(),t));

		int x=it-rs.begin();
		int dif=t-*it;

		bool flag=x%2;

		int ans=-1;

		int d;
		if (a < as[x]) {
			d=mins[x];
		}
		else if (a < bs[x]) {
			d=mins[x]+(a-as[x]);
		}
		else {
			d=maxs[x];
		}
		ans=x%2?(d+dif):(d-dif);
		ans=max(0,min(X,ans));
		cout<<ans<<endl;
	}

	return 0;
} 