#include <bits/stdc++.h>
using namespace std;
struct event {
  int t, l, r, v;
};
void solve() {
  int n, q;
  cin >> n >> q;
  vector<event> e(q);
  vector<int64_t> a(n, INT_MAX), upd(n, 0);
  for (int i = 0; i < q; ++i) {
    cin >> e[i].t;
    cin >> e[i].l;
    cin >> e[i].r;
    cin >> e[i].v;
    --e[i].l;
    --e[i].r;
    if (e[i].t == 1) {
      for (int j = e[i].l; j < e[i].r + 1; ++j) {
        upd[j] += e[i].v;
      }
    }
  }
  for (int i = q - 1; i >= 0; --i) {
    if (e[i].t == 2) {
      for (int j = e[i].l; j < e[i].r + 1; ++j) {
        a[j] = min(a[j], e[i].v - upd[j]);
      }
    } else {
      for (int j = e[i].l; j < e[i].r + 1; ++j) {
        upd[j] -= e[i].v;
      }
    }
  }
  vector<int64_t> tmp(a);
  for (int i = 0; i < q; ++i) {
    if (e[i].t == 1) {
      for (int j = e[i].l; j < e[i].r + 1; ++j) {
        tmp[j] += e[i].v;
      }
    } else {
      int64_t here = INT_MIN;
      for (int j = e[i].l; j < e[i].r + 1; ++j) {
        here = max(here, tmp[j]);
      }
      if (here != e[i].v) {
        cout << "NO\n";
        return;
      }
    }
  }
  cout << "YES\n";
  for (int64_t i : a) {
    if (i == INT_MAX)
      cout << rand() % 1000 << " ";
    else
      cout << i << " ";
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
}
