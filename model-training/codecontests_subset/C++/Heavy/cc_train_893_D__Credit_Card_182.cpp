#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 2, oo = 1e9;
int n, a[N], ma[N], b[N];
long long lim;
void err() {
  cout << -1;
  exit(0);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> lim;
  for (int i = 1; i <= n; i++) cin >> a[i], b[i] = b[i - 1] + a[i];
  ma[n] = -oo;
  for (int i = n - 1; i > 0; i--) ma[i] = max(ma[i + 1], b[i + 1]);
  long long acc = 0;
  long long s = 0;
  int cnt = 0;
  for (int i = 1; i <= n; i++)
    if (a[i] != 0) {
      acc += a[i];
      if (acc > lim) err();
    } else if (acc < 0) {
      cnt++;
      long long delta = min(lim - (ma[i] + s), lim - acc);
      acc += delta;
      s += delta;
      if (acc < 0) err();
    }
  cout << cnt;
}
