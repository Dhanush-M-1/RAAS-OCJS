#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
long long n, m, a, b, c, k, temp, x, y;
const int MAXN = 1e5 + 11;
inline long long max(long long a, long long b) { return ((a > b) ? a : b); }
inline long long min(long long a, long long b) { return ((a > b) ? b : a); }
inline long long gcd(long long a, long long b) {
  if (b == 0) return a;
  a %= b;
  return gcd(b, a);
}
inline vector<long long> read(int n) {
  vector<long long> v(n);
  for (int i = 0; i < v.size(); i++) cin >> v[i];
  return v;
}
void solveforthiscase(const int& test) {
  cin >> n >> m;
  vector<long long> v = read(n);
  vector<long long> vv = read(m);
  set<int> s1, s2;
  for (int i = 0; i < n; i++) s1.insert(v[i]);
  for (int i = 0; i < m; i++) s2.insert(vv[i]);
  for (auto x : s1) {
    if (s2.count(x)) {
      cout << "YES\n";
      cout << 1 << ' ' << x << '\n';
      return;
    }
  }
  cout << "NO\n";
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  clock_t start, end;
  start = clock();
  int test = 1;
  cin >> test;
  for (int i = 1; i <= test; i++) solveforthiscase(i);
  end = clock();
  long double t_t = (long double)(end - start) / (long double)(CLOCKS_PER_SEC);
  cerr << (long double)t_t * 1000 << " ms ";
}
