#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n = s.size();
  int j = 0;
  for (int i = 0; i < n; i++) {
    if (i % 2 != 0) {
      s[i] = ' ';
    }
  }
  sort(s.begin(), s.end());
  for (int i = 0; i < n - 1; i++) {
    if (s[i] != ' ') cout << s[i] << "+";
  }
  cout << s[n - 1];
}
