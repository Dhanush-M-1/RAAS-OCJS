#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, l, j, k, i;
  cin >> n >> x;
  long long a[x + 1];
  for (i = 1; i <= x; i++) {
    a[i] = 0;
  }
  for (i = 0; i < n; i++) {
    cin >> l;
    for (j = 0; j < l; j++) {
      cin >> k;
      a[k]++;
    }
  }
  int t = 1;
  for (i = 1; i <= x; i++) {
    if (a[i] == 0) {
      t = 0;
    }
  }
  if (t == 1) {
    cout << "YES";
  } else
    cout << "NO";
}
