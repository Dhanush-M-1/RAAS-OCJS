#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 30;
const long long int INF = 1e18;
const int MOD = 1e9 + 7;
const int MAXN = 300005;
bool Compare(const pair<int, int> &x, const pair<int, int> &y) {
  if (x.first == y.first) {
    return x.second > y.second;
  }
  return x.first < y.first;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int k;
  string s;
  cin >> k >> s;
  int a[26];
  memset(a, 0, sizeof(a));
  int len = s.length();
  for (int i = 0; i < len; i++) {
    a[s[i] - 'a']++;
  }
  string ans;
  ans = "";
  for (int i = 0; i < 26; i++) {
    if (a[i] != 0 && a[i] % k != 0) {
      cout << -1 << '\n';
      return 0;
    }
    for (int j = 0; j < (a[i] / k); j++) {
      char ch = 'a' + i;
      ans += ch;
    }
  }
  for (int i = 0; i < k; i++) {
    cout << ans;
  }
  cout << '\n';
  return 0;
}
