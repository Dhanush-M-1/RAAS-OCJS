#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e4 + 10;
const long long MOD = 1e6 + 3;
inline int in() {
  int x = 0, flag = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') flag = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9')
    x = (x << 3) + (x << 1) + (ch ^ 48), ch = getchar();
  return x * flag;
}
map<double, int> Mapx, Mapy;
long long mx, my, w;
long long rev(long long x) {
  long long ret = 0;
  while (x) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
void upd(int flag, long long x) {
  if (flag == 0)
    Mapx[(double)rev(x) / (double)x]++;
  else
    Mapy[(double)rev(x) / (double)x]++;
}
void del(int flag, long long x) {
  if (flag == 0)
    Mapx[(double)rev(x) / (double)x]--;
  else
    Mapy[(double)rev(x) / (double)x]--;
}
int main() {
  mx = in(), my = in(), w = in();
  int x = 0, y = my;
  long long bx = -1, by = -1;
  long long ans = 0, best = 1e10;
  for (int i = 1; i <= my; i++) upd(1, i);
  while (x <= mx && y >= 1) {
    if (ans >= w && x * y < best) bx = x, by = y, best = x * y;
    if (ans < w) {
      x++;
      upd(0, x);
      ans += Mapy[(double)x / (double)rev(x)];
    } else if (ans >= w) {
      ans -= Mapx[(double)y / (double)rev(y)];
      del(1, y);
      y--;
    }
  }
  if (bx == -1)
    printf("-1\n");
  else
    cout << bx << " " << by << endl;
  return 0;
}
