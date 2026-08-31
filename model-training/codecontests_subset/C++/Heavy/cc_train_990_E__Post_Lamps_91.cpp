#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
const long long inf = 1e18;
int n, m, k;
int c[N];
int a[N];
int v[N];
int get(int k) {
  int p = 0, s = 0;
  while (p < n) {
    int ls = v[p];
    if (ls + k <= p) return -1;
    p = ls + k;
    s++;
  }
  return s;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < (m); i++) {
    int x;
    cin >> x;
    a[x] = 1;
  }
  for (int i = (1); i <= (k); i++) cin >> c[i];
  if (a[0]) {
    cout << "-1\n";
    return 0;
  }
  for (int i = 1; i < n; i++) {
    v[i] = v[i - 1];
    if (!a[i]) v[i] = i;
  }
  long long ans = inf;
  for (int i = (1); i <= (k); i++) {
    int t = get(i);
    if (t != -1) {
      ans = min(ans, 1LL * c[i] * t);
    }
  }
  if (ans == inf) ans = -1;
  cout << ans << endl;
}
