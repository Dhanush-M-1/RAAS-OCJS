#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, c[100000], b[100000], a[100000], s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    s1 += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    s2 += b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    s3 += c[i];
  }
  cout << s1 - s2 << endl << s2 - s3;
  return 0;
}
