#include <bits/stdc++.h>
using namespace std;
using ll = long long int;
using ld = long double;
using pi = pair<int, int>;
const double PI = acos(-1.0);
const double eps = 1e-9;
const ll mod = 1e9 + 7;
const int inf = 1e7;
const int MAXN = 1e5 + 5;
void cp() {
  int n, R, C;
  cin >> n >> R >> C;
  vector<string> arr(n);
  for (auto &x : arr) cin >> x;
  vector<vector<int>> lift(22, vector<int>(n + 1));
  for (int i = 0; i <= 21; i++)
    for (int j = 0; j <= n; j++) lift[i][j] = j;
  int j = -1, cnt = 0;
  for (int i = 0; i < n; i++) {
    if (j < i) {
      j = i, cnt = ((int)arr[i].size());
      if (cnt > C) continue;
    }
    while (j + 1 < n && cnt + ((int)arr[j + 1].size()) + (j - i + 1) <= C)
      j++, cnt += ((int)arr[j].size());
    lift[0][i] = j + 1;
    cnt -= ((int)arr[i].size());
  }
  for (int i = 1; i <= 21; i++)
    for (int j = 0; j < n; j++) lift[i][j] = lift[i - 1][lift[i - 1][j]];
  int idx = -1, best = -1;
  for (int i = 0; i < n; i++) {
    if (((int)arr[i].size()) > C) continue;
    int k = i;
    for (j = 21; j >= 0; j--) {
      if ((R >> j) & 1) k = lift[j][k];
    }
    int have = k - i;
    if (have > best) best = have, idx = i;
  }
  if (best == -1) return;
  j = idx;
  cnt = 0;
  string ans;
  while (j < n && best > 0) {
    if (((int)ans.size()) + (!ans.empty()) + ((int)arr[j].size()) <= C) {
      if (!ans.empty()) ans += ' ';
      ans += arr[j];
    } else
      cout << ans << '\n', ans = arr[j];
    j++;
    best--;
  }
  if (!ans.empty() && best >= 0) cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t;
  t = 1;
  while (t--) {
    cp();
  }
  return 0;
}
