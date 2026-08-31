#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int ti = 0, ta = 0;
  for (int i = 0; s[i]; ++i) {
    if (s[i] == 'I')
      ++ti;
    else if (s[i] == 'A')
      ++ta;
  }
  if (!ti)
    cout << ta << '\n';
  else if (ti == 1)
    cout << 1 << '\n';
  else
    cout << 0 << '\n';
  return 0;
}
