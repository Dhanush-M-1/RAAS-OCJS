#include <bits/stdc++.h>
using namespace std;
const int tinf = (int)1e9 + 7;
const long long inf = (long long)1e18 + 7;
const int N = 4e5 + 5;
long long d[2000001], r[2000001];
int main() {
  {
    ios ::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
  }
  long long n, m, k;
  cin >> n >> m >> k;
  long long second[m], a[k];
  for (int i = 0; i < m; i++) {
    cin >> second[i];
    d[second[i]] = 1;
  }
  for (int i = 0; i < k; i++) {
    cin >> a[i];
  }
  if (d[0]) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    if (d[i])
      d[i] = d[i - 1];
    else
      d[i] = i;
  }
  long long Min = inf;
  for (int i = 0; i < k; i++) {
    long long g = i + 1, l = 0, e = 0, c = -1, t = 0;
    while (l < n) {
      if (d[l] == c) {
        e = 1;
        break;
      } else
        c = d[l];
      if (l + g >= n) {
        t++;
        break;
      } else
        l = d[l + g], t++;
    }
    if (!e) {
      Min = min(Min, a[i] * t);
    }
  }
  if (Min == inf)
    cout << -1;
  else
    cout << Min;
}
