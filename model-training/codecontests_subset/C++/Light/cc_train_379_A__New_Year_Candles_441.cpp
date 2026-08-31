#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long a, b;
  cin >> a >> b;
  long long p, q;
  long long count = a;
  while (a >= b) {
    p = a / b;
    count += p;
    q = a % b;
    a = q + p;
  }
  cout << count << endl;
  return 0;
}
