#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int len;
  string s;
  cin >> len >> s;
  int flag = 1;
  for (int i = 1; i < s.length(); i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << endl;
      cout << i << " " << i + 1 << endl;
      flag = 0;
      break;
    }
  }
  if (flag) cout << "NO" << endl;
  return 0;
}
