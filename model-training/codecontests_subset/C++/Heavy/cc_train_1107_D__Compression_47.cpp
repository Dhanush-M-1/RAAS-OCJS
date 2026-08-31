#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
const long long inf = 1e14;
long long gcd(long long a, long long b) { return (b == 0 ? a : gcd(b, a % b)); }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, ans = 0;
  cin >> n;
  long long bi[n][n];
  memset(bi, 0, sizeof(bi));
  string s;
  for (long long i = 0; i < n; i++) {
    cin >> s;
    for (long long j = 0; j < n / 4; j++) {
      if (s[j] > '9') {
        if (s[j] == 'A') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 0;
          bi[i][j * 4 + 2] = 1;
          bi[i][j * 4 + 3] = 0;
        } else if (s[j] == 'B') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 0;
          bi[i][j * 4 + 2] = 1;
          bi[i][j * 4 + 3] = 1;
        } else if (s[j] == 'C') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 1;
          bi[i][j * 4 + 2] = 0;
          bi[i][j * 4 + 3] = 0;
        } else if (s[j] == 'D') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 1;
          bi[i][j * 4 + 2] = 0;
          bi[i][j * 4 + 3] = 1;
        } else if (s[j] == 'E') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 1;
          bi[i][j * 4 + 2] = 1;
          bi[i][j * 4 + 3] = 0;
        } else if (s[j] == 'F') {
          bi[i][j * 4] = 1;
          bi[i][j * 4 + 1] = 1;
          bi[i][j * 4 + 2] = 1;
          bi[i][j * 4 + 3] = 1;
        }
      } else {
        long long tmp = s[j] - '0';
        bitset<4> bs(tmp);
        bi[i][j * 4] = bs[3];
        bi[i][j * 4 + 1] = bs[2];
        bi[i][j * 4 + 2] = bs[1];
        bi[i][j * 4 + 3] = bs[0];
      }
    }
  }
  long long an = 0;
  for (long long i = 0; i < n; i++) {
    long long cnt0 = 0, cnt1 = 0, tmp = 0;
    for (long long j = 0; j < n; j++) {
      if (bi[i][j] == 1) cnt1++;
      if (bi[i][j] == 0 || j == n - 1) {
        an = gcd(an, cnt1);
        cnt1 = 0;
      }
    }
    tmp = 0;
    for (long long j = 0; j < n; j++) {
      if (bi[i][j] == 0) cnt0++;
      if (bi[i][j] == 1 || j == n - 1) {
        an = gcd(an, cnt0);
        cnt0 = 0;
      }
    }
  }
  for (long long i = 0; i < n; i++) {
    long long cnt0 = 0, cnt1 = 0, tmp = 0;
    for (long long j = 0; j < n; j++) {
      if (bi[j][i] == 1) cnt1++;
      if (bi[j][i] == 0 || j == n - 1) {
        an = gcd(an, cnt1);
        cnt1 = 0;
      }
    }
    for (long long j = 0; j < n; j++) {
      if (bi[j][i] == 0) cnt0++;
      if (bi[j][i] == 1 || j == n - 1) {
        an = gcd(an, cnt0);
        cnt0 = 0;
      }
    }
  }
  cout << an;
  return 0;
}
