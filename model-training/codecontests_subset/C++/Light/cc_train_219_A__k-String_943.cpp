#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int cnt[26] = {0}, k;
  string s;
  cin >> k >> s;
  for (int i{}; i < s.size(); i++) {
    cnt[s[i] - 'a']++;
  }
  string res{};
  for (int i{}; i < 26; i++) {
    if (cnt[i] % k) {
      cout << -1 << '\n';
      return 0;
    }
    if (cnt[i])
      for (int j{}; j < cnt[i] / k; j++) res += char('a' + i);
  }
  for (int i{}; i < k; i++) cout << res;
  return 0;
}
