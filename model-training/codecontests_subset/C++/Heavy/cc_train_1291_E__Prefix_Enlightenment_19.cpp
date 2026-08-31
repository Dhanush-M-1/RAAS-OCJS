#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5, inf = 1e9;
int n, k, s, x, op[N][2];
char ch[N];
int p[N << 1], val[N << 1];
int find(int u) { return p[u] == u ? p[u] : p[u] = find(p[u]); }
void merge(int a, int b) {
  if (a == b) return;
  val[b] += val[a];
  p[a] = b;
}
int main() {
  scanf("%d%d%s", &n, &k, ch + 1);
  for (int i = 1; i <= k; i++) {
    scanf("%d", &s);
    while (s--) {
      scanf("%d", &x);
      op[x][bool(op[x][0])] = i;
    }
  }
  for (int i = 1; i <= k; i++) val[i] = 1, p[i] = i, p[i + k] = i + k;
  p[k + k + 1] = k + k + 1;
  val[k + k + 1] = inf;
  int now = 0;
  for (int i = 1; i <= n; i++) {
    if (op[i][0] == 0) goto qwq;
    if (ch[i] == '1') {
      if (op[i][1]) {
        if (find(op[i][0]) == find(op[i][1])) goto qwq;
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        now -= min(val[find(op[i][1])], val[find(op[i][1] + k)]);
        merge(find(op[i][0]), find(op[i][1]));
        merge(find(op[i][0] + k), find(op[i][1] + k));
        now += min(val[find(op[i][1])], val[find(op[i][1] + k)]);
      } else {
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        merge(find(op[i][0]), find(k + k + 1));
        now += val[find(op[i][0] + k)];
      }
    } else {
      if (op[i][1]) {
        if (find(op[i][0]) == find(op[i][1] + k)) goto qwq;
        now -= min(val[find(op[i][1])], val[find(op[i][1] + k)]);
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        merge(find(op[i][0]), find(op[i][1] + k)),
            merge(find(op[i][1]), find(op[i][0] + k));
        now += min(val[find(op[i][1] + k)], val[find(op[i][0] + k)]);
      } else {
        now -= min(val[find(op[i][0])], val[find(op[i][0] + k)]);
        merge(find(op[i][0] + k), find(k + k + 1));
        now += val[find(op[i][0])];
      }
    }
  qwq:
    printf("%d\n", now);
  }
  return 0;
}
