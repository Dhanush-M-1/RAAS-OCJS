#include <bits/stdc++.h>
using namespace std;
template <class T>
using vec = vector<T>;
template <typename Iter>
ostream &_IterOutput_(ostream &o, Iter b, Iter e, const string ss = "",
                      const string se = "") {
  o << ss;
  for (auto it = b; it != e; it++) o << (it == b ? "" : ", ") << *it;
  return o << se;
}
template <typename T1, typename T2>
ostream &operator<<(ostream &o, const pair<T1, T2> &pair) {
  return o << "(" << pair.first << ", " << pair.second << ")";
}
template <typename T>
ostream &operator<<(ostream &o, const vector<T> &vec) {
  return _IterOutput_(o, begin(vec), end(vec), "[", "]");
}
template <typename T>
ostream &operator<<(ostream &o, const set<T> &st) {
  return _IterOutput_(o, begin(st), end(st), "{", "}");
}
template <typename T, size_t N>
ostream &operator<<(ostream &o, const array<T, N> &arr) {
  return _IterOutput_(o, begin(arr), end(arr), "|", "|");
}
template <typename T1, typename T2>
ostream &operator<<(ostream &o, const map<T1, T2> &mp) {
  o << "{";
  for (auto it = mp.begin(); it != mp.end(); it++) {
    o << (it == mp.begin() ? "" : ", ") << it->first << ":" << it->second;
  }
  o << "}";
  return o;
}
const int MX = 5555;
int N;
vector<int> el[MX];
bool ins[MX];
stack<int> st;
vector<int> lop;
bool dfs(int u, int fa) {
  ins[u] = 1;
  st.push(u);
  for (auto v : el[u]) {
    if (v == fa) continue;
    if (ins[v]) {
      int w;
      do {
        w = st.top();
        st.pop();
        lop.push_back(w);
      } while (w != v);
      return 1;
    }
    if (dfs(v, u)) return 1;
  }
  return 0;
}
bool islop[MX];
int lopId[MX];
int fath[MX];
vector<int> lopCh[MX];
double ans;
void dfs2(int u, int fa, int d, int id) {
  lopCh[id].push_back(d);
  fath[u] = id;
  for (auto v : el[u]) {
    if (v == fa) continue;
    if (islop[v]) continue;
    dfs2(v, u, d + 1, id);
  }
}
void dfs3(int u, int fa, int d) {
  ans += 1.0 / d;
  for (auto v : el[u]) {
    if (v == fa) continue;
    if (islop[v] && v != fath[u]) {
      continue;
    }
    dfs3(v, u, d + 1);
  }
}
int32_t main() {
  do {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
  } while (0);
  cin >> N;
  for (int i = 0; i < N; i++) {
    int u, v;
    cin >> u >> v;
    el[u].push_back(v);
    el[v].push_back(u);
  }
  dfs(0, -1);
  assert(((int)(lop).size()));
  int lll = 0;
  for (auto v : lop) {
    islop[v] = 1;
    lopId[v] = ++lll;
  }
  for (auto v : lop) {
    dfs2(v, -1, 1, v);
  }
  for (int i = 0; i < N; i++) {
    dfs3(i, -1, 1);
  }
  for (auto u : lop) {
    for (auto v : lop) {
      if (u == v) continue;
      int d1 = abs(lopId[u] - lopId[v]), d2 = lll - d1;
      d1--;
      d2--;
      for (auto x : lopCh[u]) {
        for (auto y : lopCh[v]) {
          ans += 1.0 / (x + y + d1);
          ans += 1.0 / (x + y + d2);
          ans -= 1.0 / (x + y + d1 + d2);
        }
      }
    }
  }
  cout << fixed << setprecision(10) << ans << endl;
  return 0;
}
