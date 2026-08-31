#include <bits/stdc++.h>
using namespace std;
long long int w[100001];
int main() {
  long long int n, i, a[100001][2], c = 1, z;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  z = a[0][0];
  for (i = 1; i < n - 1; i++) {
    if ((a[i][0] - z) > a[i][1]) {
      c++;
      z = a[i][0];
    } else if (a[i + 1][0] - a[i][0] > a[i][1]) {
      c++;
      z = a[i][0] + a[i][1];
    } else
      z = a[i][0];
  }
  if (n > 1) c++;
  cout << c;
}
