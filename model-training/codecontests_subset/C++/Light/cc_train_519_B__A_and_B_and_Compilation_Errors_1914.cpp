#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, i, a;
  unsigned long long s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    s1 += (unsigned long long)a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    s2 += (unsigned long long)a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    s3 += (unsigned long long)a;
  }
  cout << s1 - s2 << "\n" << s2 - s3;
  return 0;
}
