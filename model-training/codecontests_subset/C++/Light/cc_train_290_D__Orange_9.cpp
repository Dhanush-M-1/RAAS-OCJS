#include <bits/stdc++.h>
using namespace std;
int i, m, ans, k, l, j, q, x, n, ma, mi;
string s;
int main() {
  i = 0;
  cin >> s;
  cin >> x;
  for (i = 0; i < s.size(); i++)
    if (s[i] <= 'Z') s[i] += 'a' - 'A';
  for (i = 0; i < s.size(); i++) {
    if (s[i] < x + 97)
      if (s[i] > 'Z')
        s[i] += 'A' - 'a';
      else if (s[i] <= 'Z')
        s[i] += 'a' - 'A';
  }
  cout << s << endl;
}
