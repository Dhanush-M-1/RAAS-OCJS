#include <bits/stdc++.h>
using namespace std;
int solve() {
  int n, k;
  cin >> n >> k;
  int a, b, ans;
  ans = a = b = 0;
  priority_queue<int> x, y, z;
  while (n--) {
    int t, u, v;
    cin >> t >> u >> v;
    t *= -1;
    if (u && v) {
      z.push(t);
    } else if (u) {
      x.push(t);
    } else if (v) {
      y.push(t);
    }
  }
  while (!x.empty() && !y.empty() && !z.empty() && a < k) {
    int u, v, w;
    u = -x.top();
    v = -y.top();
    w = -z.top();
    if (u + v < w) {
      ans += u + v;
      x.pop();
      y.pop();
    } else {
      ans += w;
      z.pop();
    }
    ++a;
    ++b;
  }
  while (a < k && !z.empty() && x.empty()) {
    ans += -z.top();
    z.pop();
    ++a;
    ++b;
  }
  while (b < k && !z.empty() && y.empty()) {
    ans += -z.top();
    z.pop();
    ++a;
    ++b;
  }
  while (a < k && !x.empty() && !z.empty()) {
    int u = -x.top();
    int w = -z.top();
    if (u < w) {
      ans += u;
      ++a;
      x.pop();
    } else {
      ans += w;
      ++a;
      ++b;
      z.pop();
    }
  }
  while (a < k && !x.empty()) {
    ans += -x.top();
    x.pop();
    ++a;
  }
  while (b < k && !y.empty() && !z.empty()) {
    int u = -y.top();
    int w = -z.top();
    if (u < w) {
      ans += u;
      ++b;
      y.pop();
    } else {
      ans += w;
      ++a;
      ++b;
      z.pop();
    }
  }
  while (b < k && !y.empty()) {
    ans += -y.top();
    y.pop();
    ++b;
  }
  if (a < k || b < k)
    cout << "-1\n";
  else
    cout << ans << '\n';
  return 0;
}
int main() {
  cin.tie(0)->sync_with_stdio(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
