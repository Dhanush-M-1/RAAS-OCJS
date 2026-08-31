#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string a;
  cin >> a;
  int ui = 0, uf = 0, ua = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == 'A') {
      ua++;
    } else if (a[i] == 'I') {
      ui++;
    }
  }
  if (ui >= 2) {
    cout << 0;
  } else if (ui == 1) {
    cout << 1;
  } else
    cout << ua;
}
