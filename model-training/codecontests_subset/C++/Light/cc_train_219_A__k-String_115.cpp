#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int k;
  cin >> k;
  string s, ans;
  cin >> s;
  ans = s;
  map<char, int> m;
  for (auto x : s) m[x]++;
  int i = 0;
  for (auto x : m)
    if (x.second % k != 0) {
      cout << -1;
      return 0;
    } else {
      while (m[x.first]) {
        for (int j = i; j < s.size(); j += (s.size() / k)) ans[j] = x.first;
        m[x.first] -= k;
        i++;
      }
    }
  cout << ans;
  return 0;
}
