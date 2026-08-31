#include <bits/stdc++.h>
using namespace std;
string to_string(string s) { return '"' + s + '"'; }
string to_string(const char* s) { return to_string((string)s); }
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A>
string to_string(A v) {
  bool first = true;
  string res = "{";
  for (const auto& x : v) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(x);
  }
  res += "}";
  return res;
}
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
const long double eps = 1e-12;
const int N = 1e6 + 9;
int cnt, mx, a[N], b[N];
bool bloc[N];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) {
    cin >> b[i];
    bloc[b[i]] = 1;
  }
  for (int i = 1; i <= k; i++) {
    cin >> a[i];
  }
  vector<int> ss;
  for (int i = 0; i < n; i++) {
    if (bloc[i] == 1)
      cnt++;
    else {
      ss.push_back(-i);
      mx = max(mx, cnt);
      cnt = 0;
    }
  }
  sort(ss.begin(), ss.end());
  mx = max(mx, cnt);
  long long ans = 1e18;
  if (mx >= k || bloc[0]) return cout << "-1\n", 0;
  for (int i = mx + 1; i <= k; i++) {
    cnt = 0;
    for (int j = 0; j < n;) {
      if (bloc[j]) {
        j = -(*upper_bound(ss.begin(), ss.end(), -j));
      } else {
        j += i;
        cnt++;
      }
    }
    ans = min(ans, 1ll * cnt * a[i]);
  }
  cout << ans << endl;
  return 0;
}
