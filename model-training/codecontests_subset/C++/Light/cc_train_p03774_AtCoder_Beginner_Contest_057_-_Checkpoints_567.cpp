#include<bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin >> n >> m;
  int a[51],b[51],c[51],d[51];
  for(int i=0;i<n;i++){
    cin >> a[i] >> b[i];
  }
  for(int i=0;i<m;i++){
    cin >>c[i] >> d[i];
  }
  for(int i=0;i<n;i++){
    int mi=1234567890;
    int mn=-1;
    for(int j=0;j<m;j++){
      int ma=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(mi>ma){
	mi=ma;
	mn=j+1;
      }
    }
    cout << mn << endl;
  }
  return 0;
}
