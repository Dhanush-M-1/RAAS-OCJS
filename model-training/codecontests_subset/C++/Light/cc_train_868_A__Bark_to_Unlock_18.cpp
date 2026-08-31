#include <bits/stdc++.h>
using namespace std;
int main() {
  int c = 0, s = 0, ss = 0;
  string q;
  cin >> q;
  cin >> c;
  vector<string> a(c);
  for (int i = 0; i < c; i++) {
    cin >> a[i];
    if (a[i] == q) {
      cout << "YES";
      return 0;
    }
  }
  for (int i = 0; i < c; i++) {
    if (q[0] == a[i][1]) s++;
    if (q[1] == a[i][0]) ss++;
  }
  if ((s > 0) && (ss > 0)) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
  return 0;
}
