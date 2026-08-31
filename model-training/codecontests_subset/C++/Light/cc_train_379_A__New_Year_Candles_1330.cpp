#include <bits/stdc++.h>
using namespace std;
long long a, b, d, k;
int main() {
  cin >> a >> b;
  while (a > 0) {
    k = k + a;
    d = d + a;
    a = d / b;
    d %= b;
  }
  cout << k << endl;
  return 0;
}
