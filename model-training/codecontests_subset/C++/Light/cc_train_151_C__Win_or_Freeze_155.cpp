#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q;
  cin >> q;
  if (q == 1) {
    cout << "1\n0\n";
    return 0;
  }
  long long a = -1, b = -1;
  for (long long d = 2; d * d <= q; d++) {
    if (q % d) continue;
    a = d;
    b = q / d;
    break;
  }
  if (a == -1) {
    cout << "1\n0\n";
    return 0;
  }
  for (long long d = 2; d * d <= b; d++) {
    if (b % d) continue;
    cout << "1\n" << a * d << '\n';
    return 0;
  }
  cout << "2\n";
}
