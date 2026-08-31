#include<vector>
#include<map>
#include<set>
#include<algorithm>
#include<functional>
#include<numeric>
#include<utility>
#include<sstream>
#include<iostream>
#include<iomanip>
#include<cstdio>
#include<cmath>
#include<cstdlib>
#include<cctype>
#include<string>
#include<cstring>
using namespace std;
typedef vector<int>VI;
typedef vector<VI>VVI;
typedef vector<string>VS;
typedef pair<int,int>PII;
typedef long long LL;
#define ALL(a) (a).begin(),(a).end()
#define RALL(a) (a).rbegin(),(a).rend()
#define PB push_back
#define EACH(i,c) for(typeof((c).begin())i=(c).begin();i!=(c).end();i++)
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)

const int MOD=10000;
int M;
int memo[501][10][3][2][500];
//up->1,down->0;
string s;
int solve(int n,int prev,int ud,int fr,int md){
    if(n==s.size())return md?0:1;
    if(memo[n][prev][ud][fr][md]!=-1)
        return memo[n][prev][ud][fr][md];
    int ret=0;
    for(int i=0;i<=(fr?9:s[n]-'0');i++){
        if(ud==1&&prev>=i)continue;
        if(ud==0&&prev<=i)continue;
        if(ud==2&&prev!=0&&prev==i)continue;

        int u;
        if(ud==2){
            if(prev==0)u=2;
            else if(prev<i)u=0;
            else u=1;
        }
        else u=1-ud;
        int f;
        if(fr)f=1;
        else{
            if(i!=s[n]-'0')f=1;
            else f=0;
        }
        ret+=solve(n+1,i,u,f,(md*10+i)%M);
        ret%=MOD;
    }
    return memo[n][prev][ud][fr][md]=ret;
}

int main(){
    string A,B;
    cin>>A>>B>>M;
    for(int i=A.size()-1;i>=0;i--){
        if(A[i]=='0'){
            A[i]='9';
        }
        else{
            A[i]--;
            break;
        }
    }
    s=A;
    memset(memo,-1,sizeof(memo));
    int a=solve(0,0,2,0,0);
    s=B;
    memset(memo,-1,sizeof(memo));
    int b=solve(0,0,2,0,0);
    cout<<(b-a+MOD)%MOD<<endl;

    return 0;
}