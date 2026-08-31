#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, j = 0;
  string str;
  cin >> k >> str;
  sort(str.begin(), str.end());
  string tmp, ans1;
  for (int i = 0; i < str.size() / k; i++) {
    tmp += str[j];
    j += k;
  }
  for (int i = 0; i < k; i++) ans1 += tmp;
  string ans2 = ans1;
  sort(ans2.begin(), ans2.end());
  (ans2 == str) ? cout << ans1 : cout << -1;
  return 0;
}
