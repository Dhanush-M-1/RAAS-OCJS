#include <bits/stdc++.h>
using namespace std;
long int a, s1, s2, s3, n;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    s1 += a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> a;
    s2 += a;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> a;
    s3 += a;
  }
  cout << s1 - s2 << endl << s2 - s3 << endl;
  return 0;
}
