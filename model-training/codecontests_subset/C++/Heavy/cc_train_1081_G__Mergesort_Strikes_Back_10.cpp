#include <bits/stdc++.h>
using namespace std;
vector<int> vec;
int n, k, q, cnt[100005];
inline int power(int a, int b) {
  int ans = 1;
  for (; b; a = 1LL * a * a % q, b >>= 1) ans = b & 1 ? 1LL * ans * a % q : ans;
  return ans;
}
inline int inv(int a) { return power(a, q - 2); }
void partition(int a, int b) {
  if (min(a, b) == 1) {
    if (!cnt[a]++) vec.push_back(a);
    return;
  }
  partition(a >> 1, --b);
  partition(a + 1 >> 1, b);
}
int main() {
  cin >> n >> k >> q;
  partition(n, k);
  int ans = 0;
  for (auto x : vec) {
    for (auto y : vec)
      if (x <= y) {
        int res = 1LL * x * y % q * inv(2) % q;
        for (int i = 2; i <= x + y; i++)
          (res += q - (i - max(i - x - 1, 0) - max(i - y - 1, 0) - 1LL) *
                          inv(i) % q) %= q;
        (ans += 1LL * res * cnt[x] % q *
                (x ^ y ? cnt[y] : (cnt[y] - 1LL) * inv(2) % q) % q) %= q;
      }
    (ans += (x - 1LL) * x % q * inv(4) % q * cnt[x] % q) %= q;
  }
  cout << ans;
}
