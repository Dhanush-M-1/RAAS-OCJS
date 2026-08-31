#include <bits/stdc++.h>
#pragma GCC optimize(2)
#pragma GCC optimize(3)
#pragma GCC optimize("Ofast")
using namespace std;
namespace ywy {
unordered_map<int, int> mp;
long long inv[200001], ans = 0;
int p;
inline void solve(int a, int b) {
  long long cjr = a;
  cjr *= b;
  cjr %= p;
  cjr *= mp[a];
  cjr %= p;
  cjr *= mp[b];
  cjr %= p;
  ans = (ans + cjr * inv[2]) % p;
  for (register int i = 2; i <= a + b; i++) {
    long long l = max(1, i - b), r = min(i - 1, a);
    if (l > r) continue;
    cjr = p - inv[i];
    cjr *= (r - l + 1);
    cjr %= p;
    cjr *= mp[a];
    cjr %= p;
    cjr *= mp[b];
    ans = (ans + cjr) % p;
  }
}
void digui(int l, int r, int h) {
  if (h <= 1) {
    mp[r - l + 1]++;
    return;
  }
  if (l == r) return;
  int mid = (l + r) >> 1;
  digui(l, mid, h - 1);
  digui(mid + 1, r, h - 1);
}
void ywymain() {
  int n, k;
  cin >> n >> k >> p;
  inv[0] = inv[1] = 1;
  for (register int i = 2; i <= 100000; i++)
    inv[i] = (inv[p % i] * (p - p / i)) % p;
  digui(1, n, k);
  for (unordered_map<int, int>::iterator i = mp.begin(); i != mp.end(); i++) {
    long long cjr = i->first - 1;
    cjr *= i->first;
    cjr %= p;
    cjr *= i->second;
    cjr %= p;
    ans = (ans + cjr * inv[4]) % p;
    cjr = inv[2];
    cjr *= (i->second - 1);
    cjr %= p;
    cjr *= i->second;
    cjr %= p;
    for (register int j = 2; j <= i->first * 2; j++) {
      long long l = max(1, j - i->first), r = min(j - 1, i->first);
      if (l > r) continue;
      long long h = p - inv[j];
      h *= cjr;
      h %= p;
      h *= (r - l + 1);
      h %= p;
      ans = (ans + h) % p;
    }
    cjr *= inv[2];
    cjr %= p;
    cjr *= i->first;
    cjr %= p;
    cjr *= i->first;
    ans = (ans + cjr) % p;
  }
  for (unordered_map<int, int>::iterator i = mp.begin(); i != mp.end(); i++) {
    unordered_map<int, int>::iterator j = i;
    j++;
    for (; j != mp.end(); j++) solve(i->first, j->first);
  }
  cout << ans << endl;
}
}  // namespace ywy
int main() {
  ywy::ywymain();
  return (0);
}
