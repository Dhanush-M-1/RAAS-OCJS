#include<bits/stdc++.h>
#define ll long long
#define fi first
#define se second
using namespace std;

const ll MOD=10000;
string a,b;
int m;
ll dp[502][2][500][11][3][2];

inline ll solve(string s){
  int n=(int)s.length();
  for(int i=0;i<n+1;i++)
    for(int j=0;j<2;j++)
      for(int k=0;k<m;k++)
        for(int l=0;l<11;l++)
          for(int mm=0;mm<3;mm++)
            for(int o=0;o<2;o++)
              dp[i][j][k][l][mm][o]=0;
  dp[0][0][0][0][0][0]=1;
  for(int i=0;i<n;i++){
    for(int j=0;j<2;j++){
      for(int k=0;k<m;k++){
        for(int l=0;l<11;l++){
          for(int mm=0;mm<3;mm++){
            for(int o=0;o<2;o++){
              int lim=j?9:s[i]-'0';
              int pre=l-1;
              for(int d=0;d<lim+1;d++){
                if(d==0 && o==0){
                  (dp[i+1][j || d<lim][(10*k+d)%m][0][0][0]+=dp[i][j][k][l][mm][o])%=MOD;
                  continue;
                }
                if(pre==-1){
                  (dp[i+1][j || d<lim][(10*k+d)%m][d+1][0][1]+=dp[i][j][k][l][mm][o])%=MOD;
                  continue;
                }
                if(pre<d && mm!=1){
                  (dp[i+1][j || d<lim][(10*k+d)%m][d+1][1][1]+=dp[i][j][k][l][mm][o])%=MOD;
                }
                if(pre>d && mm!=2){
                  (dp[i+1][j || d<lim][(10*k+d)%m][d+1][2][1]+=dp[i][j][k][l][mm][o])%=MOD;
                }
              }
            }
          }
        }
      }
    }
  }
  ll ans=0;
  for(int i=0;i<2;i++)for(int j=1;j<11;j++)for(int k=0;k<3;k++){
    (ans+=dp[n][i][0][j][k][1])%=MOD;
  }
  return ans;
}

inline string min1(string s){
  int n=(int)s.length();
  for(int i=n-1;i>=0;i--){
    int now=s[i]-'0';
    if(now-1<0){
      s[i]='9';
    }else{
      s[i]='0'+now-1;
      break;
    }
  }
  for(int i=0;i<n;i++){
    if(s=="0")break;
    if(s[i]=='0')s=s.substr(1,s.length()-1);
    else break;
  }
  return s;
}
                   
int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(10);
  cout<<fixed;
#ifdef LOCAL_DEFINE
    freopen("in", "r", stdin); 
    freopen("out","w",stdout);
#endif
  ll ansa,ansb;
  cin>>a>>b>>m;
  a=min1(a);
  ansb=solve(b);
  ansa=solve(a);
  cout<<(ansb+MOD-ansa)%MOD<<"\n";
#ifdef LOCAL_DEFINE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
  return 0;
}