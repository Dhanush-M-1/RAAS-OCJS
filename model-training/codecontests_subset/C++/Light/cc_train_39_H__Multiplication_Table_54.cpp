#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[11][11], valore;
  string s[11][11], t;
  cin >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) a[i][j] = (i + 1) * (j + 1);
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      valore = a[i][j];
      t = "";
      while (valore > 0) {
        t += to_string(valore % n);
        valore /= n;
      }
      reverse(t.begin(), t.end());
      s[i][j] = t;
    }
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1; j++) cout << s[i][j] << " ";
    cout << endl;
  }
  return 0;
}
