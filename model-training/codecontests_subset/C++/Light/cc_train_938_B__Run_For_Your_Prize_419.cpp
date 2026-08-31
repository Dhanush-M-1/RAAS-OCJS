#include <bits/stdc++.h>
using namespace std;
const int Nmax = 100000 + 5;
int n;
int a[Nmax];
int main() {
  cin >> n;
  int t = 0;
  for (int i = 1; i <= n; ++i) cin >> a[i];
  int ii = 1, jj = n, poz1 = 1, poz2 = 1000000;
  while (ii <= jj) {
    if (abs(poz1 - a[ii]) < abs(poz2 - a[jj]))
      t += abs(poz1 - a[ii]), poz2 -= abs(poz1 - a[ii]), poz1 = a[ii], ii++;
    else
      t += abs(poz2 - a[jj]), poz1 += abs(poz2 - a[jj]), poz2 = a[jj], jj--;
  }
  cout << t;
  return 0;
}
