#include <bits/stdc++.h>
using namespace std;
int xuli(long long l, long long r, long long d) {
  if (l > d || r < d)
    return d;
  else
    return (r / d + 1) * d;
}
int main() {
  long long n;
  cin >> n;
  long long i, l, r, d;
  for (i = 1; i <= n; i++) {
    cin >> l >> r >> d;
    cout << xuli(l, r, d) << "\n";
  }
}
