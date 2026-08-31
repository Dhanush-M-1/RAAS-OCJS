#include <bits/stdc++.h>
using namespace std;
long long tree1[1000001], tree2[1000001];
void build(long long l, long long r, long long cur) {
  if (l == r) {
    tree1[cur] = 0;
    tree2[cur] = 0;
    return;
  }
  long long m = (l + r) / 2;
  build(l, m, 2 * cur + 1);
  build(m + 1, r, 2 * cur + 2);
  tree1[cur] = 0;
  tree2[cur] = 0;
}
long long sum1(long long l, long long r, long long start, long long end,
               long long cur) {
  if (l <= start && end <= r) return tree1[cur];
  if (l > end || start > r) return 0;
  long long m = (start + end) / 2;
  return sum1(l, r, start, m, 2 * cur + 1) +
         sum1(l, r, m + 1, end, 2 * cur + 2);
}
long long sum2(long long l, long long r, long long start, long long end,
               long long cur) {
  if (l <= start && end <= r) return tree2[cur];
  if (l > end || start > r) return 0;
  long long m = (start + end) / 2;
  return sum2(l, r, start, m, 2 * cur + 1) +
         sum2(l, r, m + 1, end, 2 * cur + 2);
}
void update1(long long idx, long long l, long long r, long long cur,
             long long val, long long val1) {
  if (l == r && l == idx) {
    tree1[cur] = min(tree1[cur] + val, val1);
    return;
  }
  if (idx < l || idx > r) return;
  long long m = (l + r) / 2;
  update1(idx, l, m, 2 * cur + 1, val, val1);
  update1(idx, m + 1, r, 2 * cur + 2, val, val1);
  tree1[cur] = tree1[2 * cur + 1] + tree1[2 * cur + 2];
}
void update2(long long idx, long long l, long long r, long long cur,
             long long val, long long val1) {
  if (l == r && l == idx) {
    tree2[cur] = min(tree2[cur] + val, val1);
    return;
  }
  if (idx < l || idx > r) return;
  long long m = (l + r) / 2;
  update2(idx, l, m, 2 * cur + 1, val, val1);
  update2(idx, m + 1, r, 2 * cur + 2, val, val1);
  tree2[cur] = tree2[2 * cur + 1] + tree2[2 * cur + 2];
}
int main() {
  ios_base::sync_with_stdio(false);
  int t = 1;
  while (t--) {
    long long i, j, k, n, a, b, q;
    cin >> n >> k >> a >> b >> q;
    for (i = 0; i < q; i++) {
      long long k1, d;
      cin >> j >> k1;
      if (j == 1) {
        cin >> d;
        update1(k1 - 1, 0, n - 1, 0, d, a);
        update2(k1 - 1, 0, n - 1, 0, d, b);
        continue;
      }
      k1--;
      long long x = sum1(k1 + k, n - 1, 0, n - 1, 0);
      x += sum2(0, k1 - 1, 0, n - 1, 0);
      cout << x << "\n";
    }
  }
}
