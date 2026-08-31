#include <bits/stdc++.h>
using namespace std;
const int E = 1e6;
const int F = 1;
int n, a[E], ans;
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) ans = max(ans, min(E - a[i], a[i] - F));
  return cout << ans, 0;
}
