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
const long double PI = acos(-1.0);
long long int power(long long int x, long long int y) {
  long long int res = 1;
  x = x;
  while (y > 0) {
    if (y & 1) res = (res * x);
    y = y >> 1;
    x = (x * x);
  }
  return res;
}
long long int power(long long int x, long long int y, long long int p) {
  long long int res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long int gcd(long long int a, long long int b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
bool isPalindrome(string s) {
  string t = s;
  reverse(t.begin(), t.end());
  return s == t;
}
void solve() {
  long long int n;
  cin >> n;
  long long int arr[n];
  map<long long int, set<long long int> > mm;
  vector<long long int> v;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    mm[arr[i]].insert(i);
    v.push_back(arr[i]);
  }
  sort(v.begin(), v.end());
  ;
  long long int q;
  cin >> q;
  while (q--) {
    long long int x, y;
    cin >> x >> y;
    vector<pair<long long int, long long int> > vec;
    map<long long int, long long int> temp;
    long long int i = n - 1;
    while (vec.size() != x) {
      long long int key = v[i];
      ;
      vec.push_back(make_pair(*mm[key].begin(), key));
      mm[key].erase(*mm[key].begin());
      i--;
    }
    sort(vec.begin(), vec.end());
    ;
    for (auto it : vec) mm[it.second].insert(it.first);
    cout << vec[y - 1].second << endl;
  }
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
