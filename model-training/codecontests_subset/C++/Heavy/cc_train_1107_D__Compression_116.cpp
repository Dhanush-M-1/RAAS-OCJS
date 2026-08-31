#include <bits/stdc++.h>
using namespace std;
const int N = 1e4;
const int mod = 1e9 + 7;
int n;
string s[N];
map<pair<string, int>, bool> dp;
bool checkhor(int i, int x) {
  if (x == 1) return true;
  string t = s[i];
  if (dp.count({t, x})) return dp[{t, x}];
  deque<int> v;
  for (int j = int(t.size() - 1); j >= int(0); j--) {
    int num = t[j] - '0';
    if (t[j] >= 'A' and t[j] <= 'Z') {
      num = 10 + (t[j] - 'A');
    }
    for (int i = int(1); i <= int(4); i++) {
      v.push_front(num % 2);
      num /= 2;
    }
  }
  bool ok = true;
  for (int i = 0; i < v.size(); i += x) {
    for (int j = int(i); j <= int(i + x - 1); j++) {
      if (v[j] != v[i]) {
        ok = false;
        break;
      }
    }
  }
  return dp[{t, x}] = ok;
}
bool check(int x) {
  if (x == 1) return true;
  for (int i = int(1); i <= int(n); i++) {
    int j = ceil(1.0 * i / x);
    bool ok = checkhor(i, x);
    if (s[i] != s[x * (j - 1) + 1] or !ok) {
      return false;
    }
  }
  return true;
}
signed main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = int(1); i <= int(n); i++) cin >> s[i];
  for (int i = int(n); i >= int(1); i--) {
    if (n % i) continue;
    if (check(i)) {
      cout << i << '\n';
      return 0;
    }
  }
  return 0;
}
