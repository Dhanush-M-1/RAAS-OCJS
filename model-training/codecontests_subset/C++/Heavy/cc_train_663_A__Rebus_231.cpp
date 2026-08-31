#include <bits/stdc++.h>
using namespace std;
int main() {
  int np = 1;
  int nm = 0;
  int cnt = 0;
  int a[110];
  a[0] = 1;
  while (1) {
    string s;
    cin >> s;
    if (s == "=") break;
    if (s == "+") {
      np++;
      a[++cnt] = 1;
    }
    if (s == "-") {
      nm++;
      a[++cnt] = -1;
    }
  }
  int n;
  cin >> n;
  if ((np * n - nm < n) || (np - nm * n > n)) {
    cout << "Impossible" << endl;
    return 0;
  }
  int sum = n + nm - np;
  cout << "Possible" << endl;
  for (int i = 0; i <= cnt; i++) {
    if ((i > 0) && (a[i] > 0)) cout << " + ";
    if (a[i] < 0) cout << " - ";
    if (sum < 0) {
      if (a[i] < 0) {
        if (sum < -(n - 1)) {
          sum += (n - 1);
          cout << n;
        } else {
          cout << (-sum + 1);
          sum = 0;
        }
      } else
        cout << "1";
    } else {
      if (a[i] > 0) {
        if (sum > (n - 1)) {
          sum -= (n - 1);
          cout << n;
        } else {
          cout << (sum + 1);
          sum = 0;
        }
      } else
        cout << "1";
    }
  }
  cout << " = " << n << endl;
  return 0;
}
