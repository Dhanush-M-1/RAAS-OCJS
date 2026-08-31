#include <bits/stdc++.h>
using namespace std;
int k, n, x, a[1111], trace[1111], dem[1111], b[1111];
int main() {
  cin >> n >> x;
  for (int i = 1; i <= n; i++) {
    dem[i] = 1;
    trace[i] = i;
  }
  k = 0;
  int z;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i] > 0) {
      trace[i] = a[i];
      z = i;
      while (trace[z] != z) z = trace[z];
      dem[z] += dem[i];
      dem[i] = 0;
    }
  }
  for (int j = 1; j <= n; j++) {
    z = j;
    if (z == x) {
      ++k;
      continue;
    }
    while (trace[z] != z) {
      z = trace[z];
      if (z == x) {
        ++k;
        break;
      }
    }
  }
  int t;
  t = x;
  while (trace[t] != t) t = trace[t];
  k = dem[t] - k + 1;
  dem[t] = 0;
  b[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (dem[i] > 0) {
      for (int j = 0; j <= n; j++) {
        if (b[j] == 1 && b[j + dem[i]] == 0) b[j + dem[i]] = 2;
      }
      for (int j = 0; j <= n; j++) {
        if (b[j] == 2) b[j] = 1;
      }
    }
  }
  for (int i = 0; i <= n; i++) {
    if (b[i] == 1) cout << i + k << endl;
  }
  return 0;
}
