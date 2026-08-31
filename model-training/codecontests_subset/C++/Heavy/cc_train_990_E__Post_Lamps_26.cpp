#include <bits/stdc++.h>
using namespace std;
long long n, m, k, i, j, nr, rez, x, prec;
bool b, S[1000005];
int A[1000005], Prv[1000005];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (i = 1; i <= m; i++) {
    cin >> x;
    S[x] = 1;
  }
  if (S[0] == 1) {
    cout << "-1\n";
    return 0;
  }
  for (i = 1; i <= n; i++) {
    if (S[i] == 0)
      Prv[i] = i;
    else
      Prv[i] = Prv[i - 1];
  }
  for (i = 1; i <= k; i++) cin >> A[i];
  rez = 1000000000000000LL;
  if (m == 0) rez = min(rez, 1LL * A[1] * n);
  for (i = 2; i <= k; i++) {
    b = 1;
    nr = 0;
    prec = 0;
    for (j = i; j < n; j += i) {
      if (S[j] == 1) {
        if (prec == Prv[j]) {
          b = 0;
          break;
        }
        j = Prv[j];
      }
      nr++;
      prec = j;
    }
    nr++;
    if (b == 1) rez = min(rez, 1LL * A[i] * nr);
  }
  if (rez != 1000000000000000LL)
    cout << rez << "\n";
  else
    cout << "-1\n";
  return 0;
}
