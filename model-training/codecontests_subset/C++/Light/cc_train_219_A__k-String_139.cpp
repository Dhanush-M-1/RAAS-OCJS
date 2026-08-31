#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int k;
  string str, ans;
  cin >> k >> str;
  map<char, int> m;
  for (int i = 0; str[i]; ++i) {
    m[str[i]]++;
  }
  for (auto x : m) {
    if (x.second % k != 0) {
      cout << "-1";
      return 0;
    }
    for (int i = 1; i <= x.second / k; ++i) {
      ans += x.first;
    }
  }
  for (int i = 0; i < k; ++i) {
    cout << ans;
  }
  return 0;
}
