#include<bits/stdc++.h>
using namespace std;

int main(){
  int n, m; cin >> n >> m;
  int a[n],b[n],c[m],d[m];
  for(int i=0; i<n; i++) cin >> a[i] >> b[i];
  for(int j=0; j<m; j++) cin >> c[j] >> d[j];

  for(int i=0; i<n; i++) {
    int point, min_dist = INT_MAX;
    for(int j=0; j<m; j++) {
      int dist = abs(a[i]-c[j]) + abs(b[i]-d[j]);
      if(min_dist>dist) {
        min_dist = dist;
        point = j+1;      
      }
    }  
    cout << point << endl;
  }
  return 0;
}