#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    long long int a[n], b[n];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      b[i] = a[i];
    }
    sort(a, a + n);
    int d[3];
    d[0] = d[1] = d[2] = -1;
    if (a[0] + a[1] > a[n - 1])
      cout << "-1" << endl;
    else {
      for (int i = 0; i < n; i++) {
        if (b[i] == a[0] && d[0] == -1 && d[1] != i && d[2] != i) d[0] = i;
        if (b[i] == a[1] && d[0] != i && d[2] != i && d[1] == -1) d[1] = i;
        if (b[i] == a[n - 1] && d[0] != i && d[1] != i && d[2] == -1) d[2] = i;
      }
      sort(d, d + 3);
      cout << d[0] + 1 << " " << d[1] + 1 << " " << d[2] + 1 << endl;
    }
  }
  return 0;
}
