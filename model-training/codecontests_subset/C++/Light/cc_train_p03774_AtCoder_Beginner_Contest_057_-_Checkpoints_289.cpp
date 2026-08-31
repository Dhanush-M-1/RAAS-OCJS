#include <bits/stdc++.h>
using namespace std;
  
int main(){
  int n, m;
  cin >> n >> m;
  int x[n], y[n], c[m], d[m];
  for(int i = 0; i < n; i++) cin >> x[i] >> y[i];
  for(int i = 0; i < m; i++) cin >> c[i] >> d[i];
  for(int i = 0; i < n; i++){
    int res = 1, min = 1e9;
    for(int j = 0; j < m; j++){
      int tmp = abs(x[i] - c[j]) + abs(y[i] - d[j]);
      if(tmp < min){
        min = tmp;
        res = j + 1;
      }
    }
    cout << res << endl;
  }
  return 0;
}