#include <bits/stdc++.h>
using namespace std;
const int N_MAX = 77;
int t;
int n, k;
struct Minion {
  int a, b;
  int index;
};
bool operator<(const Minion &x, const Minion &y) { return x.b < y.b; }
Minion v[N_MAX];
int dp[N_MAX][N_MAX];
bool step[N_MAX][N_MAX];
bool lastk[N_MAX];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
      cin >> v[i].a >> v[i].b;
      v[i].index = i;
    }
    sort(v + 1, v + n + 1);
    for (int j = 1; j <= k; j++) dp[0][j] = INT_MIN;
    for (int i = 1; i <= n; i++) {
      dp[i][0] = dp[i - 1][0] + (k - 1) * v[i].b;
      step[i][0] = false;
      for (int j = 1; j <= k; j++) {
        dp[i][j] = max(dp[i - 1][j] + (k - 1) * v[i].b,
                       dp[i - 1][j - 1] + (j - 1) * v[i].b + v[i].a);
        if (dp[i][j] == dp[i - 1][j] + (k - 1) * v[i].b)
          step[i][j] = false;
        else
          step[i][j] = true;
      }
    }
    for (int i = n, j = k; i > 0; i--)
      if (step[i][j] == true) {
        lastk[i] = true;
        j--;
      } else
        lastk[i] = false;
    cout << n + (n - k) << "\n";
    int imaxb = -1;
    for (int i = n; i >= 1; i--)
      if (lastk[i] == true) {
        imaxb = i;
        break;
      }
    for (int i = 1; i <= n; i++)
      if (lastk[i] == true && i != imaxb) cout << v[i].index << " ";
    for (int i = 1; i <= n; i++)
      if (lastk[i] == false) cout << v[i].index << " " << -v[i].index << " ";
    cout << v[imaxb].index << "\n";
  }
  return 0;
}
