#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s, s1;
  cin >> n >> s;
  s1 = s;
  for (unsigned i = 1; i < s.length(); i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES\n" << i << ' ' << i + 1;
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
