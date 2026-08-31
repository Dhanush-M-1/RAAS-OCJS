#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string s;
  vector<int> count(26);
  cin >> k >> s;
  for (char i : s) count[i - 97]++;
  s = "";
  for (int i = 0; i < 26; ++i) {
    if (count[i] % k > 0) {
      cout << -1 << '\n';
      return 0;
    }
    for (int j = 1; j <= count[i] / k; ++j) {
      s += i + 97;
    }
  }
  for (int i = 1; i <= k; ++i) cout << s;
  cout << '\n';
  return 0;
}
