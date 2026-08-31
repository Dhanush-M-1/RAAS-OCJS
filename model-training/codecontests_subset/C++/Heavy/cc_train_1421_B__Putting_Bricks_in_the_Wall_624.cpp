#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    string a[n];
    for (long long i = 0; i < n; i++) cin >> a[i];
    long long c = 0;
    long long p1 = a[0][1] - '0', p2 = a[1][0] - '0';
    long long q1 = a[n - 1][n - 2] - '0', q2 = a[n - 2][n - 1] - '0';
    long long cnt1, cnt2;
    cnt1 = abs(0ll - p1) + abs(0ll - p2) + abs(1ll - q1) + abs(1ll - q2);
    cnt2 = abs(0ll - q1) + abs(0ll - q2) + abs(1ll - p1) + abs(1ll - p2);
    if (cnt1 <= 2) {
      cout << cnt1 << "\n";
      if (p1 != 0) cout << "1 2\n";
      if (p2 != 0) cout << "2 1\n";
      if (q1 != 1) cout << n << " " << n - 1 << "\n";
      if (q2 != 1) cout << n - 1 << " " << n << "\n";
    } else {
      cout << cnt2 << "\n";
      if (p1 != 1) cout << "1 2\n";
      if (p2 != 1) cout << "2 1\n";
      if (q1 != 0) cout << n << " " << n - 1 << "\n";
      if (q2 != 0) cout << n - 1 << " " << n << "\n";
    }
  }
}
