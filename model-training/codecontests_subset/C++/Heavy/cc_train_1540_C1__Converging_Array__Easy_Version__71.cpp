#include <bits/stdc++.h>
using namespace std;

mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
typedef long long ll;
typedef long double ld;
#define INF 2001001001
#define MOD 1000000007

ll N,X,C[105],B[105],D[105],D1[105];
int Q;
ll dp[105][10005];
ll C2[105];

int main()
{
  ios_base::sync_with_stdio(0);cin.tie(0);
  cin>>N;
  for (int i=1;i<=N;i++)
    cin>>C[i];
  for (int i=1;i<N;i++)
    cin>>B[i];
  cin>>Q;
  cin>>X;
  D1[1]=X;
  for (int i=2;i<=N;i++)
    D1[i]=D1[i-1]+B[i-1];
  for (int i=1;i<=N;i++){
    D[i]=D[i-1]+D1[i];
    C2[i]=C2[i-1]+C[i];
  }
  dp[0][0]=1;
  for (int i=0;i<N;i++){ //adding in element i+1
    for (int j=0;j<=C2[i];j++){
      if (dp[i][j]==0) continue;
      for (int k=0;k<=C[i+1];k++){
	if (j+k>=D[i+1]){
	  dp[i+1][j+k]+=dp[i][j];
	  if (dp[i+1][j+k]>=MOD)
	    dp[i+1][j+k]%=MOD;
	}
      }
    }
  }
  ll ans=0;
  for (int i=0;i<=10000;i++)
    ans=(ans+dp[N][i])%MOD;
  cout<<ans<<endl;
  return 0;
}
