#include <bits/stdc++.h>
using namespace std;
int solve(int l, int r, int d) {
  if (d < l || d > r) return d;
  return d * (r / d + 1);
}
int main() {
  int n, l, r, d;
  cin >> n;
  while (n--) {
    cin >> l >> r >> d;
    cout << solve(l, r, d) << endl;
  }
  return 0;
}
