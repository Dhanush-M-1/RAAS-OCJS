#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000;
vector<int> p[maxn + 10];
map<int, int> l[maxn + 10], r[maxn + 10];
int pre[maxn + 10];
map<map<int, int>, int> s1, s2;
void prepare() {
  memset(pre, 0, sizeof(pre));
  for (int i = 2; i <= maxn; ++i)
    if (!pre[i]) {
      pre[i] = i;
      for (int j = i + i; j <= maxn; j += i) pre[j] = i;
    }
  for (int i = 2; i <= maxn; ++i) {
    if (pre[i]) p[i] = p[i / pre[i]];
    p[i].push_back(pre[i]);
  }
  map<int, int> tmp;
  for (int i = 1; i <= maxn; ++i) {
    int j = 0, k = i;
    while (k) {
      j = j * 10 + k % 10;
      k /= 10;
    }
    tmp.clear();
    for (int k = 0; k != p[i].size(); ++k) ++tmp[p[i][k]];
    for (int k = 0; k != p[j].size(); ++k) --tmp[p[j][k]];
    for (map<int, int>::iterator iter = tmp.begin(); iter != tmp.end(); ++iter)
      if (iter->second != 0) l[i][iter->first] = iter->second;
    tmp.clear();
    for (int k = 0; k != p[i].size(); ++k) --tmp[p[i][k]];
    for (int k = 0; k != p[j].size(); ++k) ++tmp[p[j][k]];
    for (map<int, int>::iterator iter = tmp.begin(); iter != tmp.end(); ++iter)
      if (iter->second != 0) r[i][iter->first] = iter->second;
  }
}
int main() {
  prepare();
  int maxx, maxy, w;
  cin >> maxx >> maxy >> w;
  for (int i = 1; i <= maxx; ++i) ++s1[l[i]];
  long long retx = 0, rety = 0;
  long long cnt = 0;
  for (long long i = maxx, j = 0; i > 0; --i) {
    while (j < maxy && cnt < w) {
      ++j;
      cnt += s1[r[j]];
      ++s2[r[j]];
    }
    if (cnt < w) break;
    if (i * j < retx * rety || retx * rety < w) {
      retx = i;
      rety = j;
    }
    cnt -= s2[l[i]];
    --s1[l[i]];
  }
  if (retx * rety < w)
    cout << -1;
  else
    cout << retx << " " << rety;
  return 0;
}
