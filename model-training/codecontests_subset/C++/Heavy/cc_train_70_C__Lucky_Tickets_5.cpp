#include <bits/stdc++.h>
using namespace std;
double const pi = 3.1415926535897932384626433832795;
int const inf = (int)1e9;
long long const inf64 = (long long)2e18;
const string name = "c";
int maxx, maxy, w, calc[100010], pal[100010];
vector<int> ans[100010], qqq[100010];
int rev(int n) {
  int res = 0;
  while (n > 0) {
    res = res * 10 + n % 10;
    n /= 10;
  }
  return res;
}
int find(int w) {
  int d = 2, ww = calc[w];
  while (d * d <= w) {
    while (w % d == 0) {
      if (ww % d == 0) ww /= d;
      w /= d;
    }
    d++;
  }
  if (ww % w == 0) ww /= w;
  return ww;
}
int main() {
  cin >> maxx >> maxy >> w;
  for (int i = 0; i < (int)max(maxx, maxy) + 1; i++) calc[i] = rev(i);
  memset(pal, 0, sizeof(pal));
  for (int i = 0; i < (int)max(maxx, maxy) + 1; i++)
    if (calc[i] == i) pal[i] = 1;
  int now, st;
  for (int i = 1; i <= maxx; ++i) {
    st = find(i);
    now = st;
    while (now <= maxy) {
      if ((long long)i * now == (long long)calc[i] * calc[now])
        ans[i].push_back(now), qqq[now].push_back(i);
      now += st;
    }
  }
  long long ansx = 100001, ansy = 100001, lvl = 1;
  now = 0;
  for (int i = maxx; i >= 1; i--) {
    while (lvl <= maxy && now < w) now += qqq[lvl++].size();
    if (now >= w && (long long)i * (lvl - 1) < ansx * ansy)
      ansx = i, ansy = lvl - 1;
    for (int j = 0; j < (int)ans[i].size(); j++) {
      if (ans[i][j] < lvl) now--;
      qqq[ans[i][j]].resize(qqq[ans[i][j]].size() - 1);
    }
  }
  if (ansx > maxx)
    cout << -1 << endl;
  else
    cout << ansx << " " << ansy << endl;
  return 0;
}
