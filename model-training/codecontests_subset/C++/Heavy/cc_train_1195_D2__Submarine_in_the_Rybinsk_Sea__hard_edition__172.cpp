#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned long long int n, i, j, k;
  cin >> n;
  unsigned long long int ans = 0;
  unsigned long long int digits[12] = {0};
  unsigned long long int a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
    unsigned long long int x = a[i];
    unsigned long long int ct = 0;
    while (x > 0) {
      ct++;
      x /= 10;
    }
    digits[ct]++;
  }
  unsigned long long int backward[n][12];
  unsigned long long int forwardd[n][12];
  for (i = 0; i < n; i++) {
    unsigned long long int no_of_dig = 0;
    unsigned long long int y = a[i];
    while (y > 0) {
      no_of_dig++;
      y /= 10;
    }
    for (j = 0; j < no_of_dig; j++) {
      unsigned long long int temp = no_of_dig - 1 - j;
      unsigned long long int x = a[i];
      vector<unsigned long long int> v;
      while (x > 0) {
        v.push_back(x % 10);
        x /= 10;
      }
      reverse(v.begin(), v.end());
      unsigned long long int xx = 0;
      for (k = 0; k < no_of_dig; k++) {
        xx = (xx * 10) + v[k];
        xx = xx % 998244353;
        if (k != no_of_dig - 1 && k >= temp) {
          xx = (xx * 10);
        }
        xx = xx % 998244353;
      }
      backward[i][j] = xx;
      forwardd[i][j + 1] = (xx * 10) % 998244353;
    }
    for (j = no_of_dig; j < 12; j++) {
      backward[i][j] = backward[i][j - 1];
      if (j + 1 < 12) forwardd[i][j + 1] = forwardd[i][j];
    }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < 12; j++) {
      ans = ((ans % 998244353) + ((backward[i][j] * digits[j]) % 998244353)) %
            998244353;
    }
    for (j = 1; j < 12; j++) {
      ans = ((ans % 998244353) + ((forwardd[i][j] * digits[j]) % 998244353)) %
            998244353;
    }
  }
  cout << ans % 998244353;
}
