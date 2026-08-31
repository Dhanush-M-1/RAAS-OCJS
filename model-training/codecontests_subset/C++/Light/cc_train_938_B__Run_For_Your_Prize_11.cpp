#include <bits/stdc++.h>
using namespace std;
int i, jog, k, l = 500000, m, n, a[1000009];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) {
    if (a[i] <= l) jog = a[i] - 1;
  }
  for (int i = 1; i <= n; i++) {
    if (a[i] > l) jog = max(jog, 1000000 - a[i]);
  }
  cout << jog;
}
