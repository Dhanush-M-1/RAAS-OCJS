#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, a[123] = {0}, b;
  cin >> n;
  string s;
  cin >> s;
  for (i = 0; i < s.size(); i++) a[int(s[i])]++;
  for (i = 97; i < 123; i++) {
    if (a[i] % n != 0) {
      cout << -1;
      return 0;
    }
    a[i] = a[i] / n;
  }
  int t = n;
  while (t--) {
    for (i = 97; i < 123; i++) {
      for (b = 0; b < a[i]; b++) cout << (char)i;
    }
  }
}
