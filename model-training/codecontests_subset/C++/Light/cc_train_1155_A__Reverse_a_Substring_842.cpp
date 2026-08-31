#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, ans1, ans2;
  cin >> n;
  string s, t;
  cin >> s;
  t = s;
  sort(t.begin(), t.end());
  if (t == s) {
    cout << "NO";
    return 0;
  }
  char c;
  for (i = 0; i < n; i++) {
    if (s[i] != t[i]) {
      c = t[i];
      ans1 = i + 1;
      break;
    }
  }
  for (j = i; j < n; j++) {
    if (s[j] == c) {
      ans2 = j + 1;
      break;
    }
  }
  cout << "YES" << endl << ans1 << " " << ans2;
  return 0;
}
