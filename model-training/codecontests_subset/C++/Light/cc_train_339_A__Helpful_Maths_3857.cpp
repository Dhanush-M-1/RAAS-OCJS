#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int cnt[4] = {0};
  for (int i = 0; i < s.size(); i++) {
    if ('1' <= s[i] && s[i] <= '3') {
      ++cnt[s[i] - '0'];
    }
  }
  bool started(0);
  for (int k = 1; k <= 3; k++) {
    for (int m = 0; m < cnt[k]; m++) {
      if (started) {
        cout << "+";
      } else {
        started = 1;
      }
      cout << k;
    }
  }
  return 0;
}
