#include <bits/stdc++.h>
using namespace std;
const double pi = 3.14159265358979323846;
void fast() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
long long n, m;
int32_t main() {
  fast();
  long long T, t;
  cin >> T;
  for (t = 1; t <= T; t++) {
    long long n;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    long long A = a[0], B = a[1], C = a[n - 1];
    if (A + B <= C) {
      cout << "1 2 " << n << "\n";
    } else
      cout << -1 << "\n";
  }
}
