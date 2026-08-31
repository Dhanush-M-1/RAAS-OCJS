#include <bits/stdc++.h>
using namespace std;
int n ,m;
map<int,bool>broken;
long long mem[100005];
long long mod =1e9+7;
int main() {
	cin>>n>>m;
	for(int i = 0; i < m ; i++){
		int x ;cin>>x;
		broken[x] = true;
	}
	mem[0] = 1;if(!broken[1])mem[1] = 1;
	for(int i = 2 ; i<= n; i++){
		if(broken[i])
			continue;
		mem[i]+=(mem[i-1] + mem[i-2])%mod;
	}
	cout<<mem[n];
    return 0;
}
