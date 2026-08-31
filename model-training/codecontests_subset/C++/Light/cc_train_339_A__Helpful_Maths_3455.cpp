#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[1000];
  int i, j = 0, k, l, a[1000], m, n, t;
  cin >> s;
  l = strlen(s);
  for (i = 0; i < l; i++) {
    if ((i % 2) == 0) {
      a[j] = (int)s[i];
      j++;
    }
  }
  for (m = 1; m < j; m++) {
    for (n = 0; n < (j - m); n++) {
      if (a[n] > a[n + 1]) {
        t = a[n];
        a[n] = a[n + 1];
        a[n + 1] = t;
      }
    }
  }
  for (k = 0; k < j; k++) {
    if (k == (j - 1)) {
      cout << (char)a[k];
    } else {
      cout << (char)a[k] << '+';
    }
  }
  cout << "\n";
  return 0;
}
