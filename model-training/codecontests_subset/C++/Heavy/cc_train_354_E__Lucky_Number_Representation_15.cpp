#include <bits/stdc++.h>
using namespace std;
int n, L[3] = {0, 4, 7}, ok[1000];
string second;
vector<int> caras[1000];
vector<int> somas;
int dp[20][100], prox[20][100];
int solve(int i, int sobra) {
  if (i < 0) return (sobra == 0);
  if (dp[i][sobra] != -1) return dp[i][sobra];
  int ans = 0;
  for (int j = 0; j < somas.size(); j++) {
    int S = somas[j] + sobra;
    int sobra2 = S / 10;
    S = S - 10 * sobra2;
    if (S == (second[i] - '0')) {
      ans |= solve(i - 1, sobra2);
      if (ans) {
        prox[i][sobra] = j;
        return dp[i][sobra] = 1;
      }
    }
  }
  return dp[i][sobra] = ans;
}
string ans[10];
void get(int i, int sobra) {
  if (i < 0) return;
  int j = prox[i][sobra];
  int S = somas[j] + sobra;
  int sobra2 = S / 10;
  for (int z = 0; z < caras[somas[j]].size(); z++)
    ans[z].push_back((char)(L[caras[somas[j]][z]] + '0'));
  get(i - 1, sobra2);
}
void build() {
  for (int a = 0; a < 3; a++)
    for (int b = 0; b < 3; b++)
      for (int c = 0; c < 3; c++)
        for (int d = 0; d < 3; d++)
          for (int e = 0; e < 3; e++)
            for (int first = 0; first < 3; first++) {
              int sum = L[a] + L[b] + L[c] + L[d] + L[e] + L[first];
              if (ok[sum]) continue;
              ok[sum] = 1;
              caras[sum].push_back(a);
              caras[sum].push_back(b);
              caras[sum].push_back(c);
              caras[sum].push_back(d);
              caras[sum].push_back(e);
              caras[sum].push_back(first);
              somas.push_back(sum);
            }
}
int T;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  build();
  cin >> T;
  while (T--) {
    cin >> second;
    memset(dp, -1, sizeof dp);
    for (int i = 0; i < 6; i++) ans[i].clear();
    if (solve((int)second.size() - 1, 0)) {
      get((int)second.size() - 1, 0);
      for (int j = 0; j < 6; j++) {
        reverse(ans[j].begin(), ans[j].end());
        int z = 0;
        while (z < ans[j].size() and ans[j][z] == '0') z++;
        if (z >= ans[j].size()) z--;
        for (int u = z; u < ans[j].size(); u++) cout << ans[j][u];
        cout << " ";
      }
      cout << "\n";
    } else
      cout << "-1\n";
  }
}
