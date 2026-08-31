#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, m;
  cin >> n >> m;
  int s[n][2], c[m][2];
  for(int i = 0; i < n; i++) cin >> s[i][0] >> s[i][1];
  for(int i = 0; i < m; i++) cin >> c[i][0] >> c[i][1];
  
  for(int i = 0; i < n; i++){
    int d = 1000000000;
    int ans;
    for(int j = 0; j < m; j++){
      int k = abs(s[i][0] - c[j][0]) + abs(s[i][1] - c[j][1]);
      if(k < d){
        d = k;
        ans = j + 1;
      }
    }
    cout << ans << endl;
  }
}