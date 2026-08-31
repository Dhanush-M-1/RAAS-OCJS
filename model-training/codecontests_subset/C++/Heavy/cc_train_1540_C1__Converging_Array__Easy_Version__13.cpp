#include<bits/stdc++.h>
#define FOR(i,a,b) for(int i=(a); i<=(b); ++i)
#define ROF(i,a,b) for(int i=(a); i>=(b); --i)
#define pb push_back
#define eb emplace_back
#define SZ(a) (int)(a).size()
#define all(a) (a).begin(), (a).end()
#define make_unique(a) sort(all((a))), (a).erase(unique(all((a))),(a).end())
#define x first
#define y second
#define MP make_pair
#define MT make_tuple
#define debug(x) cout << #x << " = " << x << endl
#define debug2(x,y) FOR(i,1,y) cout << "##"; cout << #x << " = " << x << endl
#define mset(x,y) memset((x), (y), sizeof(x))

using namespace std;

typedef long long i64;
typedef long double ld;
typedef tuple<int,int,int> iii;
typedef pair<int,int> pii;
typedef pair<i64,i64> pll;
typedef vector<int> vi;
typedef vector<i64> vl;
typedef vector<vector<int>> vvi;
typedef vector<vector<i64>> vvl;
typedef vector<pair<int,int>> vpii;
typedef vector<pair<i64,i64>> vpll;

int readInt(){ int a; scanf("%d",&a); return a; }
i64 readLong(){ i64 a; scanf("%lld",&a); return a;}
void readString(char *s){ scanf(" %s",s); }

string print(int a){ return to_string(a); }
string print(i64 a){ return to_string(a); }
string print(string a){ return a; }
template<typename T1, typename T2> string print(pair<T1,T2> x){ return "("+print(x.x)+","+print(x.y)+")"; }
template<typename T> string print(vector<T> v){ string ans = "[ "; for(T e : v) ans += print(e)+" "; ans += "]"; return ans; }
template<typename T> string print(T *a, T *b){ string ans = "[ "; while(a!=b) ans += print(*(a++))+" "; ans += "]"; return ans; }

const int mod = 1000000007;
int add(int a, int b){ return ((a+=b)>=mod)?a-mod:a; }
int mul(int a, int b){ return a*1ll*b%mod; }
void adding(int &a, int b){ a = add(a, b); }
int pw(int a, int b){
	if(a==0) return 0;
	int ans = 1, res = a;
	for(int i = 1; i <= b; i<<=1, res=mul(res,res)){
		if(i&b) ans = mul(ans,res);
	}
	return ans;
}

const int N = 102;
int dp[N][N*N];
int arbi[N];
int B[N], C[N];

int main(){
	dp[0][0] = 1;
	int n = readInt();
	int sum = 0;
	int Bsum = 0;
	FOR(i, 1, n) C[i] = readInt();
	FOR(i, 1, n-1){
		B[i] = readInt();
		Bsum += B[i];
		B[i] = B[i-1]+Bsum;
	}
	int q = readInt();
	int x = readInt();
	FOR(i, 1, n){
		FOR(j, 0, C[i]){
			FOR(k, 0, sum){
				if(k+j-B[i-1] >= x*i) adding(dp[i][k+j],dp[i-1][k]);
			}
		}
		sum += C[i];
		//cout << print(dp[i], dp[i]+sum) << endl;
	}
	int ans = 0;
	ROF(i, sum, 0){
		adding(ans, dp[n][i]);
	}
	printf("%d",ans);
	return 0;
}
