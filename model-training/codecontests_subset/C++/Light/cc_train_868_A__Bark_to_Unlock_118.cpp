#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  int a = 0, b = 0;
  while (n--) {
    string y;
    cin >> y;
    if (y[1] == s[0]) a = 1;
    if (y[0] == s[1]) b = 1;
    if (y == s) {
      a = 1;
      b = 1;
    }
  }
  if (a == 1 && b == 1)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
