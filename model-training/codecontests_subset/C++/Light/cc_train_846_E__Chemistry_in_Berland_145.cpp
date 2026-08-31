#include <bits/stdc++.h>
using namespace std;
double b[100005] = {0}, a[100005] = {0};
int x, k, c[100005], d[100005];
int main() {
  int n, i;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> b[i];
  for (i = 1; i <= n; i++) {
    cin >> a[i];
    a[i] = b[i] - a[i];
  }
  for (i = 2; i <= n; i++) cin >> c[i] >> d[i];
  for (i = n; i >= 2; i--) {
    if (a[i] < 0) {
      a[c[i]] = a[c[i]] + (a[i] * d[i]);
      a[i] = 0;
    } else if (a[i] >= 0) {
      a[c[i]] += a[i];
      a[i] = 0;
    }
  }
  for (i = 1; i <= n; i++)
    if (a[i] < 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
}
