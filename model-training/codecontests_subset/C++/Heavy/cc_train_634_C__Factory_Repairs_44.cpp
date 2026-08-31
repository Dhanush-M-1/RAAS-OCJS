#include <bits/stdc++.h>
using namespace std;
template <typename T>
T sqr(T x) {
  return x * x;
}
const int maxn = 200003;
int arr[maxn];
int fa[maxn], fb[maxn];
void inc(int *f, int r, int val) {
  for (; r < maxn; r = (r | (r + 1))) f[r] += val;
}
int sum(int *f, int r) {
  int ans = 0;
  for (; r >= 0; r = (r & (r + 1)) - 1) ans += f[r];
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int type;
    cin >> type;
    if (type == 1) {
      int di, ai;
      cin >> di >> ai;
      inc(fa, di, min(ai, max(0, a - arr[di])));
      inc(fb, di, min(ai, max(0, b - arr[di])));
      arr[di] += ai;
    } else {
      int pi;
      cin >> pi;
      int ans = sum(fb, pi - 1) + sum(fa, n) - sum(fa, pi + k - 1);
      cout << ans << "\n";
    }
  }
  return 0;
}
