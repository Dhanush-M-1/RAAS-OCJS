#include <bits/stdc++.h>
using namespace std;
const long long oo = 1e14;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> prev(n), s(m), a(k);
  for (int i = (0); i < (n); ++i) prev[i] = i;
  for (int i = (0); i < (m); ++i) {
    int x;
    cin >> x;
    prev[x] = -1;
  }
  for (int i = (0); i < (k); ++i) cin >> a[i];
  if (prev[0] == -1) {
    cout << -1 << '\n';
    return 0;
  }
  for (int i = (1); i < (n); ++i)
    if (prev[i] == -1) prev[i] = prev[i - 1];
  long long ans = oo;
  for (int i = (1); i < (k + 1); ++i) {
    int j = 0, cnt = 0;
    while (j + i < n) {
      if (prev[j + i] == j) {
        cnt = -1;
        break;
      }
      j = prev[j + i];
      cnt++;
    }
    if (cnt != -1) ans = min(ans, 1LL * (cnt + 1) * a[i - 1]);
  }
  cout << (ans < oo ? ans : -1) << '\n';
  return 0;
}
