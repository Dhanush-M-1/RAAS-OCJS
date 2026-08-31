#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.1415926535897932384626433832795l;
template <typename T>
inline auto sqr(T x) -> decltype(x * x) {
  return x * x;
}
template <typename T1, typename T2>
inline bool umx(T1& a, T2 b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T1, typename T2>
inline bool umn(T1& a, T2 b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
struct Input {
  int n, m, k;
  int a, b;
  vector<pair<int, pair<int, int> > > q;
  bool read() {
    if (!(cin >> n >> k >> a >> b >> m)) {
      return false;
    }
    q.resize(m);
    for (int i = 0; i < m; ++i) {
      int t;
      cin >> t;
      if (t == 1) {
        int d, x;
        cin >> d >> x;
        --d;
        q.push_back(make_pair(0, make_pair(d, x)));
      } else {
        int x;
        cin >> x;
        --x;
        q.push_back(make_pair(1, make_pair(x, 0)));
      }
    }
    return true;
  }
  void init(const Input& input) { *this = input; }
};
struct Data : Input {
  vector<int> ans;
  void write() {
    for (int i = 0; i < ((int)(ans).size()); ++i) {
      cout << ans[i];
      cout << "\n";
    }
  }
  virtual void solve() {}
  virtual void clear() { *this = Data(); }
};
struct FenTree {
  vector<int> a;
  FenTree(int n) : a(n) {}
  void add(int x, int d) {
    while (x < ((int)(a).size())) {
      a[x] += d;
      x |= x + 1;
    }
  }
  int sum(int x, int y) {
    if (x > y) {
      return 0;
    }
    return sum(y) - (x ? sum(x - 1) : 0);
  }
  int sum(int x) {
    int res = 0;
    while (x >= 0) {
      res += a[x];
      x &= x + 1;
      --x;
    }
    return res;
  }
};
struct Solution : Data {
  vector<int> d;
  void solve() {
    FenTree as(n + 1), bs(n + 1);
    vector<int> c(n);
    for (int i = 0; i < ((int)(q).size()); ++i) {
      if (q[i].first == 0) {
        int x = q[i].second.first, d = q[i].second.second;
        int da = min(a, c[x] + d) - c[x];
        int db = min(b, c[x] + d) - c[x];
        if (da > 0) {
          as.add(x, da);
        }
        if (db > 0) {
          bs.add(x + 1, db);
        }
        c[x] += d;
      } else {
        int x = q[i].second.first;
        ans.push_back(bs.sum(x) + as.sum(x + k, n - 1));
      }
    }
  }
  void clear() { *this = Solution(); }
};
Solution sol;
int main() {
  cout.setf(ios::showpoint | ios::fixed);
  cout.precision(20);
  sol.read();
  sol.solve();
  sol.write();
  return 0;
}
