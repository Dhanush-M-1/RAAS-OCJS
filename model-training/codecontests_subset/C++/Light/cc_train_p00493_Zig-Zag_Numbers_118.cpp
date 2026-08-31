#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<map>
#include<set>
#include<string>
#include<stack>
#include<cstdio>
#include<cmath>
using namespace std;

typedef long long ll;
typedef long double ld;
typedef pair<int,int> P;
typedef pair<int,P> P1;

#define fr first
#define sc second
#define mp make_pair
#define pb push_back
#define rep(i,x) for(int i=0;i<x;i++)
#define rep1(i,x) for(int i=1;i<=x;i++)
#define rrep(i,x) for(int i=x-1;i>=0;i--)
#define rrep1(i,x) for(int i=x;i>0;i--)
#define sor(v) sort(v.begin(),v.end())
#define rev(s) reverse(s.begin(),s.end())
#define lb(vec,a) lower_bound(vec.begin(),vec.end(),a)
#define ub(vec,a) upper_bound(vec.begin(),vec.end(),a)
#define uniq(vec) vec.erase(unique(vec.begin(),vec.end()),vec.end())
#define min_3(a,b,c) min(a,min(b,c))
#define max_3(a,b,c) max(a,max(b,c))
#define mp1(a,b,c) P1(a,P(b,c))
#define pque(a) priority_queue<a>
#define rpque(a) priority_queue<a,vector<a>,greater<a>>

const int INF=1000000000;
const int dir_4[4][2]={{1,0},{0,1},{-1,0},{0,-1}};
const int dir_8[8][2]={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
const int kaijou[10]={1,1,2,6,24,120,720,5040,40320,362880};

const int M = 10000;

int dp[502][2][10][502]; //桁数,上がりスタート/下りスタート,先頭文字,mod M

int modpow(int x,int k,int m){
	if(k == 0)return 1;
	int tmp = modpow(x,k/2,m);
	tmp *= tmp; tmp %= m;
	if(k&1){tmp *= x; tmp%=m; }
	return tmp;
}

int solver(string s,int m){
	int n = s.size();
	if(n == 0)return 0;
	if(n == 1){
		return (s[0]-'0')/m;
	}
	int ret = 0;
	rep1(i,s[0]-'0'-1){
		ret += dp[n][0][i][0];
		ret += dp[n][1][i][0];
		ret %= M;
	}
	for(int i = 2;i <= n-1; i ++){
		rep1(j,9){
			ret += dp[i][0][j][0];
			ret += dp[i][1][j][0];
			ret %= M;
		}
	}
	ret += 9/m; ret %= M;
	//cout << ret << endl;
	int a = -1 , b = s[0]-'0';
	int sum = 10*m-b*modpow(10,n-1,m); sum %= m;
	//cout << sum << endl;
	rep1(i,n-1){
		int c = s[i]-'0';
		if(a == -1){
			if(c <= b){
				rep(j,c){
					ret += dp[n-i][0][j][sum];
					ret %= M;
				}
				if(c == b)break;
				a = b;
				b = c;
				sum += 10*m-b*modpow(10,n-i-1,m);
				sum %= m;
			}
			else {
				rep(j,b){
					ret += dp[n-i][0][j][sum];
					ret %= M;
				}
				for(int j = b+1; j < c; j ++){
					ret += dp[n-i][1][j][sum];
					ret %= M;
				}
				a = b;
				b = c;
				sum += 10*m-b*modpow(10,n-i-1,m);
				sum %= m;
			}
		}
		else {
			if(a < b){
				if(c < b){
					rep(j,c){
						ret += dp[n-i][0][j][sum];
						ret %= M;
					}
					a = b;
					b = c;
					sum += 10*m-b*modpow(10,n-i-1,m);
					sum %= m;
				}
				else {
					rep(j,b){
						ret += dp[n-i][0][j][sum];
						ret %= M;
					}
					break;
				}
			}
			else {
				if(c <= b)break;
				else {
					for(int j = b+1;j < c;j ++){
						ret += dp[n-i][1][j][sum];
						ret %= M;
					}
					a = b;
					b = c;
					sum += 10*m-b*modpow(10,n-i-1,m);
					sum %= m;
				}
			}
		}
		if(i == n-1 && sum == 0)ret ++;
	}
	return ret;
}

int main(){
	string a,b;
	int m;
	cin >> a >> b >> m;
	
	rrep(i,a.size()){
		if(a[i] != '0'){
			a[i] --;
			break;
		}
		a[i] = '9';
	}
	if(a[0] == '0'){
		string a_ = "";
		rep1(i,a.size()-1)a_ += a[i];
		a = a_;
	}
	
	rep(i,10){
		dp[1][0][i][i%m] = 1;
		dp[1][1][i][i%m] = 1;
	}
	for(int i = 2 ; i < 502; i ++ ){
		rep(j,10){
			rep(k,m){
				int c = (k+10*m-j*modpow(10,i-1,m))%m;
				dp[i][0][j][k] = 0;
				for(int l = j+1 ; l < 10 ; l ++){
					dp[i][0][j][k] += dp[i-1][1][l][c];
				}
				dp[i][1][j][k] = 0;
				rep(l,j){
					dp[i][1][j][k] += dp[i-1][0][l][c];
				}
				dp[i][0][j][k] %= M;
				dp[i][1][j][k] %= M;
			}
		}
	}
	
	/*while(1){
		string s;
		cin >> s;
		if(s == "END")break;
		printf("%d\n",solver(s,m));
	}*/
	
	printf("%d\n",(solver(b,m)-solver(a,m)+M)%M);
}