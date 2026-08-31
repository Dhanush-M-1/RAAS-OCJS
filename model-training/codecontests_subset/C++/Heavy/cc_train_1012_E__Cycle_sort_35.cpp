#include <bits/stdc++.h>
using namespace std;
int n, s, a[200079], p[200079];
vector<pair<int, int> > b(200079);
int rodic[200079], r[200079];
int najdisef(int v) {
  if (rodic[v] == v) return v;
  rodic[v] = najdisef(rodic[v]);
  return rodic[v];
}
void spojset(int i, int j) {
  i = najdisef(i);
  j = najdisef(j);
  if (i == j) return;
  if (r[i] > r[j]) swap(i, j);
  if (r[i] == r[j]) r[j]++;
  rodic[i] = j;
}
int t;
vector<int> u(200079, false);
vector<vector<int> > c(200079);
void dfs(int vr) {
  u[vr] = true;
  c[t].push_back(vr);
  if (!u[p[vr]]) dfs(p[vr]);
}
bool cmp(pair<int, int> p1, pair<int, int> p2) {
  if (p1.first == p2.first) return p1.second > p2.second;
  return p1.first > p2.first;
}
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    pair<int, int> tmp;
    tmp.first = a[i];
    tmp.second = i;
    b[i] = tmp;
  }
  sort(b.begin(), b.begin() + n);
  for (int i = 0; i < n; i++) p[b[i].second] = i;
  for (int i = 0; i < n; i++) {
    if (a[i] == b[i].first && p[i] != i) {
      p[b[i].second] = p[i];
      b[p[i]].second = b[i].second;
      p[i] = i;
      b[i].second = i;
    }
  }
  for (int i = 0; i < n; i++) {
    rodic[i] = i;
    r[i] = 0;
  }
  for (int i = 0; i < n; i++) spojset(p[i], i);
  int ls = -1;
  for (int i = 0; i < n; i++) {
    if (p[b[i].second] == b[i].second) continue;
    if (ls >= 0 && a[ls] == a[b[i].second]) {
      int va = ls, vb = b[i].second;
      if (najdisef(va) == najdisef(vb)) continue;
      spojset(va, vb);
      swap(p[va], p[vb]);
    }
    ls = b[i].second;
  }
  t = 0;
  for (int i = 0; i < n; i++)
    if (u[i] == 0 && p[i] != i) {
      dfs(i);
      t++;
    }
  int ans = 0;
  for (int i = 0; i < t; i++) ans += c[i].size();
  if (ans > s) {
    cout << "-1\n";
    return 0;
  }
  s -= ans;
  s = min(s, t);
  if (s <= 1) {
    cout << t << endl;
    for (int i = 0; i < t; i++) {
      cout << c[i].size() << endl;
      for (int j = 0; j < c[i].size(); j++) cout << c[i][j] + 1 << " ";
      cout << endl;
    }
    return 0;
  }
  cout << (t - s + 2) << endl;
  for (int i = 0; i < t - s; i++) {
    cout << c[i + s].size() << endl;
    for (int j = 0; j < c[i + s].size(); j++) cout << c[i + s][j] + 1 << " ";
    cout << endl;
    ans -= c[i + s].size();
  }
  cout << ans << endl;
  for (int i = 0; i < s; i++)
    for (int j = 0; j < c[i].size(); j++) cout << c[i][j] + 1 << " ";
  cout << endl;
  cout << s << endl;
  for (int i = s - 1; i >= 0; i--) cout << c[i][0] + 1 << " ";
  cout << "\n";
  return 0;
}
