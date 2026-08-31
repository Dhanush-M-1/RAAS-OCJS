#include <bits/stdc++.h>
#pragma comment(linker, "/stack:16777216")
using namespace std;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 200007;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
struct RMQ {
  int* t;
  int c;
  RMQ(int cc) {
    t = new int[4 * MAX];
    for (int i = (0); i < (4 * MAX); i++) {
      t[i] = 0;
    }
    c = cc;
  }
  void Add(int v, int l, int r, int pos, int val) {
    if (l == r) {
      t[v] += val;
      if (t[v] >= c) t[v] = c;
      return;
    }
    int m = (l + r) / 2;
    if (pos <= m)
      Add(2 * v + 1, l, m, pos, val);
    else
      Add(2 * v + 2, m + 1, r, pos, val);
    t[v] = t[2 * v + 1] + t[2 * v + 2];
  }
  int Get(int v, int l, int r, int L, int R) {
    if (L > R) return 0;
    if (l == L && r == R) {
      return t[v];
    }
    int m = (l + r) / 2;
    return Get(2 * v + 1, l, m, L, min(R, m)) +
           Get(2 * v + 2, m + 1, r, max(m + 1, L), R);
  }
};
int main() {
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  RMQ R1(b);
  RMQ R2(a);
  for (int qq = (0); qq < (q); qq++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int x, y;
      scanf("%d%d", &x, &y);
      --x;
      R1.Add(0, 0, n - 1, x, y);
      R2.Add(0, 0, n - 1, x, y);
    } else {
      int x;
      scanf("%d", &x);
      --x;
      int res =
          R1.Get(0, 0, n - 1, 0, x - 1) + R2.Get(0, 0, n - 1, x + k, n - 1);
      printf("%d\n", res);
    }
  }
  return 0;
}
