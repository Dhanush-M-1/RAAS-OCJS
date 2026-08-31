#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
const long long N = 1e5 + 5;
std::vector<long long> cnt(N, 0);
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  for (long long i = 1; i < n + 1; ++i) {
    cnt[i] = 2 * (n - i);
  }
  for (long long i = 2; i < n + 1; ++i) {
    cnt[i] += cnt[i - 1];
  }
  long long p = 0;
  for (long long i = l; i <= r; ++i) {
    while (p + 1 <= n and cnt[p + 1] < i) {
      p++;
    }
    long long temp = i - cnt[p];
    if (i == ((n * (n - 1)) + 1)) {
      cout << 1 << " ";
    } else if (i % 2) {
      cout << p + 1 << " ";
      continue;
    } else {
      cout << p + 1 + (temp / 2) << " ";
    }
  }
  cout << '\n';
}
