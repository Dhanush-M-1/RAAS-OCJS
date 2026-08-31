#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
template <class T>
bool ckmin(T& a, const T& b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const long double pii = 3.14159265359;
const int MOD = 1000000007;
const char nl = '\n';
const int MX = 200001;
int A, B;
class FenwickTree {
  vector<int> ft;

 public:
  FenwickTree(int n) { ft.assign(n + 1, 0); }
  long long rsq(int b) {
    long long sum = 0;
    while (b > 0) {
      sum += ft[b];
      b -= b & (-b);
    }
    return sum;
  }
  long long rsq(int a, int b) { return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); }
  void add(int k, long long v) {
    while (k < (int)ft.size()) {
      ft[k] += v;
      k += k & (-k);
    }
  }
};
void solve() {
  int N, K, Q;
  cin >> N >> K >> A >> B >> Q;
  FenwickTree fq(N + 2), fq1(N + 2);
  long long ans = 0;
  while (Q--) {
    int ch;
    cin >> ch;
    if (ch == 1) {
      int a, b;
      cin >> a >> b;
      if (fq.rsq(a, a) + b > A) {
        fq.add(a, A - fq.rsq(a, a));
      } else
        fq.add(a, b);
      if (fq1.rsq(a, a) + b > B) {
        fq1.add(a, B - fq1.rsq(a, a));
      } else
        fq1.add(a, b);
    } else {
      int nb;
      cin >> nb;
      cout << fq1.rsq(0, nb - 1) + fq.rsq(N) - fq.rsq(min(nb + K - 1, N)) << nl;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int Test_case = 1;
  while (Test_case-- != 0) {
    solve();
  }
  return 0;
}
