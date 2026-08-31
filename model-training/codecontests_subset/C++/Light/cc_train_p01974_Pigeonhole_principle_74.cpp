#include<bits/stdc++.h>
using namespace std;

// macro
#define rep(i,n) for(i=0;i<n;i++)
#define ll long long
#define all(v) v.begin(), v.end()

// code starts
int main()
{
  int n;cin>>n;
  vector<int> a(n);
  int i,j;
  rep(i,n)cin>>a[i];
  bool fin=false;
  rep(i,n)
  {
    rep(j,n)
    {
      if(i==j)continue;
      if(abs(a[i]-a[j])%(n-1)==0)
      {
        cout<<a[i]<<' '<<a[j]<<endl;
        fin=true;
        break;
      }
    }
    if(fin)break;
  }
}

