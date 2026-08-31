#include <bits/stdc++.h>
using namespace std;
int X[] = {0, 0, 1, 0, 0, -1};
int Y[] = {0, 1, 0, 0, -1, 0};
int Z[] = {1, 0, 0, -1, 0, 0};
struct node {
  int x, y;
  node() {}
  node(int x, int y) : x(x), y(y) {}
};
int main() {
  int i, j, k = 0, l, x, y, z, t, m, n;
  cin >> n >> m;
  map<int, int> mp;
  for (i = 1; i <= n; i++) {
    cin >> x;
    for (j = 0; j < x; j++) {
      cin >> y;
      if (mp[y] == 0) k++;
      mp[y] = 1;
    }
  }
  if (k == m)
    printf("YES");
  else
    printf("NO");
  return 0;
}
