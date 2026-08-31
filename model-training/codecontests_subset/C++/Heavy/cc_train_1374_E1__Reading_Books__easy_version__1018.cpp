#include <bits/stdc++.h>
using namespace std;
const long long Mod = 1e5 + 7;
const int N = 2e6 + 5;
int arr[N];
int idx[4] = {0, 0, 0, 0};
vector<int> vec[4];
int take(int x) {
  if (vec[x].size() <= idx[x]) return Mod;
  return vec[x][idx[x]++];
}
int get(int x) {
  if (vec[x].size() <= idx[x]) return Mod;
  return arr[vec[x][idx[x]]];
}
bool comp(int x, int y) { return arr[x] < arr[y]; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int numCases = 1;
  for (int caseNo = 1; caseNo <= numCases; caseNo++) {
    int n, k, m, sum_a = 0, sum_b = 0, sum = 0;
    cin >> n >> m >> k;
    set<int> ans;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      bool f, s;
      cin >> f >> s;
      if (f && s)
        vec[0].push_back(i);
      else if (f)
        vec[1].push_back(i);
      else if (s)
        vec[2].push_back(i);
      else
        vec[3].push_back(i);
    }
    sort(vec[0].begin(), vec[0].end(), comp);
    sort(vec[1].begin(), vec[1].end(), comp);
    sort(vec[2].begin(), vec[2].end(), comp);
    sort(vec[3].begin(), vec[3].end(), comp);
    while (idx[0] < min({(int)vec[0].size(), m, k})) ans.insert(take(0));
    sum_a = sum_b = idx[0];
    while (sum_a < k) {
      if (get(1) == Mod) break;
      ans.insert(take(1));
      sum_a++;
    }
    while (sum_b < k) {
      if (get(2) == Mod) break;
      ans.insert(take(2));
      sum_b++;
    }
    while (ans.size() < m) {
      int mn = 0;
      for (int i = 1; i < 4; i++)
        if (get(i) < get(mn)) mn = i;
      if (idx[0] && get(1) + get(2) < arr[vec[0][idx[0] - 1]] + get(mn)) {
        ans.erase(vec[0][--idx[0]]);
        ans.insert(take(1));
        ans.insert(take(2));
        continue;
      }
      ans.insert(take(mn));
    }
    if (sum_a < k || sum_b < k || ans.size() > m) {
      cout << -1 << endl;
      continue;
    }
    for (auto u : ans) sum += arr[u];
    cout << sum << '\n';
    for (auto u : ans) cout << u + 1 << " ";
  }
}
