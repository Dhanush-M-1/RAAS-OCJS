#include <bits/stdc++.h>
using namespace std;
const int N = 220000;
map<int, int> H;
int inv[N];
void build(int st, int en, int k) {
  if (k == 1) {
    int len = en - st + 1;
    if (H.count(len))
      H[len]++;
    else
      H[len] = 1;
    return;
  }
  if (st == en) return;
  int mid = st + en >> 1;
  build(st, mid, k - 1);
  build(mid + 1, en, k - 1);
}
int main() {
  ios_base::sync_with_stdio(0);
  int n, k, mod;
  cin >> n >> k >> mod;
  build(1, n, k);
  if (!H.size() || (H.size() == 1 && H.begin()->first == 1)) {
    cout << 0 << endl;
    return 0;
  }
  inv[1] = 1;
  for (int i = 2; i < N; i++)
    inv[i] = (long long)inv[mod % i] * (mod - mod / i) % mod;
  int ans = 0;
  if (H.size() == 1) {
    int len = H.begin()->first, cnt = H.begin()->second;
    ans = (long long)len * (len - 1) % mod * inv[4] % mod * cnt % mod;
    if (cnt > 1) {
      int now = 0, nn = 0;
      for (int sum = 2; sum <= len + len; sum++) {
        int st = max(1, sum - len), en = min(len, sum - 1);
        nn = en - st + 1;
        now += (long long)((inv[2] - inv[sum] + mod) % mod) * nn % mod;
        if (now >= mod) now -= mod;
      }
      now = (long long)now * cnt % mod * (cnt - 1) % mod * inv[2] % mod;
      (ans += now) >= mod && (ans -= mod);
    }
  } else {
    int len = H.begin()->first, cnt = H.begin()->second;
    ans = (long long)len * (len - 1) % mod * inv[4] % mod * cnt % mod;
    if (cnt > 1) {
      int now = 0, nn = 0;
      for (int sum = 2; sum <= len + len; sum++) {
        int st = max(1, sum - len), en = min(len, sum - 1);
        nn = en - st + 1;
        now += (long long)((inv[2] - inv[sum] + mod) % mod) * nn % mod;
        if (now >= mod) now -= mod;
      }
      now = (long long)now * cnt % mod * (cnt - 1) % mod * inv[2] % mod;
      (ans += now) >= mod && (ans -= mod);
    }
    map<int, int>::iterator it = H.begin();
    it++;
    len = it->first, cnt = it->second;
    ans += (long long)len * (len - 1) % mod * inv[4] % mod * cnt % mod;
    if (ans >= mod) ans -= mod;
    if (cnt > 1) {
      int now = 0, nn = 0;
      for (int sum = 2; sum <= len + len; sum++) {
        int st = max(1, sum - len), en = min(len, sum - 1);
        nn = en - st + 1;
        now += (long long)((inv[2] - inv[sum] + mod) % mod) * nn % mod;
        if (now >= mod) now -= mod;
      }
      now = (long long)now * cnt % mod * (cnt - 1) % mod * inv[2] % mod;
      (ans += now) >= mod && (ans -= mod);
    }
    int len1 = H.begin()->first, len2 = it->first;
    int cnt1 = H.begin()->second, cnt2 = it->second;
    int now = 0, nn = 0;
    for (int sum = 2; sum <= len1 + len2; sum++) {
      int st = max(1, sum - len2), en = min(len1, sum - 1);
      nn = en - st + 1;
      now += (long long)((inv[2] - inv[sum] + mod) % mod) * nn % mod;
      if (now >= mod) now -= mod;
    }
    now = (long long)now * cnt1 % mod * cnt2 % mod;
    (ans += now) >= mod && (ans -= mod);
  }
  cout << ans << endl;
  return 0;
}
