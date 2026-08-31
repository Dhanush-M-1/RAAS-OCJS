#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin>>n>>m;
  long long a[55],b[55],c,d,e[55],mn[55];
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
    mn[i]=1000000000;
  }
  for(int i=0;i<m;i++){
    cin>>c>>d;
    for(int j=0;j<n;j++){
      if(mn[j]>abs(a[j]-c)+abs(b[j]-d)){
	mn[j]=abs(a[j]-c)+abs(b[j]-d);
	e[j]=i+1;
      }
    }
  }

  for(int i=0;i<n;i++){
    cout<<e[i]<<endl;
  }
  return 0;
}
