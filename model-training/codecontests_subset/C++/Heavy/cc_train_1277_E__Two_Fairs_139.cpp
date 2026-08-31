#include <bits/stdc++.h>
using namespace std;
const int N = 1000001;
const bool DEBUG = 1;
template <typename S, typename T>
ostream &operator<<(ostream &out, pair<S, T> const &p) {
  out << '(' << p.first << ", " << p.second << ')';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, set<T> const &v) {
  for (auto i = v.begin(); i != v.end(); i++) out << (*i) << ' ';
  return out;
}
template <typename T, typename V>
ostream &operator<<(ostream &out, map<T, V> const &v) {
  for (auto i = v.begin(); i != v.end(); i++)
    out << "\n" << (i->first) << ":" << (i->second);
  return out;
}
template <typename T, typename V>
ostream &operator<<(ostream &out, unordered_map<T, V> const &v) {
  for (auto i = v.begin(); i != v.end(); i++)
    out << "\n" << (i->first) << ":" << (i->second);
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, multiset<T> const &v) {
  for (auto i = v.begin(); i != v.end(); i++) out << (*i) << ' ';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, unordered_set<T> const &v) {
  for (auto i = v.begin(); i != v.end(); i++) out << (*i) << ' ';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, unordered_multiset<T> const &v) {
  for (auto i = v.begin(); i != v.end(); i++) out << (*i) << ' ';
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, vector<T> const &v) {
  long long l = v.size();
  for (long long i = 0; i < l - 1; i++) out << v[i] << ' ';
  if (l > 0) out << v[l - 1];
  return out;
}
template <typename T>
void trace(const char *name, T &&arg1) {
  cout << name << ":" << arg1 << "\n";
}
template <typename T, typename... Args>
void trace(const char *names, T &&arg1, Args &&...args) {
  const char *comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << ":" << arg1 << "|";
  trace(comma + 1, args...);
}
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long cnt = 0;
long long visit[N];
void dfs(long long x, map<long long, set<long long>> &g,
         map<long long, vector<long long>> &memo, long long t) {
  if (visit[x]) {
    return;
  }
  visit[x] = 1;
  if (x != t) {
    memo[x].push_back(t);
  }
  for (auto p : g[x]) {
    if (!visit[p]) {
      dfs(p, g, memo, t);
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long _t;
  cin >> _t;
  while (_t--) {
    long long n, m, a, b;
    cin >> n >> m >> a >> b;
    map<long long, set<long long>> g, g1;
    cnt = 0;
    for (long long i = 0; i <= n; i++) {
      visit[i] = 0;
    }
    for (long long i = 0; i < m; i++) {
      long long x, y;
      cin >> x >> y;
      g[x].insert(y);
      g[y].insert(x);
    }
    map<long long, vector<long long>> memo;
    visit[b] = 1;
    long long p = a;
    dfs(a, g, memo, p);
    for (long long i = 0; i <= n; i++) {
      visit[i] = 0;
    }
    visit[a] = 1;
    p = b;
    dfs(b, g, memo, p);
    long long cnt1 = 0, cnt2 = 0;
    for (auto p : memo) {
      if (p.second.size() == 1) {
        if (p.second[0] == a) {
          cnt1++;
        } else {
          cnt2++;
        }
      }
    }
    long long ans = cnt1 * cnt2;
    cout << ans << "\n";
  }
}
