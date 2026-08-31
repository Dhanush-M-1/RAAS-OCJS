#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int s1 = 0, s2 = 0, s3 = 0, n, i, a, b;
  cin >> n;
  long long int k[n];
  long long int l[n - 1];
  long long int m[n - 2];
  for (i = 0; i < n; i++) {
    cin >> k[i];
    s1 = s1 + k[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> l[i];
    s2 = s2 + l[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> m[i];
    s3 = s3 + m[i];
  }
  cout << s1 - s2 << endl << s2 - s3;
}
