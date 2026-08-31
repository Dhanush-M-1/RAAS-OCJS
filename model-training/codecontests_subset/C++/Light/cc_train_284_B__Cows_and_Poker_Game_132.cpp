#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int f, i, a;
  for (int m = f = i = a = 0; s[m]; ++m) {
    if (s[m] == 'A')
      ++a;
    else if (s[m] == 'I')
      ++i;
    else
      ++f;
  }
  if (i > 1)
    cout << 0;
  else if (i == 1)
    cout << 1;
  else
    cout << a;
  return 0;
}
