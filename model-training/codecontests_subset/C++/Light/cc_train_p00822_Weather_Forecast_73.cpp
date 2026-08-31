#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<ll, ll> P;

#define fi first
#define se second
#define repl(i,a,b) for(ll i=(ll)(a);i<(ll)(b);i++)
#define rep(i,n) repl(i,0,n)
#define all(x) (x).begin(),(x).end()
#define dbg(x) cout<<#x"="<<x<<endl
#define mmax(x,y) (x>y?x:y)
#define mmin(x,y) (x<y?x:y)
#define maxch(x,y) x=mmax(x,y)
#define minch(x,y) x=mmin(x,y)
#define uni(x) x.erase(unique(all(x)),x.end())
#define exist(x,y) (find(all(x),y)!=x.end())
#define bcnt __builtin_popcount

#define INF 1e16
#define mod 1000000007

int n;
bool dp[367][9][8][8][8][8];

int main(){
  while(1){
    cin>>n;
    if(n==0)break;
    vector<int> pos;
    rep(q,n){
      vector<vector<int> > a(4,vector<int>(4));
      rep(i,4)rep(j,4){
        cin>>a[i][j];
      }
      pos.push_back(0);
      rep(i,3)rep(j,3){
        if(a[i][j]+a[i][j+1]+a[i+1][j]+a[i+1][j+1]!=0){
          pos.back()|=1<<(i*3+j);
        }
      }
    }
    if((pos[0]>>4)&1){
      cout<<0<<endl;
      continue;
    }
    memset(dp,0,sizeof(dp));
    dp[1][4][1][1][1][1]=true;
    bool res=false;
    repl(i,1,n){
      rep(p,9){
        rep(a,7)rep(b,7)rep(c,7)rep(d,7){
          if(!dp[i][p][a][b][c][d])continue;
          rep(np,9){
            if(((pos[i]>>np)&1)||(p%3!=np%3&&p/3!=np/3))continue;
            if(np==0){
              dp[i+1][np][0][b+1][c+1][d+1]=true;
            }else if(np==2){
              dp[i+1][np][a+1][0][c+1][d+1]=true;
            }else if(np==6){
              dp[i+1][np][a+1][b+1][0][d+1]=true;
            }else if(np==8){
              dp[i+1][np][a+1][b+1][c+1][0]=true;
            }else{
              dp[i+1][np][a+1][b+1][c+1][d+1]=true;
            }
          }
        }
      }
    }
    rep(p,9)rep(a,7)rep(b,7)rep(c,7)rep(d,7)if(dp[n][p][a][b][c][d])res=true;
    cout<<(res?1:0)<<endl;
  }
  return 0;
}

