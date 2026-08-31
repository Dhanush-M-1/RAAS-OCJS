#include <bits/stdc++.h>
using namespace std;
int a[1000000 + 9];
long long d[1000000 + 9];
long long inst[1000000 + 9];
long long perm[1000000 + 9];
int n;
int main() {
  cin.tie(0);
  cin.sync_with_stdio(0);
  cin >> n;
  for (int i = (1); i <= (n); i++) cin >> a[i];
  for (int i = 1; i <= n; i++) {
    if (a[i] >= i) {
      int x = a[i] - i;
      int l = 0, r = x;
      inst[l] += x + 1;
      perm[l] += -1;
      perm[r + 1] += 1;
      l = x + 1, r = n - i;
      perm[l] += 1;
      perm[r + 1] -= 1;
      inst[r + 1] -= (r - l + 1);
      x = a[i] - 1;
      l = n - i + 1, r = n - 1;
      inst[l] += x + 1;
      perm[l] += -1;
    } else {
      int x = i - a[i];
      int l = 0, r = n - i;
      inst[l] += x;
      perm[l + 1] += 1;
      perm[r + 1] -= 1;
      inst[r + 1] -= x + (r - l);
      x = a[i] - 1;
      l = n - i + 1, r = l + x;
      inst[l] += x + 1;
      perm[l] -= 1;
      perm[r + 1] += 1;
      l = r + 1, r = n - 1;
      perm[l] += 1;
    }
  }
  long long val = 0, inc = 0;
  for (int i = 0; i < n; i++) {
    val += inst[i];
    inc += perm[i];
    val += inc;
    d[i] = val;
  }
  long long minDev = d[0];
  int bestShift = 0;
  for (int i = 0; i < n; i++) {
    if (d[i] < minDev) {
      minDev = d[i];
      bestShift = i;
    }
  }
  cout << minDev << " " << bestShift << '\n';
  return 0;
}
