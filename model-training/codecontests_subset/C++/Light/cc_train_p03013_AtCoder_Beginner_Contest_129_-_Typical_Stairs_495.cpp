#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,m;
  cin>>n>>m;
  long long int a[n+1];
  for(int i=0;i<n+1;i++)
    a[i]=1;
  for(int i=0;i<m;i++)
  {
    int x;
    cin>>x;
    a[x]=0;
    if(a[x-1]==0 || a[x+1]==0)
      return cout<<"0",0;
  }
  for(int i=n-2;i>=0;i--)
  {
    if(a[i]==1)
      a[i]=(a[i+1]+a[i+2])%1000000007;
  }
  cout<<a[0];
  return 0;
}