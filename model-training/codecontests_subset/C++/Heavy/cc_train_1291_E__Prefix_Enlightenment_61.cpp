#include <bits/stdc++.h>
using namespace std;
const long long MX = 1e6, INF = 1e9 + 10;
vector<long long> v[MX];
long long par[MX], s0[MX], s1[MX], col[MX], ans = 0;
pair<long long, long long> GETPAR(long long v) {
  if (par[v] == v) return {v, 0};
  pair<long long, long long> ans = GETPAR(par[v]);
  return {par[v] = ans.first, col[v] ^= ans.second};
}
void MERGE(long long a, long long b, long long stt) {
  pair<long long, long long> u = GETPAR(a), v = GETPAR(b);
  if (u.first == v.first) return;
  ans -= min(s0[u.first], s1[u.first]) + min(s0[v.first], s1[v.first]);
  if (stt ^ u.second ^ v.second) {
    swap(s0[v.first], s1[v.first]);
    col[v.first] = 1;
  }
  par[v.first] = u.first;
  s0[u.first] += s0[v.first];
  s1[u.first] += s1[v.first];
  ans += min(s0[u.first], s1[u.first]);
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, k;
  string s;
  cin >> n >> k >> s;
  for (long long i = 0; i < k; i++) {
    s0[i] = 1;
    par[i] = i;
    long long l;
    cin >> l;
    while (l--) {
      long long x;
      cin >> x;
      x--;
      v[x].push_back(i);
    }
  }
  for (long long i = 0; i < n; i++) {
    if (v[i].size() == 1) {
      par[i + k] = i + k;
      s0[i + k] = INF;
      MERGE(v[i][0], i + k, s[i] == '0');
    }
    if (v[i].size() == 2) MERGE(v[i][0], v[i][1], s[i] == '0');
    cout << ans << endl;
  }
  return 0;
}
