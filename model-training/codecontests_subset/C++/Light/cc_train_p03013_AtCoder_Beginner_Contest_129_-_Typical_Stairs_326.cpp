#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,m;
  int mod = 1000000007;
  cin>>n>>m;
  int a[m],i;
  vector<int> v(n+1,-1);
  v[0]=1;
  v[1]=1;
  for(i=0;i<m;i++)
  {
    cin>>a[i];
    v[a[i]]=0;
  }
  for(i=2;i<=n;i++)
  {
    if(v[i])
    {
      v[i]=(v[i-1]+v[i-2])%mod;
    }
  }
//   for(i=0;i<=n;i++) cout<<v[i]<<" ";
  
  cout<<v[n];
  return 0;
}