#include <bits/stdc++.h>
using namespace std;
int b1, b2, s1, s2, n, yol[10][2] = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1},
                                     {0, 1}, {1, 0},  {0, -1}, {-1, 0}};
map<pair<int, int>, int> mp;
queue<pair<int, int>> q;
int main() {
  scanf("%d %d %d %d", &b1, &b2, &s1, &s2);
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int a, b, r;
    scanf("%d %d %d", &r, &a, &b);
    for (int j = a; j <= b; j++) {
      mp[{r, j}] = -1;
    }
  }
  mp[{b1, b2}] = 0;
  q.push({b1, b2});
  while (!q.empty()) {
    pair<int, int> pt = q.front();
    q.pop();
    if (pt.first == s1 && pt.second == s2) {
      printf("%d", mp[pt]);
      return 0;
    }
    for (int i = 0; i < 8; i++) {
      if (mp[{pt.first + yol[i][0], pt.second + yol[i][1]}] == -1) {
        mp[{pt.first + yol[i][0], pt.second + yol[i][1]}] = mp[pt] + 1;
        q.push({pt.first + yol[i][0], pt.second + yol[i][1]});
      }
    }
  }
  printf("-1");
  return 0;
}
