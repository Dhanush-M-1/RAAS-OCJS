#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;++i)
#define rrep(i,n) for(int i=n-1;i>=0;--i)
#define REP(i,a,b) for(int i=a;i<b;i++)
#define yesno(flg) if(flg){cout<<"YES"<<endl;}else{cout<<"NO"<<endl;}
#define Vi vector<int>
#define pb push_back
#define i197 1000000007
#define MAX_N 200002
using namespace std;

typedef long long ll;
typedef pair<int,int> Pii;
typedef pair<Pii,int> Piii;
typedef pair<string,string> Pss;
const int inf=1000000000;
struct edge{
	int myc,to,c,cost;
};
struct pos{
	int to,cost,color;
};
int dy[]={0, 0, 1, -1};
int dx[]={1, -1, 0, 0};

int dp[300001]={};

void add(int k){
	if(dp[k]==0){
		dp[k]=1;
	}else{
		dp[k]=0;
		add(k+1);
	}
}
int main() {
	int n,a,b;
	Vi v;
	cin>>n;
	rep(i,n){
		cin>>a>>b;
		add(a+b);
	}
	rep(i,300001){
		if(dp[i]==1)cout<<i<<" 0"<<endl;
	}
	return 0;
}

