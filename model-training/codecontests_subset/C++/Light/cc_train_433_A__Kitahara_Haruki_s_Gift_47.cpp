#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, hundred = 0, twohundred = 0, val;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; ++i) {
    cin >> val;
    if (val == 100) {
      ++hundred;
    } else {
      ++twohundred;
    }
  }
  if ((hundred & 1) == 0) {
    if ((twohundred & 1)) {
      if (hundred == 0) {
        cout << "NO" << endl;
      } else {
        cout << "YES" << endl;
      }
    } else {
      cout << "YES" << endl;
    }
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
