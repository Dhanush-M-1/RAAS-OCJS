#include <bits/stdc++.h>
using namespace std;
constexpr int inf32 = 0x3f3f3f3f;
constexpr long long inf64 = 0x3f3f3f3f3f3f3f3f;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int n, m;
  cin >> n >> m;
  int mn = 0, mx = 0, ns = 0;
  for (int i = 0; i < (n); ++i) {
    int first;
    cin >> first;
    if (first != 0) {
      mn += first, mx = min(m, mx + first);
      if (mn > m) return !(cout << "-1\n");
    } else {
      if (mx < 0)
        ++ns, mx = m, mn = 0;
      else
        mn = max(mn, 0);
    }
  }
  cout << ns << '\n';
  return 0;
}
