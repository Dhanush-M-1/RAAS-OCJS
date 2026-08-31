#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
long long t, n, m, k, q, a, b, x, y, ans, arr[N];
long long mod = 998244353;
string s;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  t = 1;
  while (t--) {
    cin >> n >> k;
    ans = 0, x = 0, y = 0;
    priority_queue<int, vector<int>, greater<int>> alice, bob, both;
    for (int i = 0; i < n; ++i) {
      cin >> m >> a >> b;
      x += a;
      y += b;
      if (a && b)
        both.push(m);
      else if (a)
        alice.push(m);
      else if (b)
        bob.push(m);
    }
    if (x < k || y < k) {
      cout << -1 << endl;
      continue;
    }
    while (k--) {
      if (!both.empty() && !alice.empty() && !bob.empty()) {
        if (both.top() <= alice.top() + bob.top())
          ans += both.top(), both.pop();
        else
          ans += alice.top() + bob.top(), alice.pop(), bob.pop();
      } else if (both.empty())
        ans += alice.top() + bob.top(), alice.pop(), bob.pop();
      else
        ans += both.top(), both.pop();
    }
    cout << ans << endl;
  }
  return 0;
}
