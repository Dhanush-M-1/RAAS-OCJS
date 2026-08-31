#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:32000000")
using namespace std;
const double pi = 3.1415926535897932384626433832795;
template <class T>
inline T Sqr(const T &x) {
  return x * x;
}
template <class T>
inline T Abs(const T &x) {
  return x >= 0 ? x : -x;
}
template <class T>
T gcd(T x, T y) {
  return y == 0 ? x : gcd(y, x % y);
}
pair<int, int> calc(int x) {
  int t = x, rev = 0;
  while (t) {
    int d = t % 10;
    t /= 10;
    rev = rev * 10 + d;
  }
  int g = gcd(x, rev);
  return make_pair(x / g, rev / g);
}
pair<int, int> rev(pair<int, int> t) { return make_pair(t.second, t.first); }
map<pair<int, int>, int> m;
vector<int> nums[200000];
int q;
int getid(pair<int, int> x) {
  if (m.find(x) == m.end()) {
    m[x] = q++;
  }
  return m[x];
}
void solve() {
  for (int i = 1; i <= 100000; i++) nums[getid(calc(i))].push_back(i);
  int mx, my, w;
  scanf("%d%d%d", &mx, &my, &w);
  multiset<int> ms;
  long long rescnt = 1ll << 60;
  int resx = -1, resy = 1000000, cury = my + 1;
  for (int i = 1; i <= mx; i++) {
    int idx = getid(rev(calc(i)));
    for (int j = 0; j < (nums[idx]).size(); j++)
      if (nums[idx][j] < cury) ms.insert(nums[idx][j]);
    if (ms.size() >= w) {
      while (ms.size() > w) ms.erase(--ms.end());
      int cury = *(--ms.end());
      if (i * (long long)cury < rescnt) {
        rescnt = i * (long long)cury;
        resx = i;
        resy = cury;
      }
    }
  }
  if (resx == -1)
    cout << -1;
  else
    printf("%d %d", resx, resy);
}
int main() {
  solve();
  return 0;
}
