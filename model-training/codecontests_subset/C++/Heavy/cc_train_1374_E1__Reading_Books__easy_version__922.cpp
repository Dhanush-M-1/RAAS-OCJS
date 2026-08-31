#include <bits/stdc++.h>
const long long INF = LLONG_MAX / 2;
const long long N = 2e5 + 1;
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t;
  t = 1;
  while (t--) {
    long long n, k;
    std::cin >> n >> k;
    long long sum = 0, pp = 0, i, ta[n], a[n], b[n], a1[n], j = 0, m = 0, l = 0,
              b1[n], ab[n], ak = k, bk = k, j1 = 0, m1 = 0, l1 = 0;
    for (long long i = 0; i < n; i++) {
      std::cin >> ta[i] >> a[i] >> b[i];
      if (a[i] == 1 && b[i] == 1)
        ab[j++] = ta[i];
      else if (a[i] == 1)
        a1[m++] = ta[i];
      else if (b[i] == 1)
        b1[l++] = ta[i];
      else
        pp++;
    }
    if (l + j < k || m + j < k) {
      cout << "-1\n";
      continue;
    }
    if (j > 1) sort(ab, ab + j);
    if (m > 1) sort(a1, a1 + m);
    if (l > 1) sort(b1, b1 + l);
    for (;;) {
      if (ak == 0 || bk == 0) break;
      if ((j1 >= j) || (m1 < m && l1 < l && a1[m1] + b1[l1] < ab[j1])) {
        sum += a1[m1] + b1[l1];
        ak--, bk--;
        m1++, l1++;
      } else {
        sum += ab[j1];
        ak--, bk--;
        j1++;
      }
      if (ak == 0 || bk == 0) break;
    }
    cout << sum << "\n";
  }
}
