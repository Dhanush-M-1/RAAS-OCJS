#include <iostream>
#include<bits/stdc++.h>
#include<math.h>
#include<stdio.h>
 
using namespace std;
#define ld long double
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define pb push_back
#define pf push_front
//#define mp make_pair
#define mt make_tuple
#define popb pop_back
#define popf pop_front
#define int  long long int
#define PI 3.1415926535897932
#define all(v) v.begin(),v.end()
//#define endl "\n"
#define rep(i,a,b)  for(int i=a;i<b;i++)
#define lop(i,a,b)  for(int i=a;i>=b;i--)
#define prec(x)  cout<<fixed<<setprecision(x)
#define toup(su) transform(su.begin(), su.end(), su.begin(), ::toupper);
#define tolow(su) transform(su.begin(), su.end(), su.begin(), ::tolower);
 
//if(concated.find(s2)!=string::npos)
int M=1000000007;
 int dp[2][200005];
int gcd(int a, int b)                
{
  return (b==0)?a:gcd(b,a%b);
}
int lcm(int a, int b)                
{
  int l= (a*b);
  l=l/gcd(a,b);
 
  return l;
}
 
 int po(int a, int b)
 { 
 
    if(b==0) return 1;
 
    int temp=po(a,b/2);
 
    int z=( (temp%M) * (temp%M))%M;
 
    if(b%2)
        return ((z%M) * (a%M))%M;
    else
        return z%M;
 
}


signed main()
{
    fast
  #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
 
 
int t=1;
 
cin>>t;
//int prime[1000001]={0};
 int xx=1;

 rep(j,0,200005)
 {
  rep(i,0,2)   
   {
    
    if(i==0 && j<10) dp[i][j]=1;
    else if(i==1 && j<9) dp[i][j]=1;
    else if(i==0)
    {
      dp[i][j] = ( (dp[0][j-10]%M) + (dp[1][j-10] %M) )%M;
    }
    else if(i==1)
    {
      dp[i][j] = ( (dp[0][j-9]%M) + (dp[1][j-9] %M) )%M;
    }
   }
 }



while(t--)
{
 int n,m; cin>>n>>m;

 vector<int> v;

 while(n)
 {
  v.pb(n%10);
  n/=10;
 }

 int ans=0;

 for(auto i:v)
 {
  int p=i;
  if(10-p<=m)
  {
   ans=(ans%M + (dp[0][m-(10-p)] )%M+ (dp[1][m-(10-p)])%M )%M;
  }
  else
  {
    ans= (ans%M + 1)%M;
  }
 }
 cout<<ans<<endl;
 //xx++;
}
return 0;
}