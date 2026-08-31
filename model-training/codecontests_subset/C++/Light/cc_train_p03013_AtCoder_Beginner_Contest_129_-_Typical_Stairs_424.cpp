#include <bits/stdc++.h>
#define MOD 1000000007
#define rep(i,x,n) for(int i=x; i<n; i++)
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);cin.tie(nullptr);
	int N, M;
	cin>>N>>M;
	vector<int> D(N+1);
	rep(i, 0, M) {
		int x;
		cin>>x;
		D[x]=-1;
	}
	D[0]++, D[1]++;
	rep(i, 2, N+1) D[i]=~D[i] ? (D[i-1]+D[i-2])%MOD : 0;
	cout<<D[N];
}