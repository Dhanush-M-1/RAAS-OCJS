#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const double eps = 1e-10;
const int MOD = 998857459;
const int INF = 0x3f3f3f3f;
const int maxn = 3e5 + 10;
const int maxm = 5e6 + 10;
int n, k, op[maxn][2], p[maxn << 2];
long long val[maxn << 2];
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
      if (!op[a][0])
        op[a][0] = i;
      else
        op[a][1] = i;
    }
  }
  for (int i = 1; i <= k; ++i) p[i] = i, p[i + k] = i + k, val[i] = 1;
  p[k * 2 + 1] = k * 2 + 1;
  val[k * 2 + 1] = INF;
  int now = 0;
  for (int i = 1; i <= n; ++i) {
    if (!op[i][0]) goto out;
    if (str[i] == '1') {
      if (op[i][1]) {
        if (find(op[i][0]) == find(op[i][1])) goto out;
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        now -= min(val[find(op[i][1])], val[find(op[i][1] + k)]);
        merge(find(op[i][0]), find(op[i][1]));
        merge(find(op[i][0] + k), find(op[i][1] + k));
        now += min(val[find(op[i][1])], val[find(op[i][1] + k)]);
      } else {
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        merge(find(op[i][0]), find(k * 2 + 1));
        now += val[find(op[i][0] + k)];
      }
    } else {
      if (op[i][1]) {
        if (find(op[i][0]) == find(op[i][1] + k)) goto out;
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        now -= min(val[find(op[i][1])], val[find(op[i][1] + k)]);
        merge(find(op[i][0]), find(op[i][1] + k));
        merge(find(op[i][1]), find(op[i][0] + k));
        now += min(val[find(op[i][1] + k)], val[find(op[i][0] + k)]);
      } else {
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        merge(find(op[i][0] + k), find(k * 2 + 1));
        now += val[find(op[i][0])];
      }
    }
  out:
    printf("%d\n", now);
  }
  return 0;
}
