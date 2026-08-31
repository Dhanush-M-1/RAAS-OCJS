#include <bits/stdc++.h>
using namespace std;
const int M = 1e2 + 100;
const int N = 2e3 + 100;
const int INF = 0x3f3f3f3f;
const int mod = 1e9 + 7;
long long n, m, t, k, x, y;
vector<long long> ab, bb, abb;
void slove() {
  scanf("%lld%lld", &n, &k);
  ab.clear(), bb.clear(), abb.clear();
  for (int i = 0; i < n; i++) {
    long long t, a, b;
    scanf("%lld%lld%lld", &t, &a, &b);
    if (a && b)
      abb.push_back(t);
    else if (a)
      ab.push_back(t);
    else if (b)
      bb.push_back(t);
  }
  sort(ab.begin(), ab.end(), greater<int>());
  sort(bb.begin(), bb.end(), greater<int>());
  long long ans = 0;
  while (ab.size() && bb.size()) {
    abb.push_back(ab.back() + bb.back());
    ab.pop_back(), bb.pop_back();
  }
  sort(abb.begin(), abb.end());
  if (abb.size() < k)
    ans = -1;
  else
    for (int i = 0; i < k; i++) ans += abb[i];
  printf("%lld\n", ans);
  return;
}
int main() {
  int T = 1;
  while (T--) {
    slove();
  }
  return 0;
}
