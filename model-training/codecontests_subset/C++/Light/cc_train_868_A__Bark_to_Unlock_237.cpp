#include <bits/stdc++.h>
using namespace std;
int main() {
  string p;
  cin >> p;
  int n;
  cin >> n;
  bool a = false, b = false;
  while (n--) {
    string s;
    cin >> s;
    if (s == p) {
      a = true;
      b = true;
    }
    if (s[0] == p[1]) a = true;
    if (s[1] == p[0]) b = true;
  }
  if (a && b)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
