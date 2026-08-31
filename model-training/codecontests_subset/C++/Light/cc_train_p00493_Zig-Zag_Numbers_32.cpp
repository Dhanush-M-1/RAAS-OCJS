#include<algorithm>
#include<iostream>
#include<vector>
#include<map>
#include<cstring>
using namespace std;

const int MOD=10000;

vector < int > A,B; 
int M;
int dp[505][10][3][505][2];

void sub1(vector<int> &q){
    for(int i=q.size()-1; i>=0; --i){
	if(q[i]==0){
	    q[i]=9;
	} else {
	    --q[i];
	    return;
	}
    }
    return;
}

int ZigZag(const vector<int> v,int idx,int prv,int updown,int mod,bool free){
    if(idx==v.size()) return !mod;
    if(~dp[idx][prv][updown][mod][free]) return dp[idx][prv][updown][mod][free];
    int r=(free?9:v[idx]);
    int ret=0;
    for(int i=0; i<=r; ++i,ret%=MOD){
	if(updown==0&&prv<=i) continue;
	if(updown==1&&prv>=i) continue;
	if(updown==2&&prv&&prv==i) continue;
	int u;
	if(updown==2){
	    if(prv==0){
		u=2;
	    } else if(prv>i){
		u=1;
	    } else {
		u=0;
	    }
	} else u=!updown;
	ret+=ZigZag(v,idx+1,i,u,(mod*10+i)%M,free|(i!=v[idx]));
    }
    return dp[idx][prv][updown][mod][free]=ret%MOD;
}

int main(){
    string a,b;
    cin >> a >> b >> M;
    for(int i=0; i<a.size(); ++i) A.push_back(a[i]-'0');
    for(int j=0; j<b.size(); ++j) B.push_back(b[j]-'0');
    sub1(A);
    
    memset(dp,-1,sizeof(dp));
    int ra=ZigZag(A,0,0,2,0,false);
    memset(dp,-1,sizeof(dp));
    int rb=ZigZag(B,0,0,2,0,false);
    
    int ret=(rb-ra+MOD)%MOD;
    cout << ret << endl;
    return 0;
}