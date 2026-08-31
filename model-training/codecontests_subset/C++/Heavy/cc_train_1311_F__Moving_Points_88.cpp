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
long long int power(long long int x, long long int y) {
  long long int ans = 1;
  x %= 1000000007;
  while (y) {
    if (y & 1) ans = (x * ans) % 1000000007;
    x = (x * x) % 1000000007;
    y >>= 1;
  }
  return ans;
}
const int dx[4] = {1, 0, -1, 0};
const int dy[4] = {0, 1, 0, -1};
struct FenwickTree {
  vector<long long int> bit;
  int n;
  FenwickTree(int n) {
    this->n = n;
    bit.assign(n, 0);
  }
  FenwickTree(vector<int> a) : FenwickTree(a.size()) {
    for (size_t i = 0; i < a.size(); i++) add(i, a[i]);
  }
  long long int sum(int r) {
    long long int ret = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) ret += bit[r];
    return ret;
  }
  long long int sum(int l, int r) { return sum(r) - sum(l - 1); }
  void add(int idx, int delta) {
    for (; idx < n; idx = idx | (idx + 1)) bit[idx] += delta;
  }
};
void solve() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int> > arr(n);
  vector<long long int> vel(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> arr[i].second;
    vel[i] = arr[i].second;
  }
  sort(arr.begin(), arr.end());
  sort(vel.begin(), vel.end());
  map<long long int, long long int> mp;
  for (int i = 0; i < n; i++) {
    long long int in =
        lower_bound(vel.begin(), vel.end(), vel[i]) - vel.begin();
    mp[vel[i]] = in;
  }
  long long int ans = 0;
  FenwickTree count(n + 10), dist(n + 10);
  for (int i = 0; i < n; i++) {
    long long int v = mp[arr[i].second];
    long long int cnt = count.sum(v);
    long long int sum = dist.sum(v);
    ans += (cnt * arr[i].first - sum);
    count.add(v, 1);
    dist.add(v, arr[i].first);
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
}
