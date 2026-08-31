#include <bits/stdc++.h>
using namespace std;
using Int = int64_t;
vector<Int> csum(vector<Int>& v) {
  vector<Int> r(v.size());
  copy(v.begin(), v.end(), r.begin());
  for (int i = 1; i < r.size(); ++i) r[i] += r[i - 1];
  return r;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  Int N, K;
  cin >> N >> K;
  vector<Int> v, u, cmn;
  while (N--) {
    Int a, b, c;
    cin >> c >> a >> b;
    if (a + b == 0) continue;
    ;
    if (a + b == 2)
      cmn.emplace_back(c);
    else if (a == 1)
      v.emplace_back(c);
    else
      u.emplace_back(c);
  }
  sort(v.begin(), v.end());
  sort(u.begin(), u.end());
  sort(cmn.begin(), cmn.end());
  auto cv = csum(v);
  auto cu = csum(u);
  auto ccmn = csum(cmn);
  Int ans = 1LL << 60;
  if (v.size() >= K && u.size() >= K) {
    ans = cv[K - 1] + cu[K - 1];
  }
  if (cmn.size() >= K) ans = min(ans, ccmn[K - 1]);
  for (int i = 0; i < cmn.size(); ++i) {
    if (K - i - 2 < 0) continue;
    if (v.size() > K - i - 2 && u.size() > K - 2 - i) {
      ans = min(ans, cv[K - i - 2] + cu[K - i - 2] + ccmn[i]);
    }
  }
  cout << (ans == 1LL << 60 ? -1 : ans) << endl;
}
