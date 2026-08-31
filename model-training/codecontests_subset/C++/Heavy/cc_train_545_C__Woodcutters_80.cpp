#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
struct node {
  int x, h;
} p[maxn];
bool operator<(const node &a, const node &b) { return a.x < b.x; }
int n;
int f[maxn][3];
int main() {
  cin >> n;
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &p[i].x, &p[i].h);
  }
  sort(p, p + n);
  memset(f, 0, sizeof(f));
  f[0][0] = 1;
  f[0][1] = 0;
  if (p[0].x + p[0].h < p[1].x)
    f[0][2] = 1;
  else
    f[0][2] = 1;
  for (int i = 1; i < n; i++) {
    f[i][1] = max(f[i - 1][0], max(f[i - 1][1], f[i - 1][2]));
    if (i == n - 1 || p[i].x + p[i].h < p[i + 1].x) {
      f[i][2] = max(f[i - 1][0], max(f[i - 1][1], f[i - 1][2])) + 1;
    }
    if (p[i].x - p[i].h > p[i - 1].x) {
      f[i][0] = max(f[i - 1][0], f[i - 1][1]);
      if (p[i - 1].x + p[i - 1].h < p[i].x - p[i].h)
        f[i][0] = max(f[i][0], f[i - 1][2]);
      f[i][0]++;
    }
  }
  cout << max(f[n - 1][0], max(f[n - 1][1], f[n - 1][2])) << endl;
  return 0;
}
