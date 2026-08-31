#include <bits/stdc++.h>
using namespace std;
int a[520], b[520], c[520];
int main() {
  int n, i, j;
  cin >> n;
  int x, d = 0, g = 0;
  x = 2 * n;
  for (i = 0; i < x; i++) {
    cin >> a[i];
    if (i % 2 == 0) {
      b[g] = a[i];
      g++;
    } else {
      c[d] = a[i];
      d++;
    }
  }
  int count = 0;
  for (i = 0; i < g; i++) {
    for (j = 0; j < d; j++) {
      if (b[i] == c[j]) count++;
    }
  }
  cout << count << endl;
  return 0;
}
