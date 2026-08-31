#include <bits/stdc++.h>
using namespace std;
int a[1000005];
int mp[10000005];
int main() {
  int i, j, k, l, m, n, t, q, r;
  t = 1;
  while (t--) {
    scanf("%d", &n);
    for (i = 1; i <= n; i++) {
      scanf("%d", &a[i]);
    }
    long long pos = 0;
    int np = 0;
    for (i = 1; i <= n; i++) {
      mp[a[i] - i + 3000000]++;
      if (a[i] - i > 0) {
        pos += (a[i] - i);
        np++;
      }
    }
    long long mi = pos;
    int id = 0;
    int sh = 1;
    for (i = n; i > 1; i--) {
      pos -= np;
      pos += (a[i] - 1);
      if (a[i] - 1 > 0) {
        np++;
      }
      np -= mp[(sh - 1) + 1 + 3000000];
      if (pos < mi) {
        mi = pos;
        id = sh;
      }
      mp[(a[i] - 1) + sh + 3000000]++;
      mp[(a[i] - n) + sh + 3000000]--;
      sh++;
    }
    cout << mi * 2 << " " << id << endl;
  }
}
