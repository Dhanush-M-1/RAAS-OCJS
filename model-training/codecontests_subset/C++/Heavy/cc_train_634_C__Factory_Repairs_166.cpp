#include <bits/stdc++.h>
using namespace std;
template <class S, class T>
ostream& operator<<(ostream& o, const pair<S, T>& p) {
  return o << "(" << p.first << "," << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& o, const vector<T>& vc) {
  o << "{";
  for (const T& v : vc) o << v << ",";
  o << "}";
  return o;
}
using ll = long long;
template <class T>
using V = vector<T>;
template <class T>
using VV = vector<vector<T>>;
constexpr ll TEN(int n) { return (n == 0) ? 1 : 10 * TEN(n - 1); }
struct segtree {
  using D = long long;
  int N;
  vector<D> val;
  segtree() {}
  segtree(int n) {
    N = 1;
    while (N < n) N *= 2;
    val.assign(N * 2, 0);
  }
  segtree(const vector<D>& ds) {
    int n = ds.size();
    N = 1;
    while (N < n) N *= 2;
    val.assign(N * 2, 0);
    for (int i = 0; i < (int)(n); i++) val[i + N] = ds[i];
    for (int i = N - 1; i > 0; i--) val[i] = val[i * 2] + val[i * 2 + 1];
  }
  void assign(int k, D d) {
    k += N;
    val[k] = d;
    k /= 2;
    while (k) {
      val[k] = val[k * 2] + val[k * 2 + 1];
      k /= 2;
    }
  }
  D sum(int a, int b) {
    D res = 0;
    a += N, b += N;
    while (a < b) {
      if (a & 1) res += val[a++];
      if (b & 1) res += val[--b];
      a /= 2, b /= 2;
    }
    return res;
  }
};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  cout << fixed << setprecision(20);
  int N, K, A, B, Q;
  cin >> N >> K >> A >> B >> Q;
  segtree sega(N), segb(N);
  V<int> sm(N);
  for (int _ = 0; _ < (int)(Q); _++) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, n;
      cin >> d >> n;
      d--;
      sm[d] += n;
      sega.assign(d, min(sm[d], A));
      segb.assign(d, min(sm[d], B));
    } else {
      int p;
      cin >> p;
      p--;
      cout << segb.sum(0, p) + sega.sum(p + K, N) << '\n';
    }
  }
}
