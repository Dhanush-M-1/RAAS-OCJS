#include <bits/stdc++.h>
using namespace std;
const int maxt = 1000 * 1000 + 10;
int a, b, c;
int main() {
  cin >> a >> b >> c;
  for (int i = 0; i < maxt; ++i) {
    if (c * a <= (i + c) * 1ll * b) {
      cout << i;
      return 0;
    }
  }
  return 0;
}
