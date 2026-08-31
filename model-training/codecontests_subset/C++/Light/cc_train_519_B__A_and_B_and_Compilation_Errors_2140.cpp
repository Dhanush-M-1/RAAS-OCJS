#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  cin >> a;
  int b[a + 1], c[a + 1], d[a + 1];
  for (int i = 0; i < a; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < a - 1; i++) {
    cin >> c[i];
  }
  for (int i = 0; i < a - 2; i++) {
    cin >> d[i];
  }
  sort(b, b + a);
  sort(c, c + a - 1);
  c[a] = -1;
  d[a - 1] = -1;
  sort(d, d + a - 2);
  for (int i = 0; i < a; i++) {
    if (b[i] != c[i]) {
      cout << b[i] << endl;
      break;
    }
  }
  for (int i = 0; i < a - 1; i++) {
    if (c[i] != d[i]) {
      cout << c[i] << endl;
      return 0;
    }
  }
}
