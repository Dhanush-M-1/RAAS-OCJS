#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int MAXN = 2e5 + 1;
void run_case() {
  int n;
  cin >> n;
  vector<int> a(n);
  vector<int> occ[MAXN];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    a[i]--;
    occ[a[i]].push_back(i);
  }
  int mostFreq = 0;
  for (int i = 0; i < n; i++)
    if (occ[mostFreq].size() < occ[i].size()) mostFreq = i;
  int pre[MAXN];
  for (int i = 0; i < n; i++) {
    pre[i] = (i == 0) ? 0 : pre[i - 1];
    if (a[i] == mostFreq) pre[i]++;
  }
  int ans = 0;
  set<int> freqI;
  for (int j : occ[mostFreq]) freqI.insert(j);
  for (int i = 0; i < n; i++) {
    if (i == mostFreq) continue;
    map<int, int> preSto;
    int cur = 0;
    auto calc = [&](int ind, int val) {
      if (preSto.find(val) != preSto.end()) {
        cur = max(cur, ind - preSto[val]);
      } else {
        preSto[val] = ind;
      }
    };
    vector<int> rev;
    vector<int> calcVals;
    auto addSides = [&](int val) {
      int minInd =
          lower_bound(occ[mostFreq].begin(), occ[mostFreq].end(), val) -
          occ[mostFreq].begin();
      if (minInd == 0)
        calcVals.push_back(-1);
      else
        calcVals.push_back(occ[mostFreq][minInd - 1]);
      auto maxInd =
          upper_bound(occ[mostFreq].begin(), occ[mostFreq].end(), val);
      if (maxInd == occ[mostFreq].end())
        calcVals.push_back(n - 1);
      else
        calcVals.push_back(*maxInd - 1);
    };
    for (int j = 0; j < occ[i].size(); j++) {
      int v = occ[i][j];
      auto it = freqI.upper_bound(v);
      if (it != freqI.begin()) {
        --it;
        rev.push_back(*it);
        calcVals.push_back(*it);
        addSides(*it);
        freqI.erase(it);
      }
      calcVals.push_back(v);
      it = freqI.upper_bound(v);
      if (it != freqI.end()) {
        rev.push_back(*it);
        calcVals.push_back(*it);
        addSides(*it);
        freqI.erase(it);
      }
    }
    if (rev.empty()) continue;
    sort(calcVals.begin(), calcVals.end());
    for (int j : calcVals) {
      int jInd = upper_bound(occ[i].begin(), occ[i].end(), j) - occ[i].begin();
      calc(j, jInd - ((j == -1) ? 0 : pre[j]));
    }
    for (int j : rev) freqI.insert(j);
    ans = max(cur, ans);
  }
  cout << ans << '\n';
}
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  if (fopen("input.in", "r"))
    freopen("input.in", "r", stdin), freopen("output.out", "w", stdout);
  int t;
  t = 1;
  while (t--) {
    run_case();
  }
}
