#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, k, s1 = 0, s2 = 0, s3 = 0, i;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> k;
    s1 = s1 + k;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> k;
    s2 = s2 + k;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> k;
    s3 = s3 + k;
  }
  cout << s1 - s2 << endl << s2 - s3;
  return 0;
}
