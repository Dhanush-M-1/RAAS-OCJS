#include <bits/stdc++.h>
using namespace std;
long long st[2][4 * 200010 + 2];
long long v[2][2 * 200010 + 2];
long long n, k, a, b, q;
void update(int p, int a, int b, int pos, long long val, bool flag) {
  if (pos < a || pos > b) return;
  if (a == b) {
    st[flag][p] += val;
  } else {
    int mid = (a + b) / 2;
    update(2 * p, a, mid, pos, val, flag);
    update(2 * p + 1, mid + 1, b, pos, val, flag);
    st[flag][p] = st[flag][2 * p] + st[flag][2 * p + 1];
  }
}
long long query(int p, int a, int b, int i, int j, int flag) {
  if (a > j || b < i || a > b) return 0;
  if (a >= i && b <= j) {
    return st[flag][p];
  }
  int mid = (a + b) / 2;
  long long x = query(2 * p, a, mid, i, j, flag);
  long long y = query(2 * p + 1, mid + 1, b, i, j, flag);
  return x + y;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    long long x, y;
    cin >> x;
    if (x == 1) {
      cin >> x >> y;
      update(1, 1, n, x, min(b, y + v[0][x]) - v[0][x], 0);
      update(1, 1, n, x, min(a, y + v[1][x]) - v[1][x], 1);
      v[0][x] = query(1, 1, n, x, x, 0);
      v[1][x] = query(1, 1, n, x, x, 1);
    } else if (x == 2) {
      cin >> x;
      long long ans = query(1, 1, n, 1, x - 1, 0);
      ans += query(1, 1, n, x + k, n, 1);
      cout << ans << endl;
    }
  }
  return 0;
}
