#include <bits/stdc++.h>
using namespace std;
template <class T>
using vec = vector<T>;
template <typename Iter>
ostream& _IterOutput_(ostream& o, Iter b, Iter e, const string ss = "",
                      const string se = "") {
  o << ss;
  for (auto it = b; it != e; it++) o << (it == b ? "" : ", ") << *it;
  return o << se;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& o, pair<T1, T2>& pair) {
  return o << "(" << pair.first << ", " << pair.second << ")";
}
template <typename T>
ostream& operator<<(ostream& o, const vector<T>& vec) {
  return _IterOutput_(o, begin(vec), end(vec), "[", "]");
}
template <typename T>
ostream& operator<<(ostream& o, const set<T>& st) {
  return _IterOutput_(o, begin(st), end(st), "{", "}");
}
template <typename T, size_t N>
ostream& operator<<(ostream& o, const array<T, N>& arr) {
  return _IterOutput_(o, begin(arr), end(arr), "|", "|");
}
inline long long lb(long long a) { return a & (-a); }
const long long MX = 333333;
struct BIT {
  long long v[MX];
  void add(long long a, long long vl) {
    a += 2;
    while (a < MX) {
      v[a] += vl;
      a += lb(a);
    }
  }
  long long qry(long long a) {
    a += 2;
    long long res = 0;
    while (a) {
      res += v[a];
      a -= lb(a);
    }
    return res;
  }
  long long qp(long long a) { return qry(a) - qry(a - 1); }
} bit1, bit2;
int32_t main() {
  long long N, K, A, B, Q;
  cin >> N >> K >> A >> B >> Q;
  for (long long _t125 = 0; _t125 < (Q); (_t125)++) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long a, b;
      cin >> a >> b;
      long long z1 = bit1.qp(a);
      long long d1 = min(z1 + b, B) - z1;
      bit1.add(a, d1);
      long long z2 = bit2.qp(a);
      long long d2 = min(z2 + b, A) - z2;
      bit2.add(a, d2);
    } else {
      long long q;
      cin >> q;
      ;
      cout << bit1.qry(q - 1) + bit2.qry(N + 1) - bit2.qry(q + K - 1) << endl;
    }
  }
  do {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
  } while (0);
  return 0;
}
