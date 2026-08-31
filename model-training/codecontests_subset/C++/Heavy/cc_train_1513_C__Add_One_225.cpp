#include <bits/stdc++.h>
#include<sstream>
#include<string>
#include<vector>
#include <set>
#define IOS ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define pb push_back
#define mp make_pair
#define ll long long
#define ff first
#define ss second
long long M=1000000007;
using namespace std;
ll fact[10000];
ll m1[2000001][10];
ll power(ll x, unsigned ll y, unsigned ll m) 
{ 
    if (y == 0) 
        return 1; 
    ll p = power(x, y / 2, m) % m; 
    p = (p * p) % m; 
  
    return (y % 2 == 0) ? p : (x * p) % m; 
} 
unsigned long long modInverse(unsigned long long n,  
                                            ll p)
{
    return power(n, p - 2, p);
}
unsigned long long nCrModPFermat(unsigned long long n,
                                 ll r, ll p)
{
    // If n<r, then nCr should return 0
    if (n < r)
        return 0;
    // Base case
    if (r == 0)
        return 1;
    return (fact[n] * modInverse(fact[r], p) % p
            * modInverse(fact[n - r], p) % p)
           % p;
}
int32_t main()
{
  IOS
      for(ll j=0;j<=9;j++)m1[0][j]=1;
  for(ll i=1;i<=200000;i++)
      {
          for(ll j=0;j<=9;j++)
          {
              if(j==9)
              {
                  m1[i][j]=(m1[i-1][1]+m1[i-1][0])%M;
              }
              else
              m1[i][j]=m1[i-1][j+1];
          }
      }
  ll t;
  cin>>t;
  while(t--)
  {
      ll n,m;
      cin>>n>>m;
      ll cnt=0;
      while(n>0)
      {
          cnt+=(m1[m][n%10])%M;
          cnt%=M;
          n/=10;
      }
      cout<<cnt<<endl;
  }
  return 0;
}
