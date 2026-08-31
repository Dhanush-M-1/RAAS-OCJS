#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, a, b, c, s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s1 += a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b;
    s2 += b;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c;
    s3 += c;
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3 << endl;
  return 0;
}
