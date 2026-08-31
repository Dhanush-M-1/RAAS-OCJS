#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned long long s = 0;
  unsigned long long a, b, x;
  long n;
  cin >> n;
  x = 0;
  b = 0;
  for (long i = 0; i < n; i++) {
    cin >> a;
    s = s + a;
  }
  for (long i = 0; i < (n - 1); i++) {
    cin >> a;
    x = x + a;
  }
  for (long i = 0; i < (n - 2); i++) {
    cin >> a;
    b = b + a;
  }
  cout << s - x << endl << x - b;
  return 0;
}
