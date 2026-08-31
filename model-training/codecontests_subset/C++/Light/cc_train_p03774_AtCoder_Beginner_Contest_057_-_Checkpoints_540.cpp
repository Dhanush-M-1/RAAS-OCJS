#include<bits/stdc++.h>
using namespace std;
int n,m,a[51],b[51],c[51],d[51],i,j,k,l,x,y;
int main(){
  cin>>n>>m;
  for(;n-i++;cin>>a[i]>>b[i]);
  for(;m-j++;cin>>c[j]>>d[j]);
  for(;n-k++;cout<<y<<endl)
    for(l=0,x=1e9;m-l++;)
      x>abs(a[k]-c[l])+abs(b[k]-d[l])&&(x=abs(a[k]-c[l])+abs(b[k]-d[l]),y=l);
}
