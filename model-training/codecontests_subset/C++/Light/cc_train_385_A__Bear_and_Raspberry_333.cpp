#include <bits/stdc++.h>
using namespace std;
int a, b, c[101], d, k = 101, i;
int main() {
  cin >> a >> b;
  for (i = 0; i < a; i++) {
    cin >> c[i];
  }
  for (i = 0; i < a - 1; i++) {
    if (c[i] - c[i + 1] - b > d) d = c[i] - c[i + 1] - b;
  }
  if (d > 0)
    cout << d << endl;
  else
    cout << 0;
}
