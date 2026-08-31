#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a = 0, b = 0, c = 0, n, i, j, k, l, m;
  string p;
  cin >> p;
  l = p.size();
  for (i = 0; i < l; i++) {
    if (p[i] == '1') a = a + 1;
    if (p[i] == '2') b = b + 1;
    if (p[i] == '3') c = c + 1;
  }
  if (a + b == 0 && c > 0) {
    cout << 3;
    c--;
  }
  if (a == 0 && b > 0) {
    cout << 2;
    b--;
  }
  if (a > 0) {
    cout << 1;
    a = a - 1;
  }
  for (i = 1; i <= a; i++) {
    cout << "+1";
  }
  for (i = 1; i <= b; i++) {
    cout << "+2";
  }
  for (i = 1; i <= c; i++) {
    cout << "+3";
  }
}
