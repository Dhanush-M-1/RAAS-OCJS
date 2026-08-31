#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  for (T e : v) {
    os << e << ' ';
  }
  return os;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int q;
  cin >> q;
  while (q--) {
    ll l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << '\n';
    } else {
      ll candidate = (r / d) * d;
      candidate += d;
      cout << candidate << '\n';
    }
  }
  return 0;
}
