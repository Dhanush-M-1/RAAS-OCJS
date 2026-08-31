#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int n, m, k, X[MAXN], Y[MAXN], deg[MAXN], cnt;
vector<pair<int, int> > E[MAXN];
bool removed[MAXN];
void ukloni(int x, int tijme) {
  if (!removed[x] && deg[x] < k) {
    removed[x] = true;
    cnt--;
    for (auto e : E[x])
      if (e.second < tijme) {
        deg[e.first]--;
        ukloni(e.first, tijme);
      }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> m >> k;
  for (int i = 0; i < m; ++i) {
    cin >> X[i] >> Y[i];
    E[X[i]].push_back(pair<int, int>(Y[i], i));
    E[Y[i]].push_back(pair<int, int>(X[i], i));
    deg[X[i]]++;
    deg[Y[i]]++;
  }
  cnt = n;
  for (int i = 1; i < n + 1; ++i) ukloni(i, MAXN);
  vector<int> sol;
  for (int i = m - 1; i >= 0; --i) {
    sol.push_back(cnt);
    if (!removed[X[i]] && !removed[Y[i]]) {
      deg[X[i]]--;
      deg[Y[i]]--;
      ukloni(X[i], i);
      ukloni(Y[i], i);
    }
  }
  for (int i = ((int)sol.size()) - 1; i >= 0; --i) cout << sol[i] << "\n";
}
