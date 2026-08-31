#include <bits/stdc++.h>
using namespace std;
int ans[2050][15][50];
int data[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
bool judge(int d, int m, int y) {
  if (y <= 2015 && y >= 2013) {
    if (m >= 1 && m <= 12) {
      if (d >= 1 && d <= data[m - 1]) return true;
    }
  }
  return false;
}
const int N = 1e5 + 100;
char st[N];
int getnex(int x, int n, int &len) {
  int now = 0;
  len = 0;
  for (int i = x; i < n; i++) {
    if (st[i] == '-') break;
    now *= 10;
    now += st[i] - '0';
    len++;
    if (len == 4) return now;
  }
  return now;
}
vector<int> G;
int main() {
  scanf("%s", st);
  int len = strlen(st);
  for (int i = 0; i < len; i++) {
    if (st[i] == '-') G.push_back(i);
  }
  for (int i = 0; i < len; i++) {
    if (st[i] == '-') continue;
    int l;
    int d = getnex(i, len, l);
    if (l != 2) d = 100;
    int now = upper_bound(G.begin(), G.end(), i) - G.begin();
    if (now == G.size()) continue;
    int m = getnex(G[now] + 1, len, l);
    if (l != 2) m = 100;
    now = upper_bound(G.begin(), G.end(), G[now]) - G.begin();
    if (now == G.size()) continue;
    int y = getnex(G[now] + 1, len, l);
    if (l != 4) y = 0;
    if (judge(d, m, y)) {
      ans[y][m][d]++;
    }
  }
  int mx = 0;
  int dd = 0, mm = 0, yy = 0;
  for (int i = 2013; i <= 2015; i++) {
    for (int j = 1; j <= 12; j++) {
      for (int k = 1; k <= 31; k++) {
        if (ans[i][j][k] > mx) {
          mx = ans[i][j][k];
          yy = i, mm = j, dd = k;
        }
      }
    }
  }
  printf("%02d-%02d-%d\n", dd, mm, yy);
  return 0;
}
