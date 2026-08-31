#include <iostream>
#include <fstream>
#include <typeinfo>
#include <vector>
#include <cmath>
#include <set>
#include <map>
#include <string>
#include <algorithm>
#include <cstdio>
#include <queue>
#include <iomanip>
#include <cctype>
#define syosu(x) fixed<<setprecision(x)
using namespace std;
typedef long long ll;
typedef pair<int,int> P;
typedef pair<double,double> pdd;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ll> vl;
typedef vector<char> vc;
typedef vector<vc> vvc;
typedef vector<bool> vb;
typedef vector<vb> vvb;
typedef vector<P> vp;
typedef vector<vp> vvp;
typedef pair<int,P> pip;
typedef vector<pip> vip;
const int inf=1<<25;
const ll INF=1ll<<50;
const double pi=acos(-1);
const double eps=1e-8;
const vi emp;

const int mod=10000;

int dp[502][11][500][2][2];

int solve(string s,int D){
	int n=s.size();
	for(int i=0;i<=n;i++) for(int j=0;j<=10;j++) for(int k=0;k<D;k++) for(int l=0;l<2;l++) for(int m=0;m<2;m++) dp[i][j][k][l][m]=0;
	dp[0][10][0][0][0]++;
	for(int i=0;i<n;i++) for(int j=0;j<=10;j++) for(int k=0;k<D;k++) for(int l=0;l<2;l++) for(int m=0;m<2;m++){
		if(j!=10){
			int S=m?0:j+1,T=m?j-1:9;
			if(!l) T=min(T,s[i]-'0');
			for(int d=S;d<T+1;d++) (dp[i+1][d][(10*k+d)%D][l||s[i]-'0'!=d/*d<T*/][!m]+=dp[i][j][k][l][m])%=mod;
		}
		else if(!k&&!l&&!m){
			int lim=(i==0)?s[i]-'0':9;
			for(int d=1;d<lim+1;d++) for(int I=0;I<2;I++) dp[i+1][d][d%D][i||d<lim][I]++;
			dp[i+1][10][0][0][0]++;
		}
	}
	int ans=0;
	for(int i=0;i<10;i++) for(int j=0;j<2;j++) for(int k=0;k<2;k++){
		(ans+=dp[n][i][0][j][k])%=mod;
	}
	int num=9/D;
	if(s.size()==1&&s[0]-'0'<num*D) num=(s[0]-'0')/D;
	return (ans+mod-num)%mod;
}

string Minus(string s){
	if(s.back()>'0') s[s.size()-1]-=1;
	else{
		for(int i=s.size()-1;i>=0;i--) if(s[i]>'0'){
			s[i]-=1;
			for(int j=i+1;j<s.size();j++) s[j]='9';
			break;
		}
	}
	if(s=="0") return s;
	for(int i=0;i<s.size();i++) if(s[i]!='0'){
		s.erase(s.begin(),s.begin()+i);
		break;
	}
	return s;
}

string A,B;
int D;

int main(){
	cin>>A>>B>>D;
	cout<<(solve(B,D)-solve(Minus(A),D)+2*mod)%mod<<endl;
}