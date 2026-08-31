#include <bits/stdc++.h>
using namespace std;
bool isrange(int second, int first, int n, int m) {
  if (0 <= second && second < n && 0 <= first && first < m) return true;
  return false;
}
int dy[4] = {1, 0, -1, 0}, dx[4] = {0, 1, 0, -1},
    ddy[8] = {1, 0, -1, 0, 1, 1, -1, -1}, ddx[8] = {0, 1, 0, -1, 1, -1, 1, -1};
priority_queue<int> q[3];
int main(void) {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int e = 1; e <= n; e++) {
    int t, a, b;
    scanf("%d%d%d", &t, &a, &b);
    if (a == 1 && b == 1)
      q[2].push(-t);
    else if (a == 1)
      q[0].push(-t);
    else if (b == 1)
      q[1].push(-t);
  }
  long long int ans = 0;
  for (int e = 0; e < k; e++) {
    if ((int)q[0].size() == 0 || (int)q[1].size() == 0) {
      if ((int)q[2].size() == 0) {
        printf("-1");
        return 0;
      }
      long long int tt = -q[2].top();
      ans += tt;
      q[2].pop();
    } else {
      long long int t1 = -q[0].top() - q[1].top();
      if ((int)q[2].size() == 0) {
        ans += t1;
        q[0].pop();
        q[1].pop();
      } else {
        long long int t2 = -q[2].top();
        if (t1 > t2) {
          ans += t2;
          q[2].pop();
        } else {
          ans += t1;
          q[0].pop();
          q[1].pop();
        }
      }
    }
  }
  printf("%lld", ans);
  return 0;
}
