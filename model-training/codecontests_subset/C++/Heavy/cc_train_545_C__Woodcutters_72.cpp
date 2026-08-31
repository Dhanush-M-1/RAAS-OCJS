#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 24;
const int mod = 1e9 + 7;
int n, m;
int main() {
  int t, q;
  cin >> n;
  vector<vector<int> > a(n, vector<int>(2));
  for (int i = 0; i < n; i++) cin >> a[i][0] >> a[i][1];
  int ans = 0;
  int last_x = a[0][0] - a[0][1];
  for (int i = 0; i < n; i++) {
    int x = a[i][0], h = a[i][1];
    if (i == 0) {
      ans++;
    } else {
      if (x - h > last_x and x - h > a[i - 1][0]) {
        ans++;
        last_x = x - h;
      } else if (i < n - 1 and x + h > last_x and x + h < a[i + 1][0]) {
        ans++;
        last_x = x + h;
      } else if (i == n - 1) {
        ans++;
      }
    }
  }
  cout << ans << "\n";
  ;
}
