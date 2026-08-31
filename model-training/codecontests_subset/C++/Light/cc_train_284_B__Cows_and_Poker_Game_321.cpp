#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, f = 0, in = 0, n;
  string s;
  cin >> n;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A') {
      a++;
    }
    if (s[i] == 'F') {
      f++;
    }
    if (s[i] == 'I') {
      in++;
    }
  }
  if (in > 0) {
    if (in > 1) {
      cout << 0 << endl;
      return 0;
    }
    cout << in << endl;
    return 0;
  }
  cout << a << endl;
  return 0;
}
