#include <bits/stdc++.h>
using namespace std;
int main(){
  int n,m;
  cin >> n >> m;
  int a[n],b[n],c[m],d[m];
  for(int i=0; i<n; i++){
    cin >> a[i] >> b[i];
  }
  for(int i=0; i<m; i++){
    cin >> c[i] >> d[i];
  }
  int shu;
  for(int i=0; i<n; i++){
    long long int man = 9999999999;
    for(int j=0; j<m; j++){
      if(man > abs(a[i]-c[j])+abs(b[i]-d[j])){
        man = abs(a[i]-c[j])+abs(b[i]-d[j]);
        shu = j;
      }
    }
    cout << shu+1 << endl;
  }
}