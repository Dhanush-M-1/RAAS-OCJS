#include <bits/stdc++.h>
using namespace std;
int n, m;
long long inf = round(1e18);
long long inf1 = round(1e9);
struct zapros {
  int op, x, y;
  long long ss;
};
vector<zapros> vv;
long long aa[5555];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) aa[i] = inf;
  for (int i = 0; i < m; i++) {
    zapros zz;
    cin >> zz.op >> zz.x >> zz.y >> zz.ss;
    zz.x--;
    zz.y--;
    vv.push_back(zz);
  }
  for (int i = vv.size() - 1; i >= 0; i--) {
    zapros zz = vv[i];
    if (zz.op == 1) {
      for (int j = zz.x; j <= zz.y; j++) aa[j] -= zz.ss;
    }
    if (zz.op == 2) {
      for (int j = zz.x; j <= zz.y; j++)
        if (aa[j] > zz.ss) aa[j] = zz.ss;
    }
  }
  long long check[5555];
  for (int i = 0; i < n; i++) {
    if (aa[i] == inf) aa[i] -= inf + inf1;
    if (aa[i] > inf1) aa[i] -= inf;
    check[i] = aa[i];
  }
  for (int i = 0; i < m; i++) {
    zapros zz = vv[i];
    if (zz.op == 1) {
      for (int j = zz.x; j <= zz.y; j++) check[j] += zz.ss;
      continue;
    }
    if (zz.op == 2) {
      int my_max = check[zz.x];
      for (int j = zz.x; j <= zz.y; j++)
        if (check[j] > my_max) my_max = check[j];
      if (my_max != zz.ss) {
        cout << "NO";
        return 0;
      }
      continue;
    }
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) cout << aa[i] << " ";
  return 0;
}
