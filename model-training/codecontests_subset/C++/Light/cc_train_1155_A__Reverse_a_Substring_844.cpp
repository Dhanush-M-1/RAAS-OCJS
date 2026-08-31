#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int l, r, tr = 0;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      char t = s[i];
      s[i] = s[i + 1];
      s[i + 1] = t;
      l = i + 1;
      r = i + 2;
      tr = 1;
      break;
    }
  }
  if (tr == 1) {
    cout << "YES" << endl;
    cout << l << " " << r;
  } else
    cout << "NO" << endl;
  return 0;
}
