#include <bits/stdc++.h>
using namespace std;
const int OO = 1e9;
const double EPS = 1e-9;
template <class T>
void _db(const char* dbStr, T e) {
  cout << dbStr << " = " << e << endl;
}
template <class T, class... L>
void _db(const char* dbStr, T e, L... r) {
  while (*dbStr != ',') cout << *dbStr++;
  cout << " = " << e << ',';
  _db(dbStr + 1, r...);
}
template <class S, class T>
ostream& operator<<(ostream& o, const map<S, T>& v) {
  o << "[";
  int i = 0;
  for (const pair<S, T>& pr : v)
    o << (!i++ ? "" : ", ") << "{" << pr.first << " : " << pr.second << "}";
  return o << "]";
}
template <template <class, class...> class S, class T, class... L>
ostream& operator<<(ostream& o, const S<T, L...>& v) {
  o << "[";
  int i = 0;
  for (const auto& e : v) o << (!i++ ? "" : ", ") << e;
  return o << "]";
}
template <class S, class T>
ostream& operator<<(ostream& o, const pair<S, T>& pr) {
  return o << "(" << pr.first << ", " << pr.second << ")";
}
ostream& operator<<(ostream& o, const string& s) {
  for (const char& c : s) o << c;
  return o;
}
template <class T>
using V = vector<T>;
template <class T>
using VV = V<V<T>>;
template <class T>
using VVV = VV<V<T>>;
using ll = long long;
using pii = pair<int, int>;
using vi = V<int>;
using vii = V<pii>;
using vvi = VV<int>;
using mii = map<int, int>;
using umii = unordered_map<int, int>;
using si = set<int>;
using usi = unordered_set<int>;
int n, r, c;
V<string> s;
vi sum;
vvi adj;
vi path;
pii ans = make_pair(0, 0);
bool good(int i, int j) { return sum[j] - sum[i - 1] + (j - i) > c; }
void dfs(int u, int p) {
  path.push_back(u);
  int l = path[max(int(path.size()) - 1 - r, 0)] - u;
  true;
  if (l > ans.first) ans = make_pair(l, u);
  for (auto& v : adj[u]) {
    if (v != p) dfs(v, u);
  }
  path.pop_back();
}
int main() {
  ios::sync_with_stdio(false);
  cout.precision(10);
  cin.tie(0);
  cin >> n >> r >> c;
  s.assign(n + 2, "");
  sum.assign(n + 2, 0);
  adj.assign(n + 2, vi());
  for (int i = 1; i <= n; ++i) {
    cin >> s[i];
    sum[i] = sum[i - 1] + int(s[i].size());
  }
  sum.back() = OO;
  vi next(n + 2, n + 1);
  for (int i = 1; i <= n; ++i) {
    int lo = i, hi = n + 1;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (good(i, mid))
        hi = mid;
      else
        lo = mid + 1;
    }
    true;
    next[i] = lo;
    adj[next[i]].push_back(i);
  }
  true;
  for (int i = 1; i <= n + 1; ++i) {
    if (next[i] == i) dfs(i, i);
  }
  true;
  if (!ans.first)
    cout << '\n';
  else {
    for (int l = ans.second, r = ans.second + ans.first, Sz = int(s[l].size());
         l < r; ++l) {
      cout << s[l];
      if (l + 1 == r || (l + 1 < r && Sz + 1 + int(s[l + 1].size()) > c)) {
        cout << '\n';
        Sz = int(s[l + 1].size());
      } else {
        cout << ' ';
        Sz += 1 + int(s[l + 1].size());
      }
    }
  }
  return 0;
}
