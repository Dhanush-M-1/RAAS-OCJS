#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n;
  cin >> n;
  int l[n], r[n], d[n], a[n];
  for (i = 0; i < n; i++) {
    cin >> l[i] >> r[i] >> d[i];
    if (d[i] < l[i])
      a[i] = d[i];
    else {
      a[i] = r[i] / d[i];
      a[i]++;
      a[i] = a[i] * d[i];
    }
  }
  for (i = 0; i < n; i++) {
    cout << a[i] << endl;
  }
}
