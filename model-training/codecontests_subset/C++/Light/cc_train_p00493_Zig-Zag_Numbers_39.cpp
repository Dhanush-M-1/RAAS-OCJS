#include <algorithm>
#include <bitset>
#include <cctype>
#include <complex>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>
#include <deque>
#include <functional>
#include <iomanip>
#include <iostream>
#include <list>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <utility>
#include <vector>

using namespace std;

inline int toInt(string s) {int v; istringstream sin(s);sin>>v;return v;}
template<class T> inline string toString(T x) {ostringstream sout;sout<<x;return sout.str();}
template<class T> inline T sqr(T x) {return x*x;}

typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<string> vs;
typedef pair<int, int> pii;
typedef long long ll;

#define all(a)  (a).begin(),(a).end()
#define rall(a) (a).rbegin(), (a).rend()
#define pb push_back
#define mp make_pair
#define each(i,c) for(typeof((c).begin()) i=(c).begin(); i!=(c).end(); ++i)
#define exist(s,e) ((s).find(e)!=(s).end())
#define range(i,a,b) for(int i=(a);i<(b);++i)
#define rep(i,n)  range(i,0,n)
#define clr(a,b) memset((a), (b) ,sizeof(a))
#define dump(x)  cerr << #x << " = " << (x) << endl;
#define debug(x) cerr << #x << " = " << (x) << " (L" << __LINE__ << ")" << " " << __FILE__ << endl;

const double eps = 1e-10;
const double pi  = acos(-1.0);
const ll INF =1LL << 62;
const int inf =1 << 29;

const int mod=10000;

string decrease(string x){
	for(int i=x.size()-1;i>=0;i--){
		if(x[i]!='0'){
			x[i]--;
			if(x[i]=='0'&& i==0 &x.size()>1) 
				x=x.substr(1);
			return x;
		}else
			x[i]='9';
	}
	return x;
}

int dp[501][500][10][2][3];

int solve(string s,int m){
	int n=s.size();
	clr(dp,0);
	dp[0][0][0][0][0]=1;

	rep(i,n)rep(j,m)rep(a,10)rep(b,2)rep(c,3){
		int cur=s[i]-'0';
		rep(l,10){
			int nb=1;
			if(!b){
				if(cur<l) continue;
				if(cur==l) nb=0;
			}

			int nc=0;
			if(c==0){
				if(a>0){
					if(a==l) continue;
					if(a<l) 
						nc=1;
					else
						nc=2;
				}
			}
			if(c==1){
				if(a<=l) continue;
				nc=2;
			}
			if(c==2){
				if(a>=l) continue;
				nc=1;
			}

			int nj=(j*10+l)%m;
			
			dp[i+1][nj][l][nb][nc]=(dp[i+1][nj][l][nb][nc]+dp[i][j][a][b][c]+mod)%mod;
		}
	}
	int res=0;
	rep(a,10)rep(b,2)rep(c,3) res=(res+dp[n][0][a][b][c]+mod)%mod;
	return res;
}

int main(void){
	string a,b;
	cin >> a >> b;
	int m;
	cin >> m;

	a=decrease(a);

	int ans=(solve(b,m)-solve(a,m)+mod)%mod;
	cout << ans << endl;
	return 0;
}