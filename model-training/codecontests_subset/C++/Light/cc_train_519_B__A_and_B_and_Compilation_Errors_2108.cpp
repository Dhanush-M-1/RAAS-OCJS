#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  int s1 = 0, s2 = 0, s3 = 0;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    s1 += a[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> b[i];
    s2 += b[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> c[i];
    s3 += c[i];
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3 << endl;
  return 0;
}
