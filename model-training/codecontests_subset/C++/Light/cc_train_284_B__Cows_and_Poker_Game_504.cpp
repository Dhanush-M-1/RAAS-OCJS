#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int is, fs, as, n;
  is = fs = as = 0;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') as++;
    if (s[i] == 'I') is++;
    if (s[i] == 'F') fs++;
  }
  if (is == 0)
    cout << as << endl;
  else if (is > 1)
    cout << 0 << endl;
  else if (is == 1)
    cout << 1 << endl;
  return 0;
}
