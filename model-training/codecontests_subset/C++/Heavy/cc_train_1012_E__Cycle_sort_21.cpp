#include <bits/stdc++.h>
using namespace std;
using cat = long long;
void DFS(int R, vector<vector<int> >& G, vector<bool>& vis, vector<int>& cyc) {
  vis[R] = true;
  while (!G[R].empty()) {
    int v = G[R].back();
    G[R].pop_back();
    DFS(v, G, vis, cyc);
  }
  cyc.push_back(R);
}
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout << fixed << setprecision(10);
  int N, S;
  cin >> N >> S;
  vector<int> A(N);
  for (int i = 0; i < N; i++) cin >> A[i];
  vector<int> As(A);
  sort(begin(As), end(As));
  int wrong = 0;
  for (int i = 0; i < N; i++)
    if (A[i] != As[i]) wrong++;
  if (S < wrong) {
    cout << "-1\n";
    return 0;
  }
  map<int, int> M;
  for (int i = 0; i < N; i++) M[A[i]] = 0;
  int m = 0;
  for (auto it = M.begin(); it != M.end(); it++) it->second = m++;
  for (int i = 0; i < N; i++) A[i] = M[A[i]], As[i] = M[As[i]];
  vector<vector<int> > G(N + m);
  for (int i = 0; i < N; i++)
    if (A[i] != As[i]) G[i].push_back(A[i] + N);
  for (int i = 0; i < N; i++)
    if (A[i] != As[i]) G[As[i] + N].push_back(i);
  vector<bool> vis(N + m, false);
  vector<vector<int> > euc;
  for (int i = 0; i < N; i++)
    if (!vis[i] && A[i] != As[i]) {
      vector<int> c;
      DFS(i, G, vis, c);
      euc.push_back(vector<int>());
      reverse(begin(c), end(c));
      c.pop_back();
      for (auto it = c.begin(); it != c.end(); it++)
        if (*it < N) euc.back().push_back(*it);
    }
  int num_merged = min((int)euc.size(), S - wrong);
  if (num_merged <= 2) num_merged = 0;
  vector<vector<int> > ans;
  for (int i = num_merged; i < (int)euc.size(); i++) ans.push_back(euc[i]);
  if (num_merged > 0) {
    vector<int> mergedc;
    for (int i = 0; i < num_merged; i++)
      for (auto it = euc[i].begin(); it != euc[i].end(); it++)
        mergedc.push_back(*it);
    ans.push_back(mergedc);
    vector<int> failc;
    for (int i = 0; i < num_merged; i++) failc.push_back(euc[i][0]);
    reverse(begin(failc), end(failc));
    ans.push_back(failc);
  }
  cout << ans.size() << "\n";
  for (int i = 0; i < (int)ans.size(); i++) {
    cout << ans[i].size();
    for (auto it = ans[i].begin(); it != ans[i].end(); it++)
      cout << " " << *it + 1;
    cout << "\n";
  }
  return 0;
}
