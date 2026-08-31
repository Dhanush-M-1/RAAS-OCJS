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
  int f = 0;
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
int main() {
  int tc;
  cin >> tc;
  while (tc--) {
    vector<int> arr, ar, c;
    int n, m;
    cin >> n >> m;
    arr.resize(n);
    ar.resize(m);
    for (auto &i : arr) cin >> i;
    for (auto &i : ar) cin >> i;
    sort(arr.begin(), arr.end());
    vector<int> v(arr.size() + ar.size());
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i] == ar[j]) {
          c.push_back(arr[i]);
          break;
        }
      }
    }
    if (c.size() == 0)
      cout << "NO\n";
    else
      cout << "YES\n" << 1 << " " << c[0] << "\n";
  }
  return 0;
}
