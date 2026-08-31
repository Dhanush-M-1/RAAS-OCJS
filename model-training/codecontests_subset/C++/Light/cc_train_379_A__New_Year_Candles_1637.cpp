#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b;
  cin >> a >> b;
  long long t = a, k = 0;
  while (a >= b) {
    k = a % b;
    a = a / b;
    t += a;
    a += k;
  }
  cout << t;
  return 0;
}
