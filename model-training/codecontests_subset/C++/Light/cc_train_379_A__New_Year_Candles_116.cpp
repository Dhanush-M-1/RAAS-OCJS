#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b;
  c = a;
  while (a >= b) {
    long long d = a / b;
    c += d;
    long long k = a % b;
    a = d + k;
  }
  cout << c;
  return 0;
}
