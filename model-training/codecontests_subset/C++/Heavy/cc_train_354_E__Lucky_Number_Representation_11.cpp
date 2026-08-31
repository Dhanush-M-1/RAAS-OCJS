#include <bits/stdc++.h>
using namespace std;
const int INF = 2147483647;
const long long LLINF = 9223372036854775807LL;
vector<int> var[50];
int ppp[3] = {0, 4, 7};
void dfs(int sum, vector<int> v) {
  if (int((v).size()) == 6)
    var[sum] = v;
  else {
    for (int d = 0; d < 3; ++d) {
      int cc = ppp[d];
      vector<int> tmp = v;
      tmp.push_back(cc);
      dfs(sum + cc, tmp);
    }
  }
}
void solve() {
  long long x;
  cin >> x;
  string s;
  do {
    s += (char)('0' + (x % 10));
    x /= 10;
  } while (x);
  int n = int((s).size());
  const int maxrem = 7;
  vector<vector<bool> > dp(n + 1, vector<bool>(maxrem));
  vector<vector<int> > predj(n + 1, vector<int>(maxrem));
  vector<vector<int> > predp(n + 1, vector<int>(maxrem));
  dp[0][0] = true;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < maxrem; ++j) {
      if (dp[i][j] == 0) continue;
      for (int t = 0; t < 43; ++t)
        if ((j + t) % 10 == s[i] - '0' && int((var[t]).size())) {
          int torem = (j + t) / 10;
          dp[i + 1][torem] = 1;
          predj[i + 1][torem] = j;
          predp[i + 1][torem] = t;
        }
    }
  if (dp[n][0] == 0)
    printf("-1\n");
  else {
    vector<vector<int> > vv;
    int curj = 0;
    for (int i = n; i > 0; --i) {
      vv.push_back(var[predp[i][curj]]);
      curj = predj[i][curj];
    }
    for (int i = 0; i < 6; ++i) {
      long long num = 0;
      for (int j = 0; j < int((vv).size()); ++j) num = num * 10 + vv[j][i];
      printf("%I64d ", num);
    }
    printf("\n");
  }
}
int main() {
  int t;
  scanf("%d", &t);
  dfs(0, vector<int>());
  while (t--) {
    solve();
  }
  return 0;
}
