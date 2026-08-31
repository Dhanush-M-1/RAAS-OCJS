#include <bits/stdc++.h>
using namespace std;
int val[5005], n, m;
int ans[5005];
struct operation {
  int type, l, r, t;
} op[5005];
void init() {
  for (int i = 1; i <= n; i++) val[i] = 1000000000;
}
void backward() {
  for (int i = m; i >= 1; i--) {
    if (op[i].type == 1) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        if (val[j] != 1000000000) val[j] -= op[i].t;
      }
    } else {
      for (int j = op[i].l; j <= op[i].r; j++) {
        val[j] = min(val[j], op[i].t);
      }
    }
  }
  for (int i = 1; i <= n; i++) ans[i] = val[i];
}
bool forward() {
  for (int i = 1; i <= m; i++) {
    if (op[i].type == 1) {
      for (int j = op[i].l; j <= op[i].r; j++) {
        val[j] += op[i].t;
      }
    } else {
      int ans = val[op[i].l];
      for (int j = op[i].l; j <= op[i].r; j++) ans = max(ans, val[j]);
      if (ans != op[i].t) return false;
    }
  }
  return true;
}
void solve() {
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &op[i].type, &op[i].l, &op[i].r, &op[i].t);
  }
  init();
  backward();
  if (forward()) {
    puts("YES");
    for (int i = 1; i <= n; i++) {
      if (i != 1) printf(" ");
      printf("%d", ans[i]);
    }
    puts("");
  } else
    puts("NO");
}
int main() {
  while (~scanf("%d%d", &n, &m)) {
    solve();
  }
  return 0;
}
