#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  string w;
  cin >> s >> n;
  bool a, b;
  a = b = false;
  for (int i = 0; i < n; ++i) {
    cin >> w;
    if (w == s) {
      puts("YES");
      return 0;
    }
    if (w[0] == s.back()) a = true;
    if (w.back() == s[0]) b = true;
  }
  if (a && b)
    puts("YES");
  else
    puts("NO");
  return 0;
}
