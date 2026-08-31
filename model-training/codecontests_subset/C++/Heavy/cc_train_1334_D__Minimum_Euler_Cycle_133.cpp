#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  void solve() {
    long long n, l, r;
    cin >> n >> l >> r;
    long long rngIdx = 0;
    long long begin = 0, end = n;
    while (begin < end) {
      long long mid = begin + (end - begin) / 2;
      if (2 * n * mid - mid * (mid + 1) >= l) {
        end = mid;
      } else {
        begin = mid + 1;
      }
    }
    rngIdx = end - 1;
    long long totalRng = 2 * n * rngIdx - rngIdx * (rngIdx + 1);
    for (long long i = l; i <= r; i++) {
      if (2 * n * (rngIdx + 1) - (rngIdx + 1) * (rngIdx + 2) < i) {
        rngIdx++;
        totalRng = 2 * n * rngIdx - rngIdx * (rngIdx + 1);
      }
      if (i == n * (n - 1) + 1) {
        cout << 1 << " ";
      } else if (i % 2 == 1) {
        cout << rngIdx + 1 << " ";
      } else {
        cout << (i - totalRng) / 2 + rngIdx + 1 << " ";
      }
    }
    cout << endl;
  }
};
int main(int argc, const char* argv[]) {
  int t;
  Solution sol;
  cin >> t;
  while (t--) {
    sol.solve();
  }
  return 0;
}
