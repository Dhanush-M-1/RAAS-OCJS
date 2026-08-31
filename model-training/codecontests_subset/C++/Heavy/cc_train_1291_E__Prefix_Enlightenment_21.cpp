#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-10;
const int MOD = 998857459;
const int INF = 0x3f3f3f3f;
const int maxn = 3e5 + 10;
const int maxm = 5e6 + 10;
int n, k, op[maxn][2], p[maxn << 1], val[maxn << 1];
char str[maxn];
int find(int first) {
  return p[first] == first ? p[first] : p[first] = find(p[first]);
}
void merge(int first, int second) {
  if (first == second) return;
  val[second] += val[first];
  p[first] = second;
}
int main() {
  cin >> n >> k;
  scanf("%s", str + 1);
  for (int i = 1, sz, a; i <= k; ++i) {
    scanf("%d", &sz);
    while (sz--) {
      scanf("%d", &a);
      op[a][bool(op[a][0])] = i;
    }
    val[i] = 1;
    p[i] = i;
    p[i + k] = i + k;
  }
  val[0] = INF;
  int now = 0;
  for (int i = 1; i <= n; ++i) {
    int fa = find(op[i][0]), fb = find(op[i][1]);
    int rfa = find(op[i][0] + k), rfb = find(op[i][1] + k);
    if (!op[i][0]) goto out;
    if (str[i] == '1') {
      if (op[i][1]) {
        if (fa == fb) goto out;
        now -= min(val[fa], val[rfa]);
        now -= min(val[fb], val[rfb]);
        merge(fa, fb);
        merge(rfa, rfb);
        now += min(val[fb], val[rfb]);
      } else {
        now -= min(val[fa], val[rfa]);
        merge(fa, find(0));
        now += val[rfa];
      }
    } else {
      if (op[i][1]) {
        if (fa == rfb) goto out;
        now -= min(val[fa], val[rfa]);
        now -= min(val[fb], val[rfb]);
        merge(fa, rfb);
        merge(fb, rfa);
        now += min(val[rfb], val[rfa]);
      } else {
        now -= min(val[fa], val[rfa]);
        merge(rfa, find(0));
        now += val[fa];
      }
    }
  out:
    printf("%d\n", now);
  }
  return 0;
}
