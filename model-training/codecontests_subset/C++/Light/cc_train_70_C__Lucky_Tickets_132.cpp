#include <bits/stdc++.h>
using namespace std;
const int Maxn = 100 * 1000 + 10;
map<long double, pair<int, int> > mp;
int rev[Maxn];
int w, m, n;
long long mn = 1ll << 60;
pair<int, int> ret;
void Rev();
map<long double, pair<int, int> >::iterator it;
int main() {
  cin >> n >> m >> w;
  Rev();
  for (int i = 1; i <= n; i++) mp[(long double)i / rev[i]].first++;
  int p = 0, sum = 0;
  for (int i = n; i > 0; i--) {
    while (sum < w && p <= m) {
      p++;
      it = mp.find((long double)rev[p] / p);
      if (it != mp.end()) {
        sum += (*it).second.first;
        (*it).second.second++;
      }
    }
    if (p < m + 1 && mn > (long long)i * p)
      mn = (long long)i * p, ret = pair<int, int>(i, p);
    it = mp.find((long double)i / rev[i]);
    if (it != mp.end()) {
      sum -= (*it).second.second;
      (*it).second.first--;
      if (!(*it).second.first) mp.erase(it);
    }
  }
  if (mn == 1ll << 60)
    cout << -1 << endl;
  else
    cout << ret.first << " " << ret.second << endl;
  return 0;
}
void Rev() {
  for (int i = 1; i <= max(n, m); i++) {
    int t = i;
    while (t) {
      rev[i] *= 10;
      rev[i] += t % 10;
      t /= 10;
    }
  }
}
