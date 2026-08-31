#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 1e5 + 10;
long long t[2][4 * N], a, b;
void update(int l, int r, int j, int pos, int val) {
  if (r < pos || pos < l) return;
  if (pos <= l && r <= pos) {
    t[0][j] = min(a, t[0][j] + val);
    t[1][j] = min(b, t[1][j] + val);
    return;
  }
  int mid = (l + r) >> 1;
  update(l, mid, 2 * j, pos, val);
  update(mid + 1, r, 2 * j + 1, pos, val);
  if (l != r) {
    t[0][j] = t[0][2 * j] + t[0][2 * j + 1];
    t[1][j] = t[1][2 * j] + t[1][2 * j + 1];
  }
}
long long getSum(int l, int r, int j, int x, int y, int wh) {
  if (r < x || y < l) return 0LL;
  if (x <= l && r <= y) {
    return t[wh][j];
  }
  int mid = (l + r) >> 1;
  long long X = getSum(l, mid, (j << 1), x, y, wh);
  long long Y = getSum(mid + 1, r, ((j << 1) | 1), x, y, wh);
  return X + Y;
}
int n, k, q;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int type;
    cin >> type;
    if (type == 1) {
      int di, ai;
      cin >> di >> ai;
      update(1, n, 1, di, ai);
    } else {
      int p;
      cin >> p;
      long long res = getSum(1, n, 1, 1, p - 1, 1);
      res += getSum(1, n, 1, p + k, n, 0);
      cout << res << "\n";
    }
  }
  return 0;
}
