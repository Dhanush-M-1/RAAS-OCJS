#include<bits/stdc++.h>
using namespace std;

int main(){
  int n,m;
  cin>>n>>m;
  int a[n],b[n],c[m],d[m];
  for(int i=0;i<n;i++){
    cin>>a[i]>>b[i];
  }
  for(int i=0;i<m;i++){
    cin>>c[i]>>d[i];
  }
  for(int i=0;i<n;i++){
    long long mn=1000000000000;
    int cou;
    for(int j=0;j<m;j++){
      if(mn>abs(a[i]-c[j])+abs(b[i]-d[j])){
        mn=abs(a[i]-c[j])+abs(b[i]-d[j]);
        cou=j+1;
      }
    }
    cout<<cou<<endl;
  }
}
  
