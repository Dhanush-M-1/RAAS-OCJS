#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, a, p = 0, q = 0, r = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    p = p + a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    q = q + a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    r = r + a;
  }
  cout << p - q << "\n" << q - r;
}
