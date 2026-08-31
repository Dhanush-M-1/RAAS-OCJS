#include <bits/stdc++.h>
using namespace std;
const int N = 2e5;
int a[N], p[N], inv[N], n;
int f[N + 1];
int read(int idx) {
  int sum = 0;
  idx++;
  while (idx > 0) {
    sum += f[idx];
    idx -= (idx & -idx);
  }
  return sum;
}
void update(int idx, int val) {
  idx++;
  while (idx <= n) {
    f[idx] += val;
    idx += (idx & -idx);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i], a[i]--;
  for (int i = 0; i < n; i++) p[a[i]] = i;
  for (int i = n - 1; i >= 0; i--) {
    inv[a[i]] = read(a[i]);
    update(a[i], 1);
  }
  long long ans = 0;
  int l = p[0], r = l;
  update(p[0], -1);
  cout << ans << " ";
  for (int i = 1; i < n; i++) {
    int lc = p[i] + 1 - read(p[i]), rc = i - lc;
    update(p[i], -1);
    if (lc > rc) {
      int lb = 0, rb = p[i] - 1;
      while (lb <= rb) {
        int m = (lb + rb) / 2;
        int mc = m + 1 - read(m);
        if (mc >= i + 1 - mc) {
          rb = m - 1;
        } else {
          lb = m + 1;
        }
      }
      ans += read(p[i]) - read(lb);
    } else if (lc < rc) {
      ans += rc - lc;
      int lb = p[i] + 1, rb = n - 1;
      while (lb <= rb) {
        int m = (lb + rb) / 2;
        int mc = m + 1 - read(m);
        if (mc <= i + 1 - mc) {
          lb = m + 1;
        } else {
          rb = m - 1;
        }
      }
      ans += read(rb) - read(p[i]);
    }
    cout << ans << " ";
  }
  return 0;
}
