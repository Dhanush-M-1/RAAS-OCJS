#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
using namespace std;
const int MAX = 200005;
int ans[MAX];
vector<int> P[MAX];
pair<int, int> edges[MAX];
bool O[MAX];
int SZ[MAX];
set<pair<int, int> > wziete;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, m, k;
  cin >> n >> m >> k;
  int akt = 0;
  for (int i = 1; i <= m; i++) {
    int a, b;
    cin >> a >> b;
    SZ[a]++;
    SZ[b]++;
    edges[i] = make_pair(a, b);
    P[a].push_back(b);
    P[b].push_back(a);
  }
  queue<int> Q;
  for (int i = 1; i <= n; i++) {
    if (O[i]) continue;
    if (P[i].size() < k) {
      O[i] = true;
      Q.push(i);
    }
  }
  while (!Q.empty()) {
    int aktuell = Q.front();
    Q.pop();
    for (auto it : P[aktuell]) {
      int l1 = it;
      int l2 = aktuell;
      if (l1 > l2) swap(l1, l2);
      if (wziete.find(make_pair(l1, l2)) != wziete.end()) continue;
      if (!O[it] && SZ[it] - 1 < k) {
        O[it] = true;
        Q.push(it);
      }
      SZ[it]--;
      wziete.insert(make_pair(l1, l2));
    }
  }
  for (int i = 1; i <= n; i++)
    if (!O[i]) akt++;
  ans[m] = akt;
  for (int i = m; i >= 2; i--) {
    int a = edges[i].first;
    int b = edges[i].second;
    if (a > b) swap(a, b);
    if (wziete.find(make_pair(a, b)) != wziete.end()) {
      ans[i - 1] = akt;
      continue;
    }
    wziete.insert(make_pair(a, b));
    SZ[a]--;
    SZ[b]--;
    if (!O[a] && SZ[a] < k) {
      O[a] = true;
      Q.push(a);
      akt--;
    }
    if (!O[b] && SZ[b] < k) {
      O[b] = true;
      Q.push(b);
      akt--;
    }
    while (!Q.empty()) {
      int aktuell = Q.front();
      Q.pop();
      for (auto it : P[aktuell]) {
        int l1 = it;
        int l2 = aktuell;
        if (l1 > l2) swap(l1, l2);
        if (wziete.find(make_pair(l1, l2)) != wziete.end()) continue;
        if (!O[it] && SZ[it] - 1 < k) {
          O[it] = true;
          Q.push(it);
          akt--;
        }
        SZ[it]--;
        wziete.insert(make_pair(l1, l2));
      }
    }
    ans[i - 1] = akt;
  }
  for (int i = 1; i <= m; i++) cout << ans[i] << "\n";
  return 0;
}
