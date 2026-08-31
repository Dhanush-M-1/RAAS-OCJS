#include <bits/stdc++.h>
using namespace std;
int t;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> t;
  while (t--) {
    int n, fir, sec, last;
    cin >> n;
    for (int i = 1; i <= n; i++) {
      int x;
      cin >> x;
      if (i == 1) fir = x;
      if (i == 2) sec = x;
      if (i == n) last = x;
    }
    if (last >= fir + sec)
      cout << 1 << ' ' << 2 << ' ' << n << "\n";
    else
      cout << "-1\n";
  }
}
