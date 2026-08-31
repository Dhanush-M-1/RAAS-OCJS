#include <bits/stdc++.h>
using std::cin;
using std::cout;
using std::string;
using std::vector;
int n;
int a[101];
int solve() {
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  int k = *std::max_element(a, a + n);
  while (true) {
    int sa = 0, sb = 0;
    for (int i = 0; i < n; ++i) {
      sa += a[i], sb += k - a[i];
    }
    if (sb > sa) {
      cout << k;
      return 0;
    }
    ++k;
  }
  return 0;
}
int main(int argc, char* argv[]) {
  ::std::ios::sync_with_stdio(false);
  ::std::cin.tie(0);
  ::std::cout.tie(0);
  int test_count = 1;
  while (test_count--) solve();
  return 0;
}
