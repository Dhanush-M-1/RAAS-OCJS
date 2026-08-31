#include <bits/stdc++.h>
using namespace std;
#define int long long
#define vec vector <int>
#define pb push_back
#define po pop_back
#define mp make_pair
#define mt make_tuple
#define F  first
#define S  second
#define f(i,x,n) for(int i=x;i<n;i++)
#define rf(i,x,n) for(int i = x; i >= x; i--)
#define all(c) c.begin(),c.end()
#define fast() ios_base::sync_with_stdio(false);cin.tie(NULL)
const int MAX = LLONG_MAX, MOD = 1e9 + 7;
const int MIN = LLONG_MIN;
const long double PI = 3.1415926535;
const int N = 1000;

int fac(int no){
  if(no == 0 or no == 1)
    return 1;
  int ans = no;
  while(no > 1){
    no--;
    ans = ((ans%MOD)*(no%MOD))%MOD;
  }
  return ans;
}


void solve(int *dp){
  string n;
  int m;
  cin >> n >> m;
  int ans = 0;
  f(i,0,n.length()){
    if(m+n[i]-'0' < 10)
      ans = (ans+1)%MOD;
    else{
      ans = (ans+dp[m+n[i]-'0'-10])%MOD;
    }
  }
  cout << ans << endl;
}

int32_t main()
{
  fast();
  
  #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt","w",stdout);
  #endif

  int t = 1;
  cin >> t;
  int size = 2*(1e5) + 1;
  int dp[size];
  f(i,0,9)
    dp[i] = 2;
  dp[9] = 3;
  f(i,10,size)
    dp[i] = (dp[i-10] + dp[i-9])%MOD;
  while(t--){
    solve(dp);
  }
    
  
  return 0;

}
