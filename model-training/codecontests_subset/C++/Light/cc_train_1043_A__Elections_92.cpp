#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n;
  cin >> n;
  int a[n], m = 0, s = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    m = max(m, a[i]);
    s += a[i];
  }
  int i;
  for (i = m;; i++) {
    int c = 0;
    for (int j = 0; j < n; j++) {
      c += (i - a[j]);
    }
    if (c > s) break;
  }
  cout << i << '\n';
}
