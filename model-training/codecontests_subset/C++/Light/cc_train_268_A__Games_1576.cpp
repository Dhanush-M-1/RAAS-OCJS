#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, rez = 0, i, j, t;
  cin >> n;
  int a[n], b[n];
  for (i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (i = 0; i < n; ++i) {
    t = a[i];
    for (j = 0; j < n; ++j) {
      if (t == b[j]) ++rez;
    }
  }
  cout << rez << endl;
  return 0;
}
