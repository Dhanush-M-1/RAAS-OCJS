#include <bits/stdc++.h>
using namespace std;
int solve(int l, int r, int d) {
  if (d >= l) {
    return (r / d + 1) * d;
  } else {
    return d;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int l, r, d;
    cin >> l >> r >> d;
    cout << solve(l, r, d) << endl;
  }
}
