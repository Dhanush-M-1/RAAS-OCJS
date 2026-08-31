#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10, eps = 1e-10;
int n;
long long a[N];
long long tree[N];
int ans[N];
long long sum(int x) {
  long long res = 0;
  while (x) {
    res += tree[x];
    x -= (x & (-x));
  }
  return res;
}
void add(int x, long long sum) {
  while (x <= n) {
    tree[x] += sum;
    x += (x & (-x));
  }
  return;
}
int main() {
  std::ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = (1); i < (n + 1); ++i) cin >> a[i], add(i + 1, i);
  for (int i = (n); i >= (1); --i) {
    long long l = 1, r = n;
    while (l < r) {
      int m = (l + r + 1) / 2;
      if (sum(m) <= a[i])
        l = m;
      else
        r = m - 1;
    }
    ans[i] = r;
    add(r + 1, -r);
  }
  for (int i = (1); i < (n + 1); ++i) cout << ans[i] << " ";
  return 0;
}
