#include <bits/stdc++.h>
using namespace std;
int a[1000005];
bool check(int k, int n) {
  int an1 = 0, an2 = 0;
  for (int i = 0; i < n; i++) {
    an1 += a[i];
    an2 += (k - a[i]);
  }
  if (an2 > an1) {
    return true;
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int i, j, k, l, m, n, t, r, cnt;
  int flag = 0;
  long long ans = 0, an = 0;
  t = 1;
  while (t--) {
    cin >> n;
    k = 0;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      k = max(k, a[i]);
    }
    for (i = k; i <= 500; i++) {
      if (check(i, n)) {
        break;
      }
    }
    cout << i << endl;
  }
}
