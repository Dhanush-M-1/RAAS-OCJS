#include <bits/stdc++.h>
using namespace std;
int n, k, w[505];
queue<int> q[2];
int main() {
  int wgt = 0;
  scanf("%d%d", &n, &k);
  for (int x = 0; x < n; x++) scanf("%d", &w[x]);
  int cur = 0;
  bool inq[505];
  memset(inq, false, sizeof inq);
  while (k--) {
    int b;
    scanf("%d", &b);
    b--;
    if (inq[b]) {
      bool ketemu = false;
      while (!q[cur].empty()) {
        int tmp = q[cur].front();
        q[cur].pop();
        if (ketemu)
          wgt += w[tmp];
        else if (tmp == b)
          ketemu = true;
        if (tmp != b) q[!cur].push(tmp);
      }
      q[!cur].push(b);
      cur = !cur;
    } else {
      inq[b] = true;
      while (!q[cur].empty()) {
        int tmp = q[cur].front();
        q[cur].pop();
        wgt += w[tmp];
        q[!cur].push(tmp);
      }
      q[!cur].push(b);
      cur = !cur;
    }
  }
  printf("%d\n", wgt);
  return 0;
}
