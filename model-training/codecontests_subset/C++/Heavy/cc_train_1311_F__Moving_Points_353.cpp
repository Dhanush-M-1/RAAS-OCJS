#include <bits/stdc++.h>
using namespace std;
const long long maxn = 500007;
long long n, C1[maxn], C2[maxn];
long long ans, p1[maxn], p2[maxn];
pair<long long, long long> fk[maxn];
bool cmp2(long long u, long long v) {
  if (fk[u].second < fk[v].second) {
    return 1;
  } else {
    if (fk[u].second == fk[v].second && fk[u].first > fk[v].first) return 1;
  }
  return 0;
}
long long lowbit(long long u) { return u & (-u); }
void update(long long u, long long w) {
  for (long long i = u; i <= n; i += lowbit(i)) C1[i] += w, C2[i] += 1;
}
pair<long long, long long> query(long long u) {
  long long ans = 0, ret = 0;
  for (long long i = u; i > 0; i -= lowbit(i)) ans += C1[i], ret += C2[i];
  return {ans, ret};
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> fk[i].second;
    p1[i] = i;
  }
  for (int i = 1; i <= n; ++i) {
    cin >> fk[i].first;
    p2[i] = i;
  }
  sort(fk + 1, fk + n + 1);
  sort(p1 + 1, p1 + n + 1, cmp2);
  for (int i = 1; i <= n; ++i) {
    p2[p1[i]] = i;
  }
  for (int i = 1; i <= n; ++i) {
    update(p2[i], fk[i].second);
    pair<long long, long long> ret = query(p2[i]);
    ans -= ret.first;
    ans += ret.second * fk[i].second;
  }
  cout << ans << endl;
}
