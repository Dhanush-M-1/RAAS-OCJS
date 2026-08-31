#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class T, class U>
ostream& operator<<(ostream& o, const pair<T, U>& p) {
  o << "(" << p.first << "," << p.second << ")";
  return o;
}
template <class T>
ostream& operator<<(ostream& o, const vector<T>& v) {
  o << "[";
  for (T t : v) {
    o << t << ",";
  }
  o << "]";
  return o;
}
const string ok = "YES", ng = "NO";
const ll INF = 100000000000000000LL;
inline ll mul(ll x, ll y) {
  if (x > INF / y) return -1;
  return x * y;
}
string solve() {
  int n;
  cin >> n;
  vector<ll> b(n), a(n);
  for (int(i) = 0; (i) < (int)(n); ++(i)) cin >> b[i];
  for (int(i) = 0; (i) < (int)(n); ++(i)) cin >> a[i];
  vector<int> x(n - 1), k(n - 1);
  for (int(i) = 0; (i) < (int)(n - 1); ++(i)) {
    cin >> x[i] >> k[i];
    --x[i];
  }
  for (int i = n - 1; i > 0; --i) {
    if (b[i] >= a[i]) {
      b[x[i - 1]] += b[i] - a[i];
      b[i] = a[i];
    } else {
      ll need = mul(a[i] - b[i], k[i - 1]);
      if (need == -1) return ng;
      b[x[i - 1]] -= need;
      if (b[x[i - 1]] < -INF) return ng;
      b[i] = a[i];
    }
  }
  for (int(i) = 0; (i) < (int)(n); ++(i))
    if (b[i] < a[i]) return ng;
  return ok;
}
int main() {
  cout << solve() << endl;
  return 0;
}
