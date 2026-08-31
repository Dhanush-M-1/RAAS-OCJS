#include <bits/stdc++.h>
using namespace std;
long long a[100009], bb[1000009];
vector<long long> vc;
map<long long, long long> mp;
map<long long, long long> mp1;
int main() {
  cin.sync_with_stdio(false);
  long long i, j, k, l, c, v, b, bv[1000], aa[1009], bb1[1000], n, m, r, t, e,
      f;
  long long x1, x2, y1, y2, x3, x4, x5, x6;
  string s, s1, s2, s3, ss[10000];
  while (cin >> n) {
    k = l = 0;
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    sort(a, a + n);
    for (i = 0; i < n; i++) {
      if (a[i] <= 500000) {
        l = a[i] - 1;
      } else {
        break;
      }
    }
    for (i = n - 1; i >= 0; i--) {
      if (a[i] <= 500000) {
        break;
      } else {
        k = 1000000 - a[i];
      }
    }
    cout << (max(k, l));
  }
}
