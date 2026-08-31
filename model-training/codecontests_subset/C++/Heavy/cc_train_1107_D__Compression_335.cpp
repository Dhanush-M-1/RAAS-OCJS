#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int TESTS = 1;
  while (TESTS--) {
    long long n;
    cin >> n;
    map<char, string> m;
    m['0'] = "0000";
    m['1'] = "0001";
    m['2'] = "0010";
    m['3'] = "0011";
    m['4'] = "0100";
    m['5'] = "0101";
    m['6'] = "0110";
    m['7'] = "0111";
    m['8'] = "1000";
    m['9'] = "1001";
    m['A'] = "1010";
    m['B'] = "1011";
    m['C'] = "1100";
    m['D'] = "1101";
    m['E'] = "1110";
    m['F'] = "1111";
    char s[n][n];
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < n / 4; j++) {
        char c;
        cin >> c;
        for (long long k = 0; k < 4; k++) s[i][4 * j + k] = m[c][k];
      }
    }
    long long sum[n + 1][n + 1];
    for (long long i = 0; i < n + 1; i++)
      for (long long j = 0; j < n + 1; j++) sum[i][j] = 0;
    for (long long i = 1; i < n + 1; i++)
      for (long long j = 1; j < n + 1; j++) {
        sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
        if (s[i - 1][j - 1] == '1') sum[i][j]++;
      }
    vector<long long> f;
    for (long long i = 1; i < sqrt(n) + 1; i++) {
      if (n % i == 0) {
        f.push_back(i);
        f.push_back(n / i);
      }
    }
    sort((f).begin(), (f).end());
    reverse((f).begin(), (f).end());
    long long z = (long long)f.size();
    long long ans = 1;
    for (long long k = 0; k < z; k++) {
      long long len = f[k];
      long long x = 1;
      for (long long i = len; i <= n; i += len)
        for (long long j = len; j <= n; j += len) {
          if ((sum[i][j] - sum[i - len][j] - sum[i][j - len] +
               sum[i - len][j - len]) %
              (len * len))
            x = 0;
        }
      if (x) {
        cout << len;
        return 0;
      }
    }
    cout << ans;
  }
  return 0;
}
