#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast,no-stack-protector")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
template <class T>
inline T bigMod(T p, T e, T M) {
  T ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % M;
    p = (p * p) % M;
  }
  return (T)ret;
}
template <class T>
inline T modInverse(T a, T M) {
  return bigMod(a, M - 2, M);
}
template <class T>
inline T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
inline T lcm(T a, T b) {
  a = abs(a);
  b = abs(b);
  return (a / gcd(a, b)) * b;
}
template <class T>
inline string int2String(T a) {
  ostringstream str;
  str << a;
  return str.str();
}
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  vector<vector<int> > v(4);
  int t, a, b;
  for (int i = int(0); i < int(n); i++) {
    scanf("%d%d%d", &t, &a, &b);
    v[(a << 1) | b].push_back(t);
  }
  if (v[1].size() + v[3].size() < k || v[2].size() + v[3].size() < k) {
    puts("-1");
    return 0;
  }
  for (int i = int(0); i < int(4); i++) sort(v[i].rbegin(), v[i].rend());
  long long ans = 0;
  for (int _ = int(0); _ < int(k); _++) {
    if (v[3].size() && v[1].size() && v[2].size()) {
      if (v[3].back() <= v[1].back() + v[2].back()) {
        ans += v[3].back();
        v[3].pop_back();
      } else {
        ans += v[1].back();
        v[1].pop_back();
        ans += v[2].back();
        v[2].pop_back();
      }
    } else if (v[3].size()) {
      ans += v[3].back();
      v[3].pop_back();
    } else {
      ans += v[1].back();
      v[1].pop_back();
      ans += v[2].back();
      v[2].pop_back();
    }
  }
  printf("%lld\n", ans);
  return 0;
}
