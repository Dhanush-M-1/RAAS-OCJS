#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 7;
string to_string(string s) { return '"' + s + '"'; }
string to_string(char s) { return string(1, s); }
string to_string(const char *s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
template <typename A>
string to_string(A);
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A>
string to_string(A v) {
  bool f = 1;
  string r = "{";
  for (const auto &x : v) {
    if (!f) r += ", ";
    f = 0;
    r += to_string(x);
  }
  return r + "}";
}
void debug_out() { cout << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cout << " " << to_string(H);
  debug_out(T...);
}
struct DSU {
  vector<int> p, r;
  vector<map<int, int>> nxt;
  int num;
  DSU(int n) : p(n), r(n), nxt(n), num(0) {
    for (auto i = (0); i <= (n - 1); ++i) p[i] = i;
  }
  int get(int i) {
    if (p[i] != i) p[i] = get(p[i]);
    return p[i];
  }
  int connect(int i, int j) {
    int x = get(i), y = get(j);
    if (x == y) return 0;
    --num;
    if (r[x] > r[y]) swap(x, y);
    p[x] = y;
    for (auto it : nxt[x]) {
      nxt[y].insert(it);
    }
    assert(nxt[y].count(i) and nxt[y].count(j));
    swap(nxt[y][i], nxt[y][j]);
    r[y] += r[x];
    return 1;
  }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  srand(8);
  int n, s;
  cin >> n >> s;
  vector<int> a(n);
  for (auto i = (0); i <= (n - 1); ++i) {
    cin >> a[i];
  }
  vector<int> b = a;
  sort((b).begin(), (b).end());
  map<int, vector<int>> pos, gpos;
  for (auto i = (0); i <= (n - 1); ++i)
    if (a[i] != b[i]) {
      pos[b[i]].push_back(i);
      gpos[a[i]].push_back(i);
    }
  vector<int> vis(n);
  DSU ds(n);
  int len = 0;
  for (auto i = (0); i <= (n - 1); ++i)
    if (!vis[i] and a[i] != b[i]) {
      int x = i;
      int cur = 0;
      do {
        vis[x] = 1;
        int y = pos[a[x]].back();
        pos[a[x]].pop_back();
        ds.p[x] = i;
        ds.nxt[i][x] = y;
        x = y;
        ++cur;
        ++len;
      } while (x != i);
      ds.num++;
      ds.r[i] = cur;
    }
  for (auto it : gpos) {
    const auto &A = it.second;
    for (auto i = (1); i <= (int(A.size()) - 1); ++i) {
      ds.connect(A[i], A[i - 1]);
    }
  }
  vector<vector<int>> cycles;
  for (auto i = (0); i <= (n - 1); ++i)
    if (a[i] != b[i] and ds.get(i) == i) {
      cycles.emplace_back();
      int x = i;
      do {
        cycles.back().emplace_back(x);
        x = ds.nxt[i][x];
      } while (x != i);
    }
  s -= len;
  if (s < 0) {
    cout << "-1\n";
    return 0;
  }
  int x = min(s, int(cycles.size()));
  vector<vector<int>> ans;
  if (x > 1) {
    ans.emplace_back();
    ans.emplace_back();
    for (auto i = (0); i <= (x - 1); ++i) {
      for (int j : cycles[i]) ans[0].emplace_back(j);
      ans[1].emplace_back(cycles[i][0]);
    }
    reverse((ans[1]).begin(), (ans[1]).end());
    for (auto i = (x); i <= (int(cycles.size()) - 1); ++i)
      ans.emplace_back(cycles[i]);
  } else
    ans = cycles;
  cout << int(ans.size()) << "\n";
  for (auto it : ans) {
    cout << int(it.size()) << "\n";
    for (auto itt : it) cout << itt + 1 << " ";
    cout << "\n";
  }
  return 0;
}
