#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  string arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  bool ok = false;
  for (int i = 0; i < n; i++) {
    if (s == arr[i]) {
      ok = true;
    }
  }
  bool f = false, b = false;
  for (int i = 0; i < n; i++) {
    if (arr[i][1] == s[0]) f = true;
    if (arr[i][0] == s[1]) b = true;
  }
  if (ok || (f & b)) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
