#include <bits/stdc++.h>
using namespace std;
const int MAXN = 20 + 10;
const long long MOD = 1e9 + 7;
const int d[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
inline long long in() {
  long long x = 0, flag = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') flag = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9')
    x = (x << 3) + (x << 1) + (ch ^ 48), ch = getchar();
  return x * flag;
}
int n, len;
string ansx, ansy;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y, r;
    scanf("%d%d%d", &x, &y, &r);
    char nowx[110], nowy[110];
    string X = "", Y = "";
    sprintf(nowx, "(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", x / 2, i, i);
    sprintf(nowy, "(%d*((1-abs((t-%d)))+abs((1-abs((t-%d))))))", y / 2, i, i);
    X = nowx;
    Y = nowy;
    if (i == 0)
      ansx = ansx + X, ansy = ansy + Y;
    else
      ansx = "(" + ansx + "+" + X + ")", ansy = "(" + ansy + "+" + Y + ")";
  }
  cout << ansx << endl << ansy << endl;
  return 0;
}
