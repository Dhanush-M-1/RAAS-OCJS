#include <bits/stdc++.h>
using namespace std;
const int maxn = 5e3 + 100;
int q, n, a[maxn], lim[maxn];
int t, l, r, d;
struct node {
  int t, l, r, d;
};
vector<node> g;
int main() {
  cin >> n >> q;
  for (int i = 1; i <= n; ++i) {
    lim[i] = 1000000000;
  }
  memset(a, 0, sizeof(a));
  for (int i = 1; i <= q; ++i) {
    cin >> t >> l >> r >> d;
    g.push_back(node{t, l, r, d});
    if (t == 1) {
      for (; l <= r; ++l) {
        a[l] += d;
      }
    } else {
      for (; l <= r; ++l) {
        lim[l] = min(lim[l], d - a[l]);
      }
    }
  }
  memcpy(a, lim, sizeof(lim));
  for (auto i : g) {
    if (i.t == 1) {
      for (int j = i.l; j <= i.r; ++j) {
        lim[j] += i.d;
      }
    } else {
      bool vis = 0;
      for (int j = i.l; j <= i.r; ++j) {
        if (lim[j] == i.d) {
          vis = 1;
          break;
        }
      }
      if (!vis) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; ++i) {
    cout << a[i] << " ";
  }
  return 0;
}
