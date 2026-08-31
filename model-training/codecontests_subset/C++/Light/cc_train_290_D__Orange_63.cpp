#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, i;
  string s;
  cin >> s >> n;
  for (i = 0; i < s.length(); i++) {
    if (s[i] < 97) s[i] += 32;
    if (s[i] < n + 97) s[i] -= 32;
  }
  cout << s;
  return 0;
}
