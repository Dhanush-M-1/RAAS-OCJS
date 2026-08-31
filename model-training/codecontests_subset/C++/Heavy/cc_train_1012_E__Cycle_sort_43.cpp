#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
const int N = 2e5 + 5;
int n, s, cnt, to[N], a[N], b[N], pos[N];
vector<int> all[N];
pair<int, int> p[N];
void compress() {
  for (int i = 0; i < (int)(n); ++i) p[i] = {a[i], i};
  sort(p, p + n);
  int num = 0;
  for (int i = 0; i < n;) {
    int start = i;
    while (i < n && p[i].first == p[start].first) {
      a[p[i].second] = num;
      i++;
    }
    num++;
  }
}
vector<vector<int> > cycles;
vector<pair<int, int> > g[N];
int par[N];
void init() {
  for (int i = 1; i <= (int)(n); ++i) par[i] = i;
}
int find_set(int v) {
  if (v == par[v]) return v;
  return par[v] = find_set(par[v]);
}
void union_set(int a, int b) {
  a = find_set(a);
  b = find_set(b);
  par[a] = b;
}
bool used[N];
void find_all_cycles() {
  cycles.clear();
  memset(used, 0, sizeof(used));
  for (int i = 0; i < (int)(n); ++i) {
    if (!used[i] && to[i] != -1) {
      int pos = i;
      vector<int> cycle;
      while (used[pos] == 0) {
        used[pos] = 1;
        cycle.push_back(pos);
        g[a[pos]].emplace_back((int)(cycles).size(), pos);
        pos = to[pos];
      }
      cycles.push_back(cycle);
    }
  }
}
int main(int argc, char **argv) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> s;
  for (int i = 0; i < (int)(n); ++i) cin >> a[i];
  compress();
  copy(a, a + n, b);
  sort(b, b + n);
  for (int i = 0; i < (int)(n); ++i) {
    if (a[i] != b[i]) all[a[i]].push_back(i);
    to[i] = -1;
  }
  for (int i = 0; i < (int)(n); ++i) {
    if (a[i] != b[i]) {
      int p = all[b[i]][pos[b[i]]++];
      to[p] = i;
      cnt++;
    }
  }
  if (cnt > s) {
    cout << -1 << '\n';
    return 0;
  }
  find_all_cycles();
  init();
  for (int i = 0; i < (int)(n); ++i) {
    if ((int)(g[i]).size() > 1) {
      pair<int, int> first = g[i][0];
      for (auto &(p) : (g[i])) {
        if (find_set(first.first) != find_set(p.first)) {
          union_set(first.first, p.first);
          swap(to[first.second], to[p.second]);
        }
      }
    }
  }
  find_all_cycles();
  int ans = (int)(cycles).size();
  if (s > cnt) {
    int q = min((int)(cycles).size(), s - cnt);
    if (q >= 3) {
      ans += 2 - q;
      cout << ans << '\n';
      vector<int> v;
      cout << q << '\n';
      for (int i = 0; i < (int)(q); ++i) {
        v.push_back(cycles[i][0]);
        cout << cycles[i][0] + 1 << " \n"[i == q - 1];
      }
      int cp = to[v.back()];
      for (int i = (int)((int)(v).size() - 1); i >= (int)(1); --i)
        to[v[i]] = to[v[i - 1]];
      to[v[0]] = cp;
      find_all_cycles();
    } else {
      cout << ans << '\n';
    }
  } else
    cout << ans << '\n';
  for (auto &(p) : (cycles)) {
    cout << (int)(p).size() << '\n';
    for (auto &(i) : (p)) cout << i + 1 << ' ';
    cout << '\n';
  }
}
