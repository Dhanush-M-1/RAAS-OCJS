#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, cnt = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= c; i++) {
    int mx = min(b, n - i * 2);
    int mn = max(n - i * 2 - a / 2, 0);
    if (mx >= mn) cnt += mx - mn + 1;
  }
  cout << cnt;
  return 0;
}
