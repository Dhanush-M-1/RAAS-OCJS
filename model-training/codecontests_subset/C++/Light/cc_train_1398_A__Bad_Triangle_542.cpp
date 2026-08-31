#include <bits/stdc++.h>
using namespace std;
long long max3(long long a, long long b, long long c) {
  return max(a, max(b, c));
}
long long min3(long long a, long long b, long long c) {
  return min(a, min(b, c));
}
int main() {
  {
    int q;
    cin >> q;
    while (q--) {
      int n;
      cin >> n;
      vector<int> a(n);
      for (int i = 0; i < n; i++) {
        cin >> a[i];
      }
      bool done = false;
      if (a[0] + a[1] <= a[n - 1]) {
        cout << 1 << " " << 2 << " " << n << endl;
      } else {
        cout << -1 << endl;
      }
    }
  }
  return 0;
}
