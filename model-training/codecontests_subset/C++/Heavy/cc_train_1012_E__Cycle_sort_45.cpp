#include <bits/stdc++.h>
using namespace std;
template <class T, class U>
void ckmin(T &a, U b) {
  if (a > b) a = b;
}
template <class T, class U>
void ckmax(T &a, U b) {
  if (a < b) a = b;
}
const int MAXN = 400013;
int N, S, M, ans, n;
int val[MAXN], arr[MAXN], sorted[MAXN];
vector<int> moves[MAXN];
vector<int> cyc[MAXN];
bitset<MAXN> vis;
vector<int> compress;
int freq[MAXN];
pair<int, int> range[MAXN];
vector<int> edge[MAXN];
vector<int> tour;
int ind[MAXN];
int indexof(vector<int> &v, int x) {
  return upper_bound((v).begin(), (v).end(), x) - v.begin() - 1;
}
void dfs(int u) {
  while (!edge[u].empty()) {
    int v = edge[u].back();
    edge[u].pop_back();
    dfs(v);
  }
  tour.push_back(u);
}
void solve() {
  int k = min(M, S - n);
  if (k <= 2) {
    ans = M;
    for (auto i = (0); i < (M); i++) {
      moves[i] = cyc[i];
    }
  } else {
    ans = M - k + 2;
    for (auto i = (0); i < (M - k); i++) {
      moves[i] = cyc[i];
    }
    for (auto i = (M - k); i < (M); i++) {
      moves[M - k].insert(moves[M - k].end(), (cyc[i]).begin(), (cyc[i]).end());
      moves[M - k + 1].push_back(cyc[i][0]);
    }
    reverse((moves[M - k + 1]).begin(), (moves[M - k + 1]).end());
  }
}
int32_t main() {
  cout << fixed << setprecision(12);
  cerr << fixed << setprecision(4);
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> N >> S;
  for (auto i = (0); i < (N); i++) {
    cin >> val[i];
    compress.push_back(val[i]);
  }
  sort((compress).begin(), (compress).end());
  compress.erase(unique((compress).begin(), (compress).end()), compress.end());
  for (auto i = (0); i < (N); i++) {
    val[i] = indexof(compress, val[i]);
    sorted[i] = val[i];
  }
  sort(sorted, sorted + N);
  for (auto i = (0); i < (N); i++) {
    if (val[i] == sorted[i]) {
      vis[i] = true;
      arr[i] = i;
      continue;
    }
    edge[i].push_back(val[i] + N);
    edge[sorted[i] + N].push_back(i);
  }
  for (auto i = (0); i < (N); i++) {
    if (vis[i]) continue;
    tour.clear();
    dfs(i);
    reverse((tour).begin(), (tour).end());
    for (int j = 0; j + 2 < ((int)(tour).size()); j += 2) {
      int u = tour[j];
      int v = tour[j + 2];
      arr[u] = v;
    }
    tour.clear();
  }
  vis.reset();
  for (auto i = (0); i < (N); i++) {
    if (vis[i]) continue;
    if (arr[i] == i) {
      continue;
    }
    cyc[M].push_back(i);
    do {
      vis[cyc[M].back()] = true;
      cyc[M].push_back(arr[cyc[M].back()]);
    } while (cyc[M].back() != i);
    cyc[M].pop_back();
    M++;
  }
  for (auto i = (0); i < (M); i++) {
    n += ((int)(cyc[i]).size());
  }
  if (S < n) {
    cout << "-1\n";
    return 0;
  }
  solve();
  assert(ans == min(M, max(2, 2 + M - S + n)));
  cout << ans << '\n';
  for (auto i = (0); i < (ans); i++) {
    cout << ((int)(moves[i]).size()) << '\n';
    for (int x : moves[i]) {
      cout << x + 1 << " \n"[x == moves[i].back()];
    }
  }
}
