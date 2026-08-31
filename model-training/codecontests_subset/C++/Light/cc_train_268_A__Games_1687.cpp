#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n;
  cin >> n;
  long long int a[n], b[n];
  long long int j, k, i = 0, m = 0, h = n;
  while (h--) {
    cin >> j >> k;
    a[i++] = j;
    b[m++] = k;
  }
  long long int r = 0, t, s;
  for (t = 0; t < n; t++) {
    for (s = 0; s < n; s++) {
      if (a[t] == b[s]) r++;
    }
  }
  cout << r;
  return 0;
}
