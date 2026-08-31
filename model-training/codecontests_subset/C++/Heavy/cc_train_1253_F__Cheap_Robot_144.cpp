#include <bits/stdc++.h>
using namespace std;
const long long MOD = (long long)1e9 + 7;
const long double PI = 3.141592653589793238462643383279502884197;
long long fac[1] = {1}, inv[1] = {1};
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long mp(long long a, long long b) {
  long long ret = 1;
  while (b) {
    if (b & 1) ret = ret * a % MOD;
    a = a * a % MOD;
    b >>= 1;
  }
  return ret;
}
long long cmb(long long r, long long c) {
  return fac[r] * inv[c] % MOD * inv[r - c] % MOD;
}
vector<pair<int, int>> ov[100000];
int p[100000];
int find(int a) {
  if (p[a] == -1) return a;
  return p[a] = find(p[a]);
}
void merge(int a, int b) {
  a = find(a);
  b = find(b);
  if (a == b) return;
  p[b] = a;
}
long long tdist[100000];
pair<int, int> lr[300000];
pair<int, int> qu[300000];
int wif[100000];
priority_queue<pair<long long, int>, vector<pair<long long, int>>,
               greater<pair<long long, int>>>
    pq;
struct edg {
  int u, v;
  long long co;
  bool operator<(const edg v2) const { return co < v2.co; };
};
int main() {
  memset(tdist, 0x3f, sizeof(tdist));
  int n, m, k, q;
  scanf("%d %d %d %d", &n, &m, &k, &q);
  int a, b, c;
  while (m--) {
    scanf("%d %d %d", &a, &b, &c);
    a--;
    b--;
    ov[a].push_back({c, b});
    ov[b].push_back({c, a});
  }
  for (int i = 0; i < k; i++) {
    pq.push({0, i});
    wif[i] = i;
    tdist[i] = 0;
  }
  pair<long long, int> tv;
  vector<edg> se;
  while (!pq.empty()) {
    tv = pq.top();
    pq.pop();
    if (tv.first != tdist[tv.second]) continue;
    for (pair<int, int> i : ov[tv.second]) {
      if (tdist[i.second] > tv.first + i.first) {
        tdist[i.second] = tv.first + i.first;
        pq.push({tv.first + i.first, i.second});
        wif[i.second] = wif[tv.second];
      }
      if (wif[i.second] != wif[tv.second]) {
        a = wif[i.second], b = wif[tv.second];
        if (a > b) swap(a, b);
        se.push_back({a, b, i.first + tv.first + tdist[i.second]});
      }
    }
  }
  sort((se).begin(), (se).end());
  memset(p, -1, sizeof(p));
  for (int i = 0; i < q; i++) {
    scanf("%d %d", &a, &b);
    lr[i] = {0, (int)(se).size() - 1};
    qu[i] = {a - 1, b - 1};
  }
  vector<pair<int, int>> v;
  for (int cnt = 0; cnt < 25; cnt++) {
    memset(p, -1, sizeof(p));
    v.clear();
    for (int i = 0; i < q; i++)
      if (lr[i].first <= lr[i].second)
        v.push_back({(lr[i].first + lr[i].second) >> 1, i});
    if (v.empty()) break;
    sort((v).begin(), (v).end());
    int l = 0;
    for (pair<int, int> i : v) {
      while (l < (int)(se).size() && se[i.first].co >= se[l].co) {
        merge(se[l].u, se[l].v);
        l++;
      }
      if (find(qu[i.second].first) == find(qu[i.second].second))
        lr[i.second].second = i.first - 1;
      else
        lr[i.second].first = i.first + 1;
    }
  }
  for (int i = 0; i < q; i++) printf("%lld\n", se[lr[i].first].co);
}
