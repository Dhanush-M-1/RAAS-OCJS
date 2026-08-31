#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mx, my;
int rev(int n) {
  int res = 0;
  while (n) {
    int p = n % 10;
    res = res * 10 + p;
    n /= 10;
  }
  return res;
}
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main() {
  int maxx, maxy, w;
  cin >> maxx >> maxy >> w;
  for (int i = (1); i < (maxx + 1); ++i) {
    int rx = rev(i);
    int g = gcd(i, rx);
    mx[make_pair(i / g, rx / g)]++;
  }
  int oury = 0;
  long long ress = 0;
  long long best = 1000000000000000000ll;
  int ans1 = -1, ans2 = -1;
  for (int x = maxx; x > 0; --x) {
    bool f = false;
    while (oury <= maxy) {
      if (ress >= w) {
        f = true;
        break;
      }
      oury++;
      int ry = rev(oury);
      int g = gcd(oury, ry);
      my[make_pair(ry / g, oury / g)]++;
      ress += mx[make_pair(ry / g, oury / g)];
    }
    int rx = rev(x);
    int g = gcd(x, rx);
    ress -= my[make_pair(x / g, rx / g)];
    mx[make_pair(x / g, rx / g)]--;
    if (f) {
      if (oury * 1ll * x < best) {
        best = oury * 1ll * x;
        ans1 = x;
        ans2 = oury;
      }
    }
  }
  if (ans1 == -1)
    printf("-1\n");
  else
    printf("%d %d\n", ans1, ans2);
  return 0;
}
