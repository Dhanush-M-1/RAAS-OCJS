#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  set<char> ss;
  string str;
  long long k, j = 0, a[27] = {0};
  cin >> k >> str;
  for (int i = 0; i < str.size(); ++i) {
    a[str[i] - 'a']++;
  }
  string ans;
  for (int i = 0; i < 26; ++i) {
    if (a[i] % k != 0)
      return cout << -1, 0;
    else {
      for (int j = 0; j < a[i] / k; ++j) ans += i + 'a';
    }
  }
  for (int i = 0; i < k; ++i) cout << ans;
  return 0;
}
