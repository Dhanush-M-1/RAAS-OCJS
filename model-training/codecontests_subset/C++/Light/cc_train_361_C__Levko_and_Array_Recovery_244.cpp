#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using llu = long long unsigned;
using ld = long double;
const int inf = 0x3c3c3c3c;
const ll infl = 0x3c3c3c3c3c3c3c3c;
const int MAX_N = 5e3 + 9;
struct Inst {
  int t, l, r, o;
};
int init[MAX_N];
int ans[MAX_N];
Inst inst[MAX_N];
int main() {
  cin.tie(NULL);
  cin.sync_with_stdio(false);
  cout.sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < m; i++) {
    int t, l, r, o;
    cin >> t >> l >> r >> o;
    inst[i] = {t, l, r, o};
  }
  for (int i = 1; i <= n; i++) {
    bool flag = false;
    for (int j = m - 1; j >= 0; j--) {
      int t = inst[j].t;
      int l = inst[j].l;
      int r = inst[j].r;
      int v = inst[j].o;
      if (t == 1 && flag && l <= i && i <= r) ans[i] -= v;
      if (t == 2 && l <= i && i <= r) {
        if (flag) {
          if (ans[i] > v) ans[i] = v;
        } else {
          ans[i] = v;
          flag = true;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) init[i] = ans[i];
  for (int i = 0; i < m; i++) {
    int l = inst[i].l, r = inst[i].r;
    int v = inst[i].o;
    if (inst[i].t == 1) {
      for (int i = l; i <= r; i++) init[i] += v;
    } else {
      int maxV = init[l];
      for (int i = l; i <= r; i++) maxV = max(maxV, init[i]);
      if (v != maxV) return !printf("NO");
    }
  }
  printf("YES\n");
  for (int i = 1; i <= n; i++) printf("%d ", ans[i]);
  return 0;
}
