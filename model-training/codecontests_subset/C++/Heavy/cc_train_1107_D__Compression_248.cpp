#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 5200 + 10;
int n;
string s;
bool prime[MAX_N];
vector<int> p;
int sum[MAX_N][MAX_N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  prime[0] = 1;
  prime[1] = 1;
  for (int i = 2; i <= n; i++)
    if (prime[i] == 0) {
      if (n % i == 0) {
        p.push_back(i);
      }
      for (int j = i + i; j <= n; j += i) {
        prime[j] = 1;
      }
    }
  for (int i = 1; i <= n; i++) {
    cin >> s;
    int last = 1;
    int d;
    for (int j = 0; j < s.size(); j++) {
      if (s[j] >= 'A' && s[j] <= 'Z') {
        d = s[j] - 'A' + 10;
      } else {
        d = s[j] - '0';
      }
      for (int _ = 3; _ >= 0; _--) {
        if ((1 << _) & d) {
          sum[i][last] = 1;
        }
        last++;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      sum[i][j] += (sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1]);
    }
  }
  int ans = 1;
  for (int _ = 0; _ < p.size(); _++) {
    int x = p[_];
    int X = 1;
    {
      int __ = n;
      while (__ % x == 0) {
        __ /= x;
        X *= x;
      }
    }
    int y = x;
    while (true) {
      int sw = 0;
      for (int i = x; i <= n && sw == 0; i += x) {
        for (int j = x; j <= n; j += x) {
          int _sum =
              ((sum[i][j] - sum[i - x][j]) - sum[i][j - x]) + sum[i - x][j - x];
          if (!(_sum == 0 || _sum == x * x)) {
            sw = 1;
            break;
          }
        }
      }
      if (sw == 0) {
        if (x == X) {
          break;
        }
        x *= y;
      } else {
        x /= y;
        break;
      }
    }
    ans *= x;
  }
  cout << ans << endl;
}
