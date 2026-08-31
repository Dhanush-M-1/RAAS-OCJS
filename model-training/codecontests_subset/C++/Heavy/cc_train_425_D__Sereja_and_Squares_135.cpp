#include <bits/stdc++.h>
using namespace std;
int n;
struct data {
  int x, y;
  int xi, yi;
} a[100000 + 5];
vector<int> vx[100005], vy[100005];
long long sum;
map<pair<int, int>, bool> mp;
void process() {
  for (int i = 1; i <= n; i++) {
    int k = a[i].xi;
    for (int j = a[i].yi; j < vy[a[i].y].size(); j++) {
      while (k < vx[a[i].x].size() &&
             vx[a[i].x][k] - a[i].y < vy[a[i].y][j] - a[i].x)
        k++;
      if (k >= vx[a[i].x].size()) break;
      if (vx[a[i].x][k] - a[i].y == vy[a[i].y][j] - a[i].x)
        sum += mp[make_pair(vy[a[i].y][j], vx[a[i].x][k])];
    }
  }
  printf("%I64d", sum);
}
bool compare(data x, data y) { return (x.y < y.y || x.y == y.y && x.x < y.x); }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d %d", &a[i].x, &a[i].y);
    mp[make_pair(a[i].x, a[i].y)] = 1;
  }
  sort(a + 1, a + n + 1, compare);
  for (int i = 1; i <= n; i++) {
    vx[a[i].x].push_back(a[i].y);
    a[i].xi = vx[a[i].x].size();
    vy[a[i].y].push_back(a[i].x);
    a[i].yi = vy[a[i].y].size();
  }
  process();
  return 0;
}
