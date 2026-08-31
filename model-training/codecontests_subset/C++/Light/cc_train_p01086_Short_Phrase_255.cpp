#include <bits/stdc++.h>
#define rep(i,n) for(int i = 0; i < n; i++)
const double PI  = 3.1415926535897932384626433832795028841971;
const int    INF = 100000000;
const double EPS = 1e-10;
const int    MOD = 1000000007;
using namespace std;
typedef long long ll;
typedef pair<int,int> P;

int n;
string str[40];

void solve(){
	rep(i,n) cin >> str[i];
	rep(i,n){
		int cnt[5] = {5,7,5,7,7};
		for(int j = i; j < n; j++){
			rep(k,5){
				if(cnt[k] != 0){
					cnt[k] -= str[j].size();
					break;
				}
			}
		}
		bool ok = true;
		rep(j,5) if(cnt[j] != 0) ok = false;
		if(ok){
			cout << i+1 << endl;
			break;
		}
	}
}

int main(){
	while(cin >> n){
		if(n == 0) break;
		solve();
	}
}