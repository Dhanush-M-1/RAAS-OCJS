#include <bits/stdc++.h>
using namespace std;
long long a[1000006];
long long n;
map<long long, long long> mp;
int main() {
  long long Q;
  cin >> Q;
  while (Q--) {
    cin >> n;
    long long l, r;
    cin >> l >> r;
    a[0] = (n - 1) * 2;
    long long k = a[0] - 2;
    long long po = 0;
    for (int i = 1; i < 1000006; i++) {
      a[i] = a[i - 1] + k;
      k -= 2;
      if (k == 0) {
        po = i + 1;
        break;
      }
    }
    long long qq, q = lower_bound(a, a + po, l) - a;
    if (q == 0)
      qq = 0;
    else
      qq = a[q - 1] + 1;
    long long qqq = a[q] + 1;
    q++;
    while (l <= r) {
      if (l == n * (n - 1) + 1) {
        cout << 1;
        break;
      }
      if (l == qqq) {
        q = lower_bound(a, a + po, l) - a;
        qq = a[q - 1] + 1;
        qqq = a[q] + 1;
        q++;
        cout << q << ' ';
        l++;
        continue;
      }
      if (l % 2 == 1)
        cout << q << ' ';
      else
        cout << (l - qq + 1) / 2 + q << ' ';
      l++;
    }
    cout << endl;
  }
  return 0;
}
