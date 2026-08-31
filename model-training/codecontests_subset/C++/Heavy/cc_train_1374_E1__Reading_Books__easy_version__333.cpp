#include <bits/stdc++.h>
using namespace std;
const long long MOD = (long long)1e9 + 7;
const double PI = acos(-1.0);
void __print(long long x) { cerr << x; }
void __print(int32_t x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  long long f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
int32_t main() {
  long long n, k;
  cin >> n >> k;
  multiset<long long> a, b, c;
  for (long long i = 0; i < n; i++) {
    long long t, p, q;
    cin >> t >> p >> q;
    if (p && q) {
      c.insert(t);
    } else if (p) {
      a.insert(t);
    } else if (q) {
      b.insert(t);
    }
  }
  if ((long long)a.size() + (long long)c.size() < k ||
      (long long)b.size() + (long long)c.size() < k) {
    cout << -1 << '\n';
    return 0;
  }
  long long cnt1 = a.size(), cnt2 = b.size();
  long long ans = 0;
  for (auto x : a) ans += x;
  for (auto x : b) ans += x;
  multiset<long long> aa, bb;
  while (cnt1 < k || cnt2 < k) {
    long long cur = *c.begin();
    aa.insert(cur);
    bb.insert(cur);
    ans += cur;
    cnt1++;
    cnt2++;
    c.erase(c.begin());
  }
  while (cnt1 > k && a.size()) {
    ans -= *a.rbegin();
    a.erase(--a.end());
    cnt1--;
  }
  while (cnt2 > k && b.size()) {
    ans -= *b.rbegin();
    b.erase(--b.end());
    cnt2--;
  }
  while (c.size() && (a.size() || b.size())) {
    if (a.size() && b.size()) {
      if (*c.begin() < *a.rbegin() + *b.rbegin()) {
        ans -= *a.rbegin();
        ans -= *b.rbegin();
        ans += *c.begin();
        a.erase(--a.end());
        b.erase(--b.end());
        c.erase(c.begin());
      } else {
        break;
      }
    } else if (a.size()) {
      if (*c.begin() < *a.rbegin()) {
        ans -= *a.rbegin();
        ans += *c.begin();
        a.erase(--a.end());
        c.erase(c.begin());
      } else {
        break;
      }
    } else {
      if (*c.begin() < *b.rbegin()) {
        ans -= *b.rbegin();
        ans += *c.begin();
        b.erase(--b.end());
        c.erase(c.begin());
      } else {
        break;
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
