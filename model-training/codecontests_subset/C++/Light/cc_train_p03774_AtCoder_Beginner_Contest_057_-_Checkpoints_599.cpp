#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,m,a[55],b[55],c[55],d[55],p;
  long long count=0;
  cin>>n>>m;
  for(int i=0; i<n; i++){
    cin>>a[i]>>b[i];
  }
  for(int i=0; i<m; i++){
    cin>>c[i]>>d[i];
  }
  for(int i=0; i<n; i++){
    p=1;
    count=abs(a[i]-c[0])+abs(b[i]-d[0]);
    for(int j=1; j<m; j++){
      if(count>abs(a[i]-c[j])+abs(b[i]-d[j])){
	count=abs(a[i]-c[j])+abs(b[i]-d[j]);
	p=j+1;
      }
    }
    cout<<p<<'\n';
  }
  return 0;
}
