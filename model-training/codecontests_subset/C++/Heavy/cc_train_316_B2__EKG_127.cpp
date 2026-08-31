#include <bits/stdc++.h>
using namespace std;
int par[1005], in[1005], dp[1005][1005];
vector<int> v;
int main() {
  int n, x, k, len, pos, offset;
  scanf("%d", &n);
  scanf("%d", &k);
  for (int i = int(1); i <= int(n); i++) {
    scanf("%d", &x);
    if (x) {
      par[i] = x;
      in[x]++;
    }
  }
  for (int i = int(1); i <= int(n); i++) {
    assert(in[i] <= 1);
    if (!in[i]) {
      x = i;
      len = 0;
      pos = -1;
      while (x) {
        len++;
        if (x == k) pos = len;
        x = par[x];
      }
      if (pos != -1)
        offset = len - pos + 1;
      else
        v.push_back(len);
    }
  }
  n = v.size();
  dp[0][0] = 1;
  for (int i = int(1); i <= int(n); i++) {
    for (int j = int(0); j <= int(1000); j++) {
      if (dp[i - 1][j]) dp[i][j] = dp[i][j + v[i - 1]] = 1;
    }
  }
  for (int j = int(0); j <= int(1000); j++) {
    if (dp[n][j]) cout << j + offset << endl;
  }
  return 0;
}
