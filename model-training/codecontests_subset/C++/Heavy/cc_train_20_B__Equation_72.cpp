#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char* x) { cerr << '\"' << x << '\"'; }
void __print(const string& x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V>& x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T& x) {
  int f = 0;
  cerr << '{';
  for (auto& i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
template <class A>
void read(vector<A>& v);
template <class A, size_t S>
void read(array<A, S>& a);
template <class T>
void read(T& x) {
  cin >> x;
}
void read(double& d) {
  string t;
  read(t);
  d = stod(t);
}
void read(long double& d) {
  string t;
  read(t);
  d = stold(t);
}
template <class H, class... T>
void read(H& h, T&... t) {
  read(h);
  read(t...);
}
template <class A>
void read(vector<A>& x) {
  for (auto& a : x) read(a);
}
template <class A, size_t S>
void read(array<A, S>& x) {
  for (auto& a : x) read(a);
}
const int MAXN = 2e5 + 5;
long long mod = 1e9 + 7;
vector<long long> gr[200005];
void solve() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long val = (b * b) - (4 * a * c);
  cout << setprecision(8);
  if (a == 0) {
    if ((b == 0)) {
      if (c == 0) {
        cout << -1 << "\n";
        return;
      }
      cout << 0 << "\n";
    } else {
      cout << 1 << "\n";
      long double ans = -(c * 1.0) / (b * 1.0);
      cout << ans << "\n";
    }
    return;
  }
  if (val < 0) {
    cout << 0 << "\n";
    return;
  } else {
    long double root1 = -b + sqrt(val);
    root1 /= 2.0 * a;
    long double root2 = -b - sqrt(val);
    root2 /= 2.0 * a;
    if (root1 == root2) {
      cout << 1 << "\n";
      cout << root1 << "\n";
    } else {
      cout << 2 << "\n";
      if (root1 < root2) {
        cout << root1 << "\n" << root2 << "\n";
      } else {
        cout << root2 << "\n" << root1 << "\n";
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long test;
  test = 1;
  while (test--) {
    solve();
  }
}
