#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 100;
pair<int, int> d[MAX_N + 1];
int F[MAX_N + 1][MAX_N * MAX_N + 1];
int main() {
  int n, sum = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &d[i].second);
    sum += d[i].second;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &d[i].first);
  }
  sort(d + 1, d + 1 + n,
       [](pair<int, int> a, pair<int, int> b) { return a.first > b.first; });
  int cnt = 0, now = 0;
  for (int i = 1; i <= n; i++) {
    now += d[i].first;
    cnt++;
    if (now >= sum) break;
  }
  memset(F, -1, sizeof(F));
  F[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum - d[i].second; j >= 0; j--) {
      for (int k = i - 1; k >= 0; k--)
        if (F[k][j] != -1) {
          F[k + 1][j + d[i].second] =
              max(F[k + 1][j + d[i].second], F[k][j] + d[i].first);
        }
    }
  }
  int ans = 0;
  for (int i = sum; i >= 0; i--) {
    if (F[cnt][i] >= sum) {
      ans = i;
      break;
    }
  }
  printf("%d %d\n", cnt, sum - ans);
  return 0;
}
