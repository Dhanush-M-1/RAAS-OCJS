#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int l, r, i;
  for (i = 1; i < n; ++i) {
    if (s[i] < s[i - 1]) {
      l = i - 1;
      r = i;
      break;
    }
  }
  if (i != n) {
    cout << "YES" << endl;
    cout << l + 1 << " " << r + 1;
  } else
    cout << "NO";
}
