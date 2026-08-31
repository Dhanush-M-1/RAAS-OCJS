#include <bits/stdc++.h>
using namespace std;
const int MOD9 = 1e9 + 7;
const int MOD91 = 1e9 + 9;
const long long MOD12 = 1e12 + 39LL;
const long long MOD15 = 1e15 + 37LL;
const int INF = 1e9;
const int base = 1e9;
const int MAXN = 2e5 + 6;
const long double EPS = 1e-10;
int n, k, a, b, q;
int aa[MAXN], bb[MAXN];
int tp[MAXN], ts[MAXN];
int sum(int r, int t[]) {
  int result = 0;
  for (; r >= 0; r = (r & (r + 1)) - 1) result += t[r];
  return result;
}
void inc(unsigned i, int delta, int t[]) {
  for (; i < n; i = (i | (i + 1))) {
    t[i] += delta;
  }
}
int main() {
  scanf("%d %d %d %d %d\n", &n, &k, &a, &b, &q);
  for (int i = (0); i < (q); ++i) {
    int x, y, z;
    scanf("%d ", &x);
    if (x == 1) {
      scanf("%d %d\n", &y, &z);
      int x1 = aa[y - 1];
      aa[y - 1] += z;
      if (aa[y - 1] > a) {
        aa[y - 1] = a;
      }
      if (aa[y - 1] - x1) inc((unsigned)(n - y), aa[y - 1] - x1, ts);
      x1 = bb[y - 1];
      bb[y - 1] += z;
      if (bb[y - 1] > b) {
        bb[y - 1] = b;
      }
      if (bb[y - 1] - x1) inc(y - 1, bb[y - 1] - x1, tp);
    } else {
      scanf("%d\n", &y);
      cout << sum(y - 2, tp) + sum(n - y - k, ts) << endl;
    }
  }
  return 0;
}
