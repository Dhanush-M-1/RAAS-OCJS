#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, f, g, h, j, i;
string s, n, p;
int main() {
  cin >> s >> a;
  b = s.size();
  for (i = 0; i < b; i++) {
    if ((int)s[i] < a + 97 && s[i] >= 'a') s[i] = s[i] - 32;
    if ((int)s[i] >= a + 65 && s[i] <= 'Z') s[i] = s[i] + 32;
  }
  cout << s;
}
