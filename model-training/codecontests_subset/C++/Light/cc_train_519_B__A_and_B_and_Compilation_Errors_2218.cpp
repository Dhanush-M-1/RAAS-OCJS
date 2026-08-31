#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, i, j, k, l, t, s, a, cnt = 0, a1[1005], a2[1005], a3[1005],
                                       lb, ub, mid, mx, v;
  long long s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a;
    s1 += a;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a;
    s2 += a;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> a;
    s3 += a;
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3 << endl;
  return 0;
}
