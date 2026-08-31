#include <bits/stdc++.h>
using namespace std;
const int MAXN = (int)2e5 + 3;
const int infint = (int)1e9 + 3;
const long long inf = (long long)1e17;
int n, s, a[MAXN], idx[MAXN], final[MAXN], par[MAXN], visited[MAXN];
set<int> id[MAXN], num[MAXN];
vector<int> cyc[MAXN];
bool cmp(int u, int v) { return a[u] < a[v]; }
int get(int u) { return par[u] < 0 ? u : par[u] = get(par[u]); }
void merge(int u, int v) {
  if ((u = get(u)) == (v = get(v))) return;
  if (par[u] > par[v]) swap(u, v);
  par[u] += par[v];
  par[u] = v;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> s;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) idx[i] = i;
  sort(idx + 1, idx + n + 1, cmp);
  int sz = -1;
  for (int i = 1; i <= n; i++) {
    if (a[idx[i]] != a[idx[i - 1]]) sz++;
    id[sz].insert(i);
    num[sz].insert(idx[i]);
  }
  sz++;
  for (int i = 0; i < sz; i++) {
    vector<int> to_del;
    for (auto u : id[i])
      if (num[i].find(u) != num[i].end()) to_del.push_back(u);
    for (auto u : to_del) final[u] = u, num[i].erase(u), id[i].erase(u);
  }
  memset(par, -1, sizeof par);
  for (int i = 0; i < sz; i++) {
    vector<int> curid, curnum;
    for (auto u : id[i]) curid.push_back(u);
    for (auto u : num[i]) curnum.push_back(u);
    for (int j = 0; j < curnum.size(); j++)
      final[curnum[j]] = curid[j], merge(curid[j], curnum[j]);
  }
  for (int i = 0; i < sz; i++) {
    vector<int> curnum;
    for (auto u : num[i]) curnum.push_back(u);
    for (int j = 1; j < curnum.size(); j++)
      if (get(curnum[j]) != get(curnum[j - 1]))
        swap(final[curnum[j]], final[curnum[j - 1]]),
            merge(curnum[j], curnum[j - 1]);
  }
  sz = -1;
  for (int i = 1; i <= n; i++)
    if (final[i] != i && !visited[i]) {
      sz++;
      int iter = i;
      while (!visited[iter]) {
        cyc[sz].push_back(iter);
        visited[iter] = 1;
        iter = final[iter];
      }
    }
  sz++;
  int sum_of_cyc = 0;
  for (int i = 0; i < sz; i++) sum_of_cyc += cyc[i].size();
  s -= sum_of_cyc;
  if (s < 0) return cout << -1, 0;
  if (sz <= 2 || s <= 2) {
    cout << sz << "\n";
    for (int i = 0; i < sz; i++) {
      cout << cyc[i].size() << "\n";
      for (auto u : cyc[i]) cout << u << " ";
      cout << "\n";
    }
    return 0;
  }
  int merge_cyc = min(s, sz);
  cout << sz - merge_cyc + 2 << "\n";
  int s0 = 0;
  for (int i = 0; i < merge_cyc; i++) s0 += cyc[i].size();
  cout << s0 << "\n";
  for (int i = 0; i < merge_cyc; i++)
    for (auto u : cyc[i]) cout << u << " ";
  cout << "\n";
  cout << merge_cyc << "\n";
  cout << cyc[0][0] << " ";
  for (int i = merge_cyc - 1; i >= 1; i--) cout << cyc[i][0] << " ";
  cout << "\n";
  for (int i = merge_cyc; i < sz; i++) {
    cout << cyc[i].size() << "\n";
    for (auto u : cyc[i]) cout << u << " ";
    cout << "\n";
  }
}
