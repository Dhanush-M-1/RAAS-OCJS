#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
vector<bool> used;
int main(){
	int n, m;
	cin>>n>>m;
	int d0 = 0, d1 = 1, d2;
	int i = 1;
	for(int j = 0; j <= m; ++j){
		int i1;
		if(j < m)cin>>i1;
		else i1 = n + 1;
		for(; i < i1 ;++i){
			d2 = d0 + d1;
			if(d2 >= MOD)d2 -= MOD;
			d0 = d1; d1 = d2;
		}
		d0 = d1;
		d1 = 0;
		i++;
	}
	cout<<d0<<endl;	
	return 0;
}
