#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization("unroll-loops")
using namespace std;
long long dx[] = {1, 0, -1, 0};
long long dy[] = {0, 1, 0, -1};
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
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
long long solve() {
  long long n, k;
  cin >> n >> k;
  vector<pair<long long, pair<long long, long long>>> v;
  long long alice = 0, bob = 0, ans = 0;
  multiset<long long> both, al, bo;
  for (long long i = 0; i < n; i++) {
    long long time, a, b;
    cin >> time >> a >> b;
    if (a && !b) al.insert(time);
    if (!a && b)
      bo.insert(time);
    else if (a && b)
      both.insert(time);
    v.push_back({time, {a, b}});
    if (a == 1) alice++;
    if (b == 1) bob++;
  }
  if (alice < k || bob < k) return -1;
  while (al.size() && bo.size() && both.size() && k) {
    long long ali = *al.begin();
    long long bobi = *bo.begin();
    long long bot = *both.begin();
    if (ali + bobi < bot) {
      al.erase(al.find(ali));
      bo.erase(bo.find(bobi));
      ans += ali + bobi;
    } else {
      both.erase(both.find(bot));
      ans += bot;
    }
    k--;
  }
  while (k && al.size() && bo.size()) {
    k--;
    long long ali = *al.begin();
    long long bobi = *bo.begin();
    al.erase(al.find(ali));
    bo.erase(bo.find(bobi));
    ans += ali + bobi;
  }
  while (k && both.size()) {
    k--;
    long long bot = *both.begin();
    both.erase(both.find(bot));
    ans += bot;
  }
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << solve();
  return 0;
}
