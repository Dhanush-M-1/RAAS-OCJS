#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int a[n], b[n], c[n], x[n], v[n], s1 = 0, s2 = 0, s3 = 0;
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
  cout << s1 - s2 << endl << s2 - s3 << endl;
  return 0;
}
