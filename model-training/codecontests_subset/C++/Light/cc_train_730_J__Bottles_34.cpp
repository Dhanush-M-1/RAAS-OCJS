#include <bits/stdc++.h>
using namespace std;
int a[105], b[105];
pair<int, int> dp[105][10000 * 2 + 5];
int n;
pair<int, int> rek(int p, int left) {
  if (p == n) {
    if (left >= 10000) return pair<int, int>(0, 0);
    return pair<int, int>(1000, 1000000);
  }
  pair<int, int> &res = dp[p][left];
  if (res.first != -1) return res;
  res = pair<int, int>(1000, 100000);
  pair<int, int> temp;
  temp = rek(p + 1, left - a[p]);
  temp.second += a[p];
  if (temp.first < res.first ||
      (temp.first == res.first && temp.second < res.second))
    res = temp;
  temp = rek(p + 1, left + (b[p] - a[p]));
  temp.first += 1;
  if (temp.first < res.first ||
      (temp.first == res.first && temp.second < res.second))
    res = temp;
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n; i++) scanf("%d", &b[i]);
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= 20000; j++) {
      dp[i][j] = pair<int, int>(-1, -1);
    }
  }
  pair<int, int> res = rek(0, 10000);
  cout << res.first << " " << res.second << endl;
  return 0;
}
