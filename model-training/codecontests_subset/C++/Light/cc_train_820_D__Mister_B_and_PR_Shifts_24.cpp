#include <bits/stdc++.h>
using namespace std;
int n;
int main(void) {
  cin >> n;
  vector<int> p(n);
  for (int i = (0); i < (n); i++) scanf("%d", &p[i]), p[i]--;
  vector<long long> t(n + 1);
  long long ch = 0;
  long long d = 0;
  for (int i = (0); i < (n); i++) {
    t[(p[i] - i + n) % n]++;
    if (p[i] > i)
      ch--;
    else
      ch++;
    d += abs(p[i] - i);
  }
  long long mk = 0;
  long long m = 1e18;
  t[n] = t[0];
  t[0] = 1;
  long long j = ch, l = d;
  for (int k = (0); k < (n + 1); k++) {
    if (k) d += ch - abs(n - 1 - p[n - k]) + abs(p[n - k]) - 1;
    if (d < m) m = d, mk = k;
    ch += 2 * t[k] - 2;
    if (k == n) assert(j == ch && l == d);
  }
  printf("%lld %lld\n", m, mk);
}
