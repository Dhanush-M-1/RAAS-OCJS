#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int num[4] = {0}, len, n = 0;
  len = s.size();
  for (int i = 0; i < len; i++) {
    if (s[i] == '1' || s[i] == '2' || s[i] == '3') {
      num[s[i] - '0']++;
      if (n <= s[i] - '0') n = s[i] - '0';
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 0; num[i] > 0 && j < num[i]; j++) {
      cout << i;
      if (i <= 3) {
        if (i == n && j == num[i] - 1) break;
        cout << "+";
      }
    }
  }
  cout << endl;
  return 0;
}
