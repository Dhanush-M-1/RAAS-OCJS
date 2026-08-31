#include <bits/stdc++.h>
#pragma GCC optimize "-O3"
using namespace std;
long long MOD;
long long pw(long long a, long long b) {
  long long ans = 1;
  while (b) {
    while (!(b & 1)) b >>= 1, a = (a * a) % MOD;
    ans = (ans * a) % MOD, --b;
  }
  return ans;
}
map<int, int> mm;
void run(int n, int k) {
  if (n <= 0) return;
  if (n == 1) {
    ++mm[1];
    return;
  }
  if (k <= 1) {
    ++mm[n];
    return;
  }
  int n2 = n / 2;
  run(n2, k - 1);
  run(n - n2, k - 1);
}
long long n, k;
long long get(int a, int b) {
  if (a > b) swap(a, b);
  long long ans = 0;
  for (int i = 0; i <= (a - 1) + (b - 1); ++i) {
    long long cnt = 0;
    if (i < a)
      cnt = i + 1;
    else if (i < b)
      cnt = a;
    else
      cnt = i + 1 - (i + 1 - a) - (i + 1 - b);
    ans = (ans + cnt * pw(i + 2, MOD - 2)) % MOD;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n >> k >> MOD;
  run(n, k);
  vector<pair<int, long long>> vv;
  for (auto x : mm) vv.push_back(x);
  long long ans = n * (n - 1) * pw(4, MOD - 2);
  long long sum = 0;
  for (int i = 0; i < vv.size(); ++i) {
    long long go = get(vv[i].first, vv[i].first);
    sum = (sum + go * vv[i].second % MOD * (vv[i].second - 1) % MOD *
                     pw(2, MOD - 2)) %
          MOD;
    for (int j = i + 1; j < vv.size(); ++j)
      sum = (sum + get(vv[i].first, vv[j].first) * vv[i].second % MOD *
                       vv[j].second) %
            MOD;
  }
  ans = (ans - sum + MOD) % MOD;
  cout << ans << "\n";
  return 0;
}
