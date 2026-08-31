#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int maxn = 1000005;
long long pre[maxn];
int vio[maxn];
void go() {
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i < m + 1; i++) {
    int x;
    cin >> x;
    vio[x] = 1;
  }
  pre[0] = -1;
  if (vio[0]) {
    cout << -1 << '\n';
    exit(0);
  }
  for (int i = 0; i < n + 1; i++) {
    if (!vio[i]) {
      pre[i] = i;
    } else {
      pre[i] = pre[i - 1];
    }
  }
  long long mi = 1e18;
  for (int i = 1; i < k + 1; i++) {
    long long v;
    cin >> v;
    long long cur = 0;
    int cnt = 0;
    int last = -74751;
    int f = 0;
    while (cur < n) {
      int x = pre[cur];
      if (x == last) {
        f = 1;
        break;
      }
      cnt++;
      last = x;
      cur = x + i;
    }
    if (!f) {
      mi = min(mi, cnt * v);
    }
  }
  if (mi > 1e15) {
    cout << -1 << '\n';
  } else {
    cout << mi << '\n';
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int c = 0;
  int t;
  if (!c) {
    t = 1;
  } else {
    cin >> t;
  }
  while (t--) {
    go();
  }
}
