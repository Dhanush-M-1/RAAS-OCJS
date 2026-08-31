#include<bits/stdc++.h>
using namespace std;
int a[1000001],n,b[1000001],m,x;
int main()
{
  	cin>>n>>m;
  	for(int i=1;i<=m;i++)
    {
      cin>>x;
      b[x]=1;
    }
  a[0]=1;
  	for(int i=1;i<=n;i++)
    {
      if(b[i-1]==0)a[i]+=a[i-1];
      if(b[i-2]==0)a[i]+=a[i-2];
      a[i]=a[i]%1000000007;
    }
  cout<<a[n];
}