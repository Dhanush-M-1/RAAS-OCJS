#include <bits/stdc++.h>
using namespace std;
char d[2001];
int l, k;
int a[201];
int b[201];
int main() {
  int i, j, xx, p;
  memset(a, 0, sizeof(int) * 201);
  memset(b, 0, sizeof(int) * 201);
  cin >> k;
  cin >> d;
  l = strlen(d);
  for (i = 0; i < l; i++) {
    xx = d[i] - 'a';
    a[xx]++;
  }
  for (i = 0; i <= 25; i++) {
    if (a[i] != 0) {
      if (a[i] % k != 0) {
        break;
      }
      b[i] = a[i] / k;
    }
  }
  if (i <= 25) {
    cout << "-1" << endl;
    return 0;
  }
  for (i = 1; i <= k; i++) {
    for (j = 0; j <= 25; j++) {
      for (p = 1; p <= b[j]; p++) {
        cout << (char)(j + 'a');
      }
    }
  }
  cout << endl;
  return 0;
}
