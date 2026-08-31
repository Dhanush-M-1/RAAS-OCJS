#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
const double pi = 3.14159265358979323846264338327950288419716939937511;
const double eps = 1e-11;
char ch_ch_ch[1 << 20];
string gs() {
  scanf("%s", ch_ch_ch);
  return string(ch_ch_ch);
}
string gl() {
  gets(ch_ch_ch);
  return string(ch_ch_ch);
}
vector<double> prob;
vector<vector<double> > a;
int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
int gauss(vector<vector<double> > a, vector<double> &res) {
  vector<vector<double> > tmp = a;
  int n = a.size(), m = a[0].size();
  int p = 0;
  for (int i = 0; i < m && p < min(n, m); ++i) {
    int maxrow = p;
    for (int j = p + 1; j < n; ++j)
      if (abs(a[maxrow][i]) < abs(a[j][i])) maxrow = j;
    swap(a[maxrow], a[p]);
    if (abs(a[p][i]) < eps) continue;
    for (int j = i + 1; j < m; ++j) a[p][j] /= a[p][i];
    a[p][i] = 1;
    for (int j = 0; j < n; ++j)
      if (p != j) {
        for (int k = i + 1; k < m; ++k) a[j][k] -= a[j][i] * a[p][k];
        a[j][i] = 0;
      }
    p++;
    if (i == m - 1) return 0;
  }
  a = tmp;
  res.resize(n, 0);
  for (int i = 0; i < n; ++i) {
    int maxrow = i;
    for (int j = i + 1; j < n; ++j)
      if (abs(a[maxrow][i]) < abs(a[j][i])) maxrow = j;
    swap(a[i], a[maxrow]);
    for (int j = i + 1; j < m; ++j) a[i][j] /= a[i][i];
    a[i][i] = 1;
    for (int j = 0; j < n; ++j)
      if (j != i) {
        for (int k = i + 1; k < m; ++k) a[j][k] -= a[j][i] * a[i][k];
        a[j][i] = 0;
      }
  }
  for (int i = 0; i < n; ++i) res[i] = a[i][m - 1];
  return (p < n ? 2 : 1);
}
int solve(int x, int y, int tx, int ty, int dx, int dy) {
  a.resize(2, vector<double>(3, 0));
  a[0][0] = dx, a[0][1] = dy, a[0][2] = tx - x;
  a[1][0] = dy, a[1][1] = -dx, a[1][2] = ty - y;
  int r = gauss(a, prob);
  if (r == 0) {
    return 0;
  }
  if (r == 1) {
    long long kx = (long long)floor(prob[0] + 0.5);
    long long ky = (long long)floor(prob[1] + 0.5);
    if (dx * kx + dy * ky == (long long)(tx - x) &&
        dy * kx - dx * ky == (long long)(ty - y))
      return 1;
    return 0;
  }
  if (gcd(abs(dx), abs(dy)) == 0) return abs(tx - x) == 0;
  if (abs(tx - x) % gcd(abs(dx), abs(dy)) == 0) return 1;
  return 0;
}
void solution() {
  int x, y, dx, dy, tx, ty;
  scanf("%d%d%d%d%d%d", &x, &y, &tx, &ty, &dx, &dy);
  if (solve(x, y, tx, ty, dx, dy) || solve(x, y, -ty, tx, dx, dy) ||
      solve(x, y, ty, -tx, dx, dy) || solve(x, y, -tx, -ty, dx, dy))
    printf("YES\n");
  else
    printf("NO\n");
}
int main() {
  solution();
  return 0;
}
