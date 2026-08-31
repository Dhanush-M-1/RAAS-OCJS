#include <bits/stdc++.h>
using namespace std;
static int y[2 * 200005];
static int y2[2 * 200005];
int orders[2 * 200005];
void update(int i, int x) {
  for (; i < 200005; i += i & -i) y[i] += x;
}
void update2(int i, int x) {
  for (; i < 200005; i += i & -i) y2[i] += x;
}
int prefixSum(int i) {
  int sum = 0;
  for (; i > 0; i -= i & -i) sum += y[i];
  return sum;
}
int prefixSum2(int i) {
  int sum = 0;
  for (; i > 0; i -= i & -i) sum += y2[i];
  return sum;
}
int query(int i, int j) { return prefixSum(j) - prefixSum(i - 1); }
int query2(int i, int j) { return prefixSum2(j) - prefixSum2(i - 1); }
int main() {
  cin.tie(NULL);
  cout.tie(NULL);
  ios_base::sync_with_stdio(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < 2 * 200005; i++) {
    y[i] = 0;
    y2[i] = 0;
    orders[i] = 0;
  }
  for (int i = 0; i < q; i++) {
    int j;
    cin >> j;
    if (j == 1) {
      int ai, di;
      cin >> di >> ai;
      orders[di] += ai;
      update(di, min(orders[di], b) - min((orders[di] - ai), b));
      update2(di, min(orders[di], a) - min((orders[di] - ai), a));
    }
    if (j == 2) {
      int p;
      cin >> p;
      cout << query(1, p - 1) + query2(p + k, n) << '\n';
    }
  }
  return 0;
}
