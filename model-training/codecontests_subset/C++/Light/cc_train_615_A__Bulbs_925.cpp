#include <bits/stdc++.h>
using namespace std;
int main() {
  int buttons, bulbs, x, found = 0;
  cin >> buttons >> bulbs;
  int a[bulbs], z[bulbs];
  bool f[1000] = {};
  for (int i = 0; i < buttons; i++) {
    cin >> a[0];
    x = a[0];
    for (int j = 0; j < a[0]; j++) {
      cin >> z[j];
      f[z[j]] = true;
    }
  }
  for (int i = 1; i <= bulbs; i++) {
    if (f[i] == true) {
      found++;
    }
  }
  if (found == bulbs)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
