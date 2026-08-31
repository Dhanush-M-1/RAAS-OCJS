#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5, llog = 31;
int ar[N], bal[N], suf[N];
void solve() {
  int n, d;
  scanf("%d%d", &n, &d);
  for (int i = 0; i < n; ++i) scanf("%d", ar + i);
  bal[0] = ar[0];
  for (int i = 0; i < n; ++i) {
    bal[i] = ar[i] + bal[i - 1];
    if (bal[i] > d) {
      cout << -1;
      return;
    }
  }
  suf[n - 1] = bal[n - 1];
  for (int i = n - 2; i >= 0; --i) suf[i] = max(suf[i + 1], bal[i]);
  int cur = 0, rez = 0;
  for (int i = 0; i < n; ++i) {
    if (!ar[i] && bal[i] + cur < 0) {
      cur += d - suf[i] - cur;
      if (bal[i] + cur < 0) {
        cout << -1;
        return;
      }
      ++rez;
    }
  }
  cout << rez;
}
int main() {
  solve();
  return 0;
}
