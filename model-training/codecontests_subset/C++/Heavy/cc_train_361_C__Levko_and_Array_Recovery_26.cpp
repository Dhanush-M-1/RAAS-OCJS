#include <bits/stdc++.h>
using namespace std;
int const N = 5e3 + 10;
int n, m;
bool ok[N];
long long sum[N], ini[N], s[N];
struct qry {
  int type, val, l, r;
  qry(int type, int val, int l, int r) : type(type), val(val), l(l), r(r) {}
};
vector<qry> q;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int type, l, r, d;
    scanf("%d %d %d %d", &type, &l, &r, &d);
    q.push_back(qry(type, d, l, r));
    if (type == 1)
      for (int k = l; k <= r; k++) sum[k] += d;
    if (type == 2) {
      for (int k = l; k <= r; k++) {
        if (!ok[k])
          ini[k] = d - sum[k], ok[k] = 1;
        else if (ok[k] && ini[k] + sum[k] > d)
          ini[k] = d - sum[k];
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (!ok[i]) ini[i] = -1e9;
    s[i] = ini[i];
  }
  for (int i = 0; i < m; i++) {
    int type = q[i].type, l = q[i].l, r = q[i].r, val = q[i].val;
    long long maior = -1e9;
    if (type == 1)
      for (int k = l; k <= r; k++) s[k] += val;
    if (type == 2) {
      for (int k = l; k <= r; k++) maior = max(maior, s[k]);
      if (maior != val) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= n; i++) printf("%I64d ", ini[i]);
  return 0;
}
