#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long p[n], q[n - 1], r[n - 2], a = 0, b = 0, c = 0;
  for (long long i = 0; i < n; i++) {
    cin >> p[i];
    a += p[i];
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> q[i];
    b += q[i];
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> r[i];
    c += r[i];
  }
  cout << a - b << endl;
  cout << b - c << endl;
}
