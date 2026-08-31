#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <algorithm>
#include <utility>
#include <queue>
#include <set>
#include <map>

using namespace std;
typedef  long long ll;
typedef pair<int,int> PII;
typedef vector<int> VI;
typedef vector<VI> VVI;
#define  MP make_pair
#define  PB push_back
#define inf  1000000007


int main(){
	ll n,m,a,b,p,q;
	cin >> n >> m >> a >> b >> p >> q;
	if(a==1&&b==1){
		ll ans = m;
		ll x = p+q;
		ll y = m/x;
		if(y>=n){
			ans = min(ans,m-x*n);
			cout << ans << endl;
		}else{
			ans = min(ans,m-(x*y));
			ans = min(ans,x-ans);
			cout << ans << endl;
		}
		return 0;
	}
	vector<ll> r1,r2;
	r1.push_back(1);
	r2.push_back(1);
	if(p+q >= m){
		cout << min(m,p+q-m) << endl;
		return 0;
	}
	for(int i=1;i<n;i++){
		r1.PB(r1[i-1]*a);
		r2.PB(r2[i-1]*b);
		if(p*r1[i]+q*r2[i]>=m){
			n=i+1;
		}
	}
	ll ans=m;
	if(p*r1[n-1]+q*r2[n-1]>=m){
		ans = min(ans,p*r1[n-1]+q*r2[n-1]-m);
		n--;
	}
	vector<ll> s1,s2,t1,t2;
	const ll mae = n/2;
	const ll usi = n - mae;
	for(int i=0;i<n/2;i++){
		s1.push_back(p*r1[i]+q*r2[i]);
	}
	for(int i=n/2;i<n;i++){
		s2.push_back(p*r1[i]+q*r2[i]);	
	}
	/*for(int i=0;i<mae;i++){
		cout << s1[i] << endl;
	}
	cout << endl;
	for(int i=0;i<usi;i++){
		cout << s2[i] << endl;
	}*/
	for(ll i=0;i<(1LL<<(mae));i++){
		ll s = 0;
		for(ll j=0;j<mae;j++){
			if(i&(1LL<<j)){
				s += s1[j];
			}
		}
		t1.push_back(s);
	}
	for(ll i=0;i<(1LL<<(usi));i++){
		ll s = 0;
		for(ll j=0;j<usi;j++){
			if(i&(1LL<<j)){
				s += s2[j];
			}
		}
		t2.push_back(s);
	}
	sort(t1.begin(),t1.end());
	sort(t2.begin(),t2.end());
	/*for(int i=0;i<t1.size();i++){
		cout << t1[i] << endl;
	}
	for(int i=0;i<t2.size();i++){
		cout << t2[i] << endl;
	}*/
	for(int i=0;i<t1.size();i++){
		int k = lower_bound(t2.begin(),t2.end(),m-t1[i])-t2.begin()-1;
		ans = min(ans,abs(m-t1[i]-t2[k]));
		if(k+1<t2.size()){
			ans = min(ans,abs(m-t1[i]-t2[k+1]));
		}	
	}
	cout << ans << endl;
	return 0;
}