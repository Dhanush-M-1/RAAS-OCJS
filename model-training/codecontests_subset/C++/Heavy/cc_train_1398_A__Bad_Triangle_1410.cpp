#include <bits/stdc++.h>
#pragma GCC optimize("O2")
#pragma GCC optimize("tree-vectorize")
#pragma GCC target("sse4")
using namespace std;
using lint = long long;
using pii = pair<int, int>;
using pll = pair<lint, lint>;
template <typename T>
using vc = vector<T>;
template <typename T>
using vvc = vector<vector<T>>;
template <typename T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <typename T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
constexpr lint ten(int n) { return n == 0 ? 1 : ten(n - 1) * 10; }
class ABadTriangle {
 public:
  void solve(std::istream& in, std::ostream& out) {
    ios_base::sync_with_stdio(false);
    in.tie(nullptr), out.tie(nullptr);
    int tt;
    in >> tt;
    while (tt--) {
      int N;
      in >> N;
      vc<int> A(N);
      for (int i = (0); i < (N); ++i) in >> A[i];
      if (A[0] + A[1] > A[N - 1])
        out << "-1\n";
      else
        out << 1 << ' ' << 2 << ' ' << N << '\n';
    }
  }
};
int main() {
  ABadTriangle solver;
  std::istream& in(std::cin);
  std::ostream& out(std::cout);
  solver.solve(in, out);
  return 0;
}
