#include <bits/stdc++.h>
using namespace std;
int s[200000], m[200000], n[200000];
int main() {
  long long ans = 0;
  int f, k, t[200000], a[200000], b[200000], i, count = 0;
  int g = 0, h = 0;
  cin >> f >> k;
  for (i = 0; i < f; i++) {
    cin >> t[i] >> a[i] >> b[i];
    if (a[i] == 1 && b[i] == 1) {
      s[count] = t[i];
      count++;
    }
    if (a[i] == 0 && b[i] == 1) {
      n[h] = t[i];
      h++;
    }
    if (a[i] == 1 && b[i] == 0) {
      m[g] = t[i];
      g++;
    }
  }
  int l = min(g, h);
  sort(n, n + h);
  sort(m, m + g);
  for (i = count; i < (count + l); i++) s[i] = n[i - count] + m[i - count];
  sort(s, s + count + l);
  if (count + l < k)
    cout << -1;
  else {
    for (i = 0; i < k; i++) ans += s[i];
    cout << ans;
  }
  return 0;
}
