#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnt8 = 0;
  for (int i = 0; i <= n - 1; i++) {
    if (s[i] == '8') cnt8++;
  }
  int left = n;
  int cnt = 0;
  while (cnt8) {
    if (left >= 11) {
      left -= 11;
      cnt8 -= 1;
      cnt++;
    } else
      break;
  }
  cout << cnt << "\n";
  return 0;
}
