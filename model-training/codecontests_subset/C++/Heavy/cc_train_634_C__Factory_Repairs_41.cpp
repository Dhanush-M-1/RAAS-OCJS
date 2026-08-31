#include <bits/stdc++.h>
using namespace std;
template <typename G>
struct triple {
  G first, second, T;
};
struct BIT {
  vector<long long> items;
  BIT(int sz = 0) { items = vector<long long>(sz + 5); }
  void Update(int pos, long long value) {
    for (int i = pos; i < items.size(); i += (i & -i)) items[i] += value;
  }
  long long Query(int pos) {
    long long ans = 0;
    for (int i = pos; i > 0; i -= (i & -i)) ans += items[i];
    return ans;
  }
};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  BIT abi1(n), abi2(n);
  vector<int> v(n + 1);
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, h;
      cin >> d >> h;
      if (v[d] < b) abi1.Update(d, min(h, b - v[d]));
      if (v[d] < a) abi2.Update(n - d + 1, min(h, a - v[d]));
      v[d] += h;
    } else {
      int d;
      cin >> d;
      cout << abi1.Query(d - 1) + abi2.Query(max(0, n - d - k + 1)) << '\n';
    }
  }
  return 0;
}
