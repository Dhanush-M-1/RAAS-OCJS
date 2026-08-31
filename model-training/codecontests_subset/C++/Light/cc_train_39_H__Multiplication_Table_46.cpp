#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  for (int i = 1; i <= (k - 1); i++) {
    if (i != 1) cout << '\n';
    for (int j = 1; j <= (k - 1); j++)
      cout << 10 * ((i * j) / k) + (i * j) % k << ' ';
  }
  return 0;
}
