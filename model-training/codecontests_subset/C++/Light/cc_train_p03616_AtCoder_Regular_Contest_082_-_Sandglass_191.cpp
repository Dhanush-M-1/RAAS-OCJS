#include <bits/stdc++.h>

using namespace std;

#define REP(i,n) for(ll (i) = (0);(i) < (n);++i)
#define REV(i,n) for(ll (i) = (n) - 1;(i) >= 0;--i)
#define PB push_back
#define EB emplace_back
#define MP make_pair
#define FI first
#define SE second
#define SHOW1d(v,n) {REP(WW,n)cerr << v[WW] << ' ';cerr << endl << endl;}
#define SHOW2d(v,WW,HH) {REP(W_,WW){REP(H_,HH)cerr << v[W_][H_] << ' ';cerr << endl;}cerr << endl;}
#define ALL(v) v.begin(),v.end()
#define Decimal fixed<<setprecision(20)
#define INF 1000000000
#define LLINF 1000000000000000000LL
#define MOD 1000000007

typedef long long ll;
typedef pair<ll,ll> P;


int main(){
	
	ll X,K,Q;cin >> X >> K;
	vector<pair<ll,ll>> v;
	REP(i,K){
		ll r;cin >> r;
		v.EB(r,-1);
	}
	cin >> Q;
	REP(i,Q){
		ll a, b;cin >> a >> b;
		v.EB(a,b);
	}
	
	sort(ALL(v));
	
	ll minX = 0;
	ll minY = 0;
	ll maxX = X;
	ll maxY = X;
	ll type = -1;
	ll nowT = 0;
	
	REP(i,v.size()){
		minY += type * (v[i].FI - nowT);
		if(minY < 0){
			minX -= minY;
			minY = 0;
		}
		if(minY > X)minY = X;
		maxY += type * (v[i].FI - nowT);
		if(maxY > X){
			maxX -= (maxY - X);
			maxY = X;
		}
		if(maxY < 0)maxY = 0;
		maxX = max(maxX,minX);
		
		if(v[i].SE == -1)type = -type;
		else {
			if(v[i].SE <= minX){
				cout << minY << endl;
			}
			else if(v[i].SE < maxX){
				cout << minY + (v[i].SE - minX) << endl;
			}
			else {
				cout << maxY << endl;
			}
		}
		nowT = v[i].FI;
	}
	
	return 0;
}
