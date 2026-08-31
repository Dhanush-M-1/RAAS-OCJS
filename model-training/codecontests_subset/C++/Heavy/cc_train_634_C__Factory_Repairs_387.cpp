#include <bits/stdc++.h>
using namespace std;
const int MAXn = 2e5 + 10;
long long tr[2][MAXn];
long long a[2][MAXn];
int mx[2];
int n;
void add(int ti, int i, int v) {
  if (a[ti][i] + v > mx[ti]) {
    v = mx[ti] - a[ti][i];
  }
  a[ti][i] += v;
  while (i <= n) {
    tr[ti][i] += v;
    i += (i & -i);
  }
}
long long get(int ti, int i) {
  long long res = 0;
  while (i > 0) {
    res += tr[ti][i];
    i -= (i & -i);
  }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  int k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  mx[0] = b;
  mx[1] = a;
  for (int i = 0; i < q; i++) {
    int t, j;
    cin >> t >> j;
    if (t == 1) {
      int v;
      cin >> v;
      add(0, j, v);
      add(1, n + 1 - j, v);
    } else {
      cout << get(0, j - 1) + get(1, n + 1 - (j + k)) << '\n';
    }
  }
  return 0;
}
