#include <bits/stdc++.h>
#pragma comment(linker, "/stack:16777216")
using namespace std;
const int INF = 1000000000;
const int BASE = 1000000007;
const int MAX = 200047;
const int MAX2 = 7777;
const int MAXE = 100000;
const int ADD = 1000000;
const int MOD = 1000000007;
const int CNT = 800;
int n, k, q;
int a, b;
const int add = 262144;
struct RMQ {
  int F[2 * add];
  int S[2 * add];
  RMQ() {
    memset(F, 0, sizeof(F));
    memset(S, 0, sizeof(S));
  }
  void upd(int pos, int add) {
    pos += MAX;
    F[pos] += add;
    F[pos] = min(F[pos], b);
    S[pos] += add;
    S[pos] = min(S[pos], a);
    pos /= 2;
    while (pos) {
      F[pos] = F[2 * pos + 1] + F[2 * pos];
      S[pos] = S[2 * pos + 1] + S[2 * pos];
      pos /= 2;
    }
  }
  int su(int l, int r, int t) {
    if (l > r) return 0;
    int ret = 0;
    if (l % 2 == 1) {
      if (t)
        ret += S[l];
      else
        ret += F[l];
      l++;
    }
    if (r % 2 == 0) {
      if (t)
        ret += S[r];
      else
        ret += F[r];
      r--;
    }
    return su(l / 2, r / 2, t) + ret;
  }
  int sum(int l1, int r1, int l2, int r2) {
    return su(l1 + MAX, r1 + MAX, 0) + su(l2 + MAX, r2 + MAX, 1);
  }
} R;
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = (0); i < (q); i++) {
    int type, d, add;
    scanf("%d", &type);
    if (type == 1) {
      scanf("%d%d", &d, &add);
      d--;
      R.upd(d, add);
    } else {
      scanf("%d", &d);
      d--;
      cout << R.sum(0, d - 1, d + k, n - 1) << "\n";
    }
  }
  return 0;
}
