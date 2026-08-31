#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q, query, c[200010], d, e, p, old[200010], rep[200010],
    treeo[200010], treer[200010];
void updateo(int i, int x) {
  for (int k = i; k <= n; k += (k & -k)) {
    treeo[k] += (x - old[i]);
  }
}
void updater(int i, int x) {
  for (int k = i; k > 0; k -= (k & -k)) {
    treer[k] += (x - rep[i]);
  }
}
int queryo(int i) {
  int ans = 0;
  for (int k = i; k > 0; k -= (k & -k)) {
    ans += treeo[k];
  }
  return ans;
}
int queryr(int i) {
  int ans = 0;
  for (int k = i; k <= n; k += (k & -k)) ans += treer[k];
  return ans;
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &query);
    if (query == 1) {
      scanf("%d %d", &d, &e);
      c[d] += e;
      updateo(d, min(c[d], b));
      updater(d, min(c[d], a));
      old[d] = min(c[d], b);
      rep[d] = min(c[d], a);
    } else {
      scanf("%d", &p);
      printf("%d\n", queryo(p - 1) + queryr(p + k));
    }
  }
  return 0;
}
