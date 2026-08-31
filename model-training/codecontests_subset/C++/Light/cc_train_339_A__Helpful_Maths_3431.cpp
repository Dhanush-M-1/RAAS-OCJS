#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int st = 0;
  cin >> s;
  int cnt[4] = {0};
  for (int i = 0; i < s.size(); i++) {
    if ('1' <= s[i] && s[i] <= '3') {
      ++cnt[s[i] - '0'];
    }
  }
  for (int i = 1; i <= 3; i++) {
    for (int j = 0; j < cnt[i]; j++) {
      if (st) {
        cout << "+";
      } else {
        st = 1;
      }
      cout << i;
    }
  }
  return 0;
}
