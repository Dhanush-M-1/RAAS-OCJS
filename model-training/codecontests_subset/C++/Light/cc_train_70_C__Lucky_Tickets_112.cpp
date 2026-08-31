#include <bits/stdc++.h>
using namespace std;
const int Maxn = 100 * 1000 + 10;
map<pair<int, int>, pair<int, int> > mp;
int GCD(int a, int b);
int rev[Maxn];
int gcd[Maxn];
int w, m, n;
long long mn = 1ll << 60;
pair<int, int> ret;
void Rev(int);
map<pair<int, int>, pair<int, int> >::iterator it;
int main() {
  cin >> n >> m >> w;
  for (int i = 1; i <= max(m, n) + 1; i++) {
    Rev(i);
    gcd[i] = GCD(i, rev[i]);
  }
  for (int i = 1; i <= n; i++)
    mp[pair<int, int>(i / gcd[i], rev[i] / gcd[i])].first++;
  int p = 0, sum = 0;
  for (int i = n; i > 0; i--) {
    while (sum < w && p <= m) {
      p++;
      it = mp.find(pair<int, int>(rev[p] / gcd[p], p / gcd[p]));
      if (it != mp.end()) {
        sum += (*it).second.first;
        (*it).second.second++;
      }
    }
    if (p < m + 1 && mn > (long long)i * p)
      mn = (long long)i * p, ret = pair<int, int>(i, p);
    it = mp.find(pair<int, int>(i / gcd[i], rev[i] / gcd[i]));
    if (it != mp.end()) {
      sum -= (*it).second.second;
      (*it).second.first--;
      if ((*it).second.first == 0) mp.erase(it);
    }
  }
  if (mn == 1ll << 60)
    cout << -1 << endl;
  else
    cout << ret.first << " " << ret.second << endl;
  return 0;
}
void Rev(int i) {
  int t = i;
  while (t) {
    rev[i] *= 10;
    rev[i] += t % 10;
    t /= 10;
  }
}
int GCD(int a, int b) {
  if (b > a) swap(b, a);
  return b ? GCD(b, a % b) : a;
}
