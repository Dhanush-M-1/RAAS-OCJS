#include <bits/stdc++.h>
using namespace std;
template <typename T>
class fenwick {
 public:
  vector<T> fenw;
  int n;
  fenwick(int _n) : n(_n) { fenw.resize(n); }
  void modify(int x, T v) {
    while (x < n) {
      fenw[x] += v;
      x |= (x + 1);
    }
  }
  T get(int x) {
    T v{};
    while (x >= 0) {
      v += fenw[x];
      x = (x & (x + 1)) - 1;
    }
    return v;
  }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  fenwick<int> f1(n + 1);
  fenwick<int> f2(n + 1);
  for (int i = 0; i < q; ++i) {
    int type;
    cin >> type;
    if (type == 1) {
      int day, cnt;
      cin >> day >> cnt;
      int new_x = f1.get(day) - f1.get(day - 1);
      int new_y = f2.get(day) - f2.get(day - 1);
      f1.modify(day, min(a - new_x, cnt));
      f2.modify(day, min(b - new_y, cnt));
    } else {
      int from;
      cin >> from;
      int to = from + k - 1;
      int ans = f2.get(from - 1);
      ans += f1.get(n) - f1.get(to);
      cout << ans << '\n';
    }
  }
}
