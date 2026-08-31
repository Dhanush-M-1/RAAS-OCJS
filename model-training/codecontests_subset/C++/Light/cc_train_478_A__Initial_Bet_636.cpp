#include <bits/stdc++.h>
using namespace std;
int a, b, c, d, e, cem;
int main() {
  cin >> a >> b >> c >> d >> e;
  cem = a + b + c + d + e;
  if (cem % 5 != 0 || cem == 0) {
    cout << "-1" << endl;
  } else {
    cout << (cem / 5) << endl;
  }
  return 0;
}
