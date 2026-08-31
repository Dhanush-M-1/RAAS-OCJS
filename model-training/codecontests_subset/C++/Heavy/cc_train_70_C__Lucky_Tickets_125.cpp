#include <bits/stdc++.h>
using namespace std;
int maxx, maxy, w;
map<pair<int, int>, int> cntx, cnty;
int mcd(int a, int b) {
  int tmp;
  while (b != 0) {
    tmp = b;
    b = a % b;
    a = tmp;
  }
  return a;
}
int rev(int n) {
  int ret = 0;
  while (n > 0) {
    ret = 10 * ret + (n % 10);
    n /= 10;
  }
  return ret;
}
pair<int, int> mpair(int x, int rx) {
  int d = mcd(x, rx);
  return pair<int, int>(rx / d, x / d);
}
int main() {
  cin >> maxx >> maxy >> w;
  long long bestx = maxx, besty = maxy;
  cntx.clear();
  cnty.clear();
  for (int x = 1; x <= maxx; x++) cntx[mpair(x, rev(x))]++;
  long long y = 1, x = maxx;
  int cur_count = cntx[mpair(rev(1), 1)];
  cnty[mpair(rev(1), 1)]++;
  while (y < maxy && cur_count < w) {
    y++;
    cur_count += cntx[mpair(rev(y), y)];
    cnty[mpair(y, rev(y))]++;
  }
  if (y == maxy && cur_count < w) {
    cout << -1 << endl;
    return 0;
  }
  while (x >= 1 && y <= maxy) {
    while (x >= 1 && cur_count - cnty[mpair(rev(x), x)] >= w) {
      cntx[mpair(x, rev(x))]--;
      cur_count -= cnty[mpair(rev(x), x)];
      x--;
    }
    if (x * y < bestx * besty) {
      bestx = x;
      besty = y;
    }
    y++;
    if (y <= maxy) {
      cur_count += cntx[mpair(rev(y), y)];
      cnty[mpair(y, rev(y))]++;
    }
  }
  cout << bestx << " " << besty << endl;
  return 0;
}
