#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for(int i=0;i<(n);i++)
typedef long long ll;
ll rec(ll a){
	ll m=-1,k=10;
	while(1){
		if(a/k==0)break;
		m=max(m,a/k*(a%k));
		k*=10;
	}
	return m;
}
int main(){
	ll q,n;
	cin>>q;
	while(q--){
		int cnt=0;
		cin>>n;
		while(n>=10){
			n=rec(n);
//			cout<<n<<endl;
			cnt++;
		}
		cout<<cnt<<endl;
	}
}