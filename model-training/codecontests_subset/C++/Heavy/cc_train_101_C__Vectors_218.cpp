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
int gauss2(vector<vector<double> > a, vector<double> &res) {
  int n = a.size(), m = a[0].size();
  vector<char> was(m, 0);
  int i, p;
  for (i = 0, p = 0; p < n && i < m; ++i) {
    int k = p;
    for (int j = (p + 1); j < (n); ++j)
      if (abs(a[j][i]) > abs(a[k][i])) k = j;
    if (abs(a[k][i]) < eps) continue;
    for (int j = (i); j < (m); ++j) swap(a[k][j], a[p][j]);
    for (int j = (i + 1); j < (m); ++j) a[p][j] /= a[p][i];
    a[p][i] = 1;
    was[i] = 1;
    for (int j = 0; j < (n); ++j)
      if (j != p) {
        for (int k = (i + 1); k < (m); ++k) a[j][k] -= a[j][i] * a[p][k];
        a[j][i] = 0;
      }
    if (i == m - 1) return 0;
    ++p;
  }
  int rank = p;
  p = 0;
  res.resize(m - 1, 0);
  for (int i = 0; i < (m - 1); ++i)
    if (was[i]) res[i] = a[p++][m - 1];
  if (rank < m - 1) return 2;
  return 1;
}
int solve(int x, int y, int tx, int ty, int dx, int dy) {
  a.resize(2, vector<double>(3, 0));
  a[0][0] = dx, a[0][1] = dy, a[0][2] = tx - x;
  a[1][0] = dy, a[1][1] = -dx, a[1][2] = ty - y;
  int r = gauss2(a, prob);
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
