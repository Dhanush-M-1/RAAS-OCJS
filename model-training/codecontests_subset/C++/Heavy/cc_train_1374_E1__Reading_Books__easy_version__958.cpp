#include <bits/stdc++.h>
using namespace std;
long long int a, b, c, d, e, f = 5 * 1e9, m11[200000], m01[200000], m10[200000],
                             k, k1, k2;
int main() {
  cin >> a >> b;
  for (int i = 0; i < a; i++) {
    cin >> c >> d >> e;
    if (e == 1 && d == 1) m11[k] = c, k++;
    if (d == 1 && e == 0) m10[k1] = c, k1++;
    if (d == 0 && e == 1) m01[k2] = c, k2++;
  }
  sort(m11, m11 + k);
  sort(m10, m10 + k1);
  sort(m01, m01 + k2);
  if (k + min(k1, k2) < b) {
    cout << -1;
    return 0;
  }
  for (int i = 1; i < max(max(k, k1), k2); i++) {
    m11[i] += m11[i - 1];
    m01[i] += m01[i - 1];
    m10[i] += m10[i - 1];
  }
  for (int i = 0; i < min(b, k); i++) {
    if (b - 2 - i < min(k1, k2))
      f = min(m11[i] + m01[b - 2 - i] + m10[b - 2 - i], f);
  }
  if (k >= b) f = min(f, m11[b - 1]);
  if (min(k1, k2) >= b) f = min(m01[b - 1] + m10[b - 1], f);
  cout << f;
}
