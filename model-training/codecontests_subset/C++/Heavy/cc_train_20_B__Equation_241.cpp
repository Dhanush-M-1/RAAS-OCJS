#include <bits/stdc++.h>
using namespace std;
using uint = uint32_t;
using ull = uint64_t;
using ld = long double;
using ll = int64_t;
template <typename T>
int cmp(const T &a, const T &b) {
  return ((a + 1e-9 < b) ? -1 : ((b + 1e-9 < a) ? 1 : 0));
}
class Task {
 private:
  ld A, B, C;
  void degree2() {
    ld sq = B * B - 4 * A * C;
    ld rt1, rt2;
    if (cmp(sq, ld(0)) < 0) {
      cout << 0 << '\n';
    } else if (cmp(sq, ld(0)) == 0) {
      cout << 1 << '\n';
      rt1 = -B / (2.0 * A);
      cout << fixed << setprecision(10) << rt1 << '\n';
    } else {
      cout << 2 << '\n';
      rt1 = ld(ld(-B) + sqrt(sq)) / ld(2 * A);
      rt2 = ld(ld(-B) - sqrt(sq)) / ld(2 * A);
      vector<ld> ans(2);
      ans[0] = rt1;
      ans[1] = rt2;
      sort(ans.begin(), ans.end());
      cout << fixed << setprecision(10) << ans[0] << '\n';
      cout << fixed << setprecision(10) << ans[1] << '\n';
    }
    return;
  }
  void degree1() {
    int sq = B * B - 4 * A * C;
    ld rt1, rt2;
    cout << 1 << '\n';
    cout << fixed << setprecision(10) << (-ld(C) / ld(B)) << '\n';
  }
  void solveOne(istream &in, ostream &out) {
    in >> A >> B >> C;
    int sq = B * B - 4 * A * C;
    ld rt1, rt2;
    if (A)
      degree2();
    else {
      if (B) {
        degree1();
      } else {
        if (C) {
          cout << (0) << '\n';
          return;
        } else {
          cout << (-1) << '\n';
          return;
        };
      }
    }
  }

 public:
  void solve(istream &in, ostream &out) {
    int t = 1;
    while (t--) solveOne(in, out);
  }
};
auto main() -> int {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  Task solver;
  istream &in(cin);
  ostream &out(cout);
  solver.solve(in, out);
  return 0;
}
