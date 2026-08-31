#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, i, e = -1, f = -1;
  cin >> a;
  long long int b[a], c[a - 1], d[a - 2];
  for (i = 0; i < a; i++) {
    cin >> b[i];
  }
  sort(b, b + a);
  for (i = 0; i < a - 1; i++) {
    cin >> c[i];
  }
  sort(c, c + a - 1);
  for (i = 0; i < a - 2; i++) {
    cin >> d[i];
  }
  sort(d, d + a - 2);
  for (i = 0; i < a - 1; i++) {
    if (b[i] != c[i]) {
      e = i;
      break;
    }
  }
  if (e >= 0)
    cout << b[e] << endl;
  else
    cout << b[a - 1] << endl;
  for (i = 0; i < a - 2; i++) {
    if (c[i] != d[i]) {
      f = i;
      break;
    }
  }
  if (f >= 0)
    cout << c[f] << endl;
  else
    cout << c[a - 2] << endl;
}
