#include <bits/stdc++.h>
using namespace std;
signed main(){
  int n,m,a[50],b[50],c[50],d[50];
  cin>>n>>m;
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
 
  for(int i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  
  for(int i = 0;i<n;i++){
    int e = abs(a[i]-c[0])+abs(b[i]-d[0]);
    int f = 1;
    for(int j=0;j<m ;j++){
      int g = abs(a[i]-c[j])+abs(b[i]-d[j]);
      
      if( e>g){
        e = g;
        f = j+1;
      }
    }
    cout << f << endl;
  }
}
  
    
 
