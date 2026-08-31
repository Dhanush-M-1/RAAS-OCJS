#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, p, k;
  cin >> a >> b >> c;
  p = a * c;
  k = p / b;
  if (p % b > 0) ++k;
  cout << k - c;
}
