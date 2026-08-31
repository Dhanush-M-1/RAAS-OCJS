#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
template <typename A>
ostream &operator<<(ostream &cout, vector<A> const &v);
template <typename A, typename B>
ostream &operator<<(ostream &cout, pair<A, B> const &p) {
  return cout << "(" << p.first << ", " << p.second << ")";
}
template <typename A>
ostream &operator<<(ostream &cout, vector<A> const &v) {
  cout << "[";
  for (int i = 0; i < v.size(); i++) {
    if (i) cout << ", ";
    cout << v[i];
  }
  return cout << "]";
}
template <typename A, typename B>
istream &operator>>(istream &cin, pair<A, B> &p) {
  cin >> p.first;
  return cin >> p.second;
}
mt19937 rng(steady_clock::now().time_since_epoch().count());
void usaco(string filename) {
  freopen((filename + ".in").c_str(), "r", stdin);
  freopen((filename + ".out").c_str(), "w", stdout);
}
const long double pi = 3.14159265358979323846;
const long long mod = 1000000007;
long long n, m, k, q, Q, T, l, r, x, y, z;
long long c[1000005];
string second, t;
long long ans = 0;
int pt, a, b;
int query(int a, int b) {
  cout << "? " << a << " " << b << endl;
  cin >> x;
  return x;
}
void getZero() {
  if (pt < 0) {
    cout << "! " << a << " " << b << endl;
    exit(0);
  }
  b ^= (1 << pt);
  x = query(a, b);
  if (x == 1)
    a ^= (1 << pt);
  else
    b ^= (1 << pt);
  --pt;
  getZero();
}
int main() {
  {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  };
  pt = 29;
  a = b = 0;
  int cache = -2;
  while (pt >= 0) {
    int x, y;
    if (cache == -2) {
      x = query(a, b);
    } else
      x = cache;
    if (x == 0) getZero();
    a ^= (1 << pt);
    b ^= (1 << pt);
    y = query(a, b);
    if (x == y)
      cache = x;
    else
      cache = -2;
    if (x == y) {
      a ^= (1 << pt);
      z = query(a, b);
      if (z == 1)
        a ^= (1 << pt);
      else
        b ^= (1 << pt);
    } else {
      if (x > y)
        b ^= (1 << pt);
      else
        a ^= (1 << pt);
    }
    --pt;
  }
  cout << "! " << a << " " << b << endl;
}
