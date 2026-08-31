#include <bits/stdc++.h>
using namespace std;
const int maxm = 110;
int f[maxm];
int n, m;
int main() {
  cin >> n >> m;
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    while (x--) {
      int y;
      cin >> y;
      if (!f[y]) {
        f[y] = 1;
        ans++;
      }
    }
  }
  cout << ((ans == m) ? "YES" : "NO") << endl;
  return 0;
}
