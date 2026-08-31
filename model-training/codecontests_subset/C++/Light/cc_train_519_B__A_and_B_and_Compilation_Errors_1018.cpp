#include <bits/stdc++.h>
using namespace std;
long long n, x, a, b, c;
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> x;
    a += x;
  }
  for (long long i = 1; i <= n - 1; i++) {
    cin >> x;
    b += x;
  }
  for (long long i = 1; i <= n - 2; i++) {
    cin >> x;
    c += x;
  }
  cout << a - b << " " << b - c;
  return 0;
}
