#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, l, r;
  string s;
  cin >> n >> s;
  string m = "zz";
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      string h = s.substr(i, i + 1);
      if (h < m) {
        m = h;
        l = i + 1;
        r = i + 2;
      }
    }
  }
  if (m == "zz") {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n" << l << " " << r << endl;
  return 0;
}
