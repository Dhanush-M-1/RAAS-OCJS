#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  cout << ((a + b + c + d + e) % 5 == 0 && (a + b + c + d + e) != 0
               ? (a + b + c + d + e) / 5
               : -1);
}
