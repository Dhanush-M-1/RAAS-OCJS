#include <bits/stdc++.h>
using namespace std;
const long long NMAX = 200001;
const long long INF = (1 << 30);
const long long MOD = 1000000007;
const long long BLOCK = 101;
const long long nr_of_bits = 18;
int dp[76][76];
struct ura {
  ;
  int first, second, third;
} v[76];
bool cmp(ura a, ura b) { return a.second < b.second; }
vector<int> sol;
vector<int> sel;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, k, i, j;
    cin >> n >> k;
    sol.clear();
    sel.clear();
    for (i = 0; i <= n; i++) {
      for (j = 0; j <= k; j++) dp[i][j] = 0;
    }
    for (i = 1; i <= n; i++) {
      cin >> v[i].first >> v[i].second;
      v[i].third = i;
    }
    sort(v + 1, v + n + 1, cmp);
    for (i = 1; i <= n; i++) {
      for (j = 0; j <= min(i, k); j++) {
        if (i - 1 >= j)
          dp[i][j] = max(dp[i][j], dp[i - 1][j] + (k - 1) * v[i].second);
        if (j != 0) {
          dp[i][j] = max(dp[i][j],
                         dp[i - 1][j - 1] + (j - 1) * v[i].second + v[i].first);
        }
      }
    }
    i = n, j = k;
    while (i != 0) {
      if (i - 1 >= j && dp[i][j] == dp[i - 1][j] + (k - 1) * v[i].second) {
        sol.push_back(v[i].third);
        sol.push_back(-v[i].third);
      } else if (j != 0) {
        if (dp[i][j] == dp[i - 1][j - 1] + (j - 1) * v[i].second + v[i].first) {
          sel.push_back(v[i].third);
          j--;
        }
      }
      i--;
    }
    reverse(sel.begin(), sel.end());
    cout << sol.size() + sel.size() << "\n";
    for (int i = 0; i < sel.size() - 1; i++) {
      cout << sel[i] << " ";
    }
    for (auto x : sol) {
      cout << x << " ";
    }
    cout << sel.back() << "\n";
  }
  return 0;
}
