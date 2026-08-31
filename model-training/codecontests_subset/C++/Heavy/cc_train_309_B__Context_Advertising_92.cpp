#include <bits/stdc++.h>
using namespace std;
string str[1000006];
int dp[22][1000006];
int l[1000006];
int main() {
  int n, r, c, i, j, k;
  cin >> n >> r >> c;
  for (i = 0; i < (n); i++) {
    cin >> str[i];
    l[i] = ((int)(str[i]).size());
    if (i) l[i] += l[i - 1];
  }
  j = 0;
  for (i = 0; i < (n); i++) {
    for (; j < n; j++) {
      if ((l[j] - ((i != 0) ? l[i - 1] : 0) + (j - i)) > c) break;
    }
    dp[0][i] = j - 1;
  }
  for (i = (1); i <= (21); i++) {
    for (j = 0; j < (n); j++) {
      dp[i][j] =
          dp[i - 1]
            [((dp[i - 1][j] + 1) < (n - 1) ? (dp[i - 1][j] + 1) : (n - 1))];
    }
  }
  vector<int> v;
  for (i = 0; i < (30); i++)
    if (r & (1 << i)) v.push_back(i);
  reverse((v).begin(), (v).end());
  int ans = -1;
  int id = 0;
  for (i = 0; i < (n); i++) {
    j = i - 1;
    for (k = 0; k < (((int)(v).size())); k++)
      j = dp[v[k]][((n - 1) < (j + 1) ? (n - 1) : (j + 1))];
    if (ans < (j - i + 1)) {
      ans = (j - i + 1);
      id = i;
    }
  }
  int l = 0, f = 1;
  for (i = 0; i < ans; i++) {
    j = ((int)(str[id + i]).size());
    l += j;
    if (i) l++;
    if (l > c) {
      cout << endl;
      l = j;
    }
    if (j != l) {
      cout << " ";
    }
    cout << str[id + i];
  }
  cout << endl;
  return 0;
}
