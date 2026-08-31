#include <bits/stdc++.h>
using namespace std;
void yes() { cout << "YES" << endl; }
void no() { cout << "NO" << endl; }
void solve(int qq) {
  long long n;
  cin >> n;
  long long l, r;
  cin >> l >> r;
  long long cnt = 0;
  long long odd = 0;
  long long start = 0;
  if (l == n * (n - 1) + 1) {
    cout << 1 << endl;
    return;
  }
  for (long long i = 1; i < n; i++) {
    cnt += (n - i) * 2;
    if (l <= cnt) {
      odd = i;
      start = cnt - (n - i) * 2 + 1;
      break;
    }
  }
  long long even = odd + ((l - start) / 2 + 1);
  for (long long i = l; i <= r; i++) {
    if (i % 2 == 0) {
      cout << even << " ";
      even++;
      if (even > n) {
        odd++;
        even = odd + 1;
        if (odd == n) {
          odd = 1;
        }
      }
    } else {
      cout << odd << " ";
    }
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    solve(i);
  }
  return 0;
}
