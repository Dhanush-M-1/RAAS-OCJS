#include <bits/stdc++.h>
using namespace std;
long father[1010], tot[1010], s[1010];
bool f[1010];
long n, x, t, tots;
long find(const long h) {
  if (father[h] == h)
    return h;
  else
    return find(father[h]);
}
int main() {
  int i;
  cin >> n >> x;
  for (i = 1; i <= n; i++) {
    father[i] = i;
    tot[i] = 1;
  }
  for (i = 1; i <= n; i++) {
    cin >> t;
    if (t != 0) {
      father[i] = t;
      tot[find(i)] += tot[i];
    }
  }
  tot[find(x)] = 0;
  for (i = 1; i <= n; i++)
    if (father[i] == i) s[++tots] = tot[i];
  i = x;
  t = 1;
  while (father[i] != i) {
    i = father[i];
    t++;
  }
  memset(f, 0, sizeof(f));
  f[t] = true;
  for (i = 1; i <= tots; i++) {
    for (long j = n; j >= s[i]; j--) {
      f[j] = f[j] || f[j - s[i]];
    }
  }
  for (int i = 1; i <= n; i++)
    if (f[i]) cout << i << endl;
  return 0;
}
