#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
using namespace std;
template <class T1, class T2>
ostream &operator<<(ostream &os, const pair<T1, T2> &p) {
  os << "{" << p.first << "," << p.second << "}";
  return os;
}
const int N = 3e5 + 5;
const int oo = 1e9 + 7;
int a[N];
int w[N];
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, m;
  cin >> n >> m;
  int sz = 0;
  int ans = 0;
  for (int i = 1; i <= n; i++) cin >> w[i];
  while (m--) {
    int b;
    cin >> b;
    int idx = 0;
    for (int i = 1; i <= sz; i++) {
      if (a[i] == b) {
        idx = i;
        break;
      }
    }
    for (int i = idx + 1; i <= sz; i++) ans += w[a[i]];
    if (idx != 0) {
      for (int i = idx; i < sz; i++) a[i] = a[i + 1];
      sz--;
    }
    a[++sz] = b;
  }
  cout << ans;
}
