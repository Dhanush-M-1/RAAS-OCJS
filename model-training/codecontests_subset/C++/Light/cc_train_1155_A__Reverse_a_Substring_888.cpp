#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  string ss = s;
  sort(ss.begin(), ss.end());
  if (ss.compare(s) == 0) {
    cout << "NO" << endl;
  } else {
    int l, r;
    for (int i = 1; i < n; ++i) {
      if (s[i] < s[i - 1]) {
        l = i - 1;
        r = i;
        break;
      }
    }
    cout << "YES" << endl;
    cout << l + 1 << " " << r + 1;
  }
}
