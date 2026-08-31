#include <bits/stdc++.h>
using namespace ::std;
int a[110], n, c, i, j, o, m;
int main() {
  cin >> n >> c;
  cin >> a[0];
  for (i = 1; i < n; i++) {
    cin >> a[i];
    m = max(a[i - 1] - a[i] - c, m);
  }
  cout << m;
}
