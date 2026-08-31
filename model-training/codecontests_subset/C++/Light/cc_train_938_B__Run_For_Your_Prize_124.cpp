#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 20;
const int MID = 5e5;
int a[MAXN];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  sort(a, a + n);
  int t = upper_bound(a, a + n, MID) - a;
  int t1, t2;
  if (t - 1 >= 0)
    t1 = a[t - 1] - 1;
  else
    t1 = 0;
  if (t < n && a[t] >= MID)
    t2 = 1e6 - a[t];
  else
    t2 = 0;
  cout << max(t1, t2) << endl;
  return 0;
}
