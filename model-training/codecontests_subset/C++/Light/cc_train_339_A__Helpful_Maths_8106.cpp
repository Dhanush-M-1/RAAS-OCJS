#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> s;
  n = s.length();
  sort(s.begin(), s.end());
  for (int i = (n / 2); i < n; i++) {
    cout << s[i];
    if (i < n - 1) cout << '+';
  }
  return 0;
}
