#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  sort(s.begin(), s.end());
  int n = s.size() / 2;
  string a;
  a = s[n];
  for (int i = 0; i < n; i++) {
    a += s[i];
    a += s[n + 1 + i];
  }
  cout << a;
  return 0;
}
