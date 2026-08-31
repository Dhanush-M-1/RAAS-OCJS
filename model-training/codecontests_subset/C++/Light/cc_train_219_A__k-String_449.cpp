#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string a;
  int f[140] = {};
  cin >> a;
  bool b = true;
  for (int i = 0; i < a.size(); i++) {
    int x = a[i];
    f[x]++;
  }
  for (int i = 97; i < 124; i++) {
    if (f[i] != 0 && f[i] % n != 0) {
      b = false;
    } else if (f[i] != 0) {
      f[i] /= n;
    }
  }
  if (b) {
    for (int i = 0; i < n; i++) {
      for (int i = 97; i < 124; i++) {
        if (f[i] != 0) {
          char c = i;
          for (int j = f[i]; j > 0; j--) {
            cout << c;
          }
        }
      }
    }
  } else
    cout << -1;
  return 0;
}
