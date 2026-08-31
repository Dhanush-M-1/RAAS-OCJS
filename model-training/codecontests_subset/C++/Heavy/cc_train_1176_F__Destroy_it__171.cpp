#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(time(0));
bool isPrime(long long a) {
  long long i;
  for (i = 2; i * i <= a; i++) {
    if (a % i == 0) {
      return 0;
    }
  }
  return (a != 1);
}
bool isPalindrom(const string& s, int l, int r) {
  for (int i = 0; i < (r - l + 1) / 2; i++) {
    if (s[l + i] != s[r - i]) {
      return 0;
    }
  }
  return 1;
}
template <class type1>
type1 gcd(type1 a, type1 b) {
  type1 t;
  while (b) {
    t = b;
    b = a % b;
    a = t;
  }
  return a;
}
long long positiveMod(long long v, long long md) {
  v = v % md;
  if (v < 0) {
    v += md;
  }
  return v;
}
long long dp[200005][10];
vector<long long> v1, v2, v3;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long res = 0, n, m, i, j, a, b, c;
  cin >> n;
  for (auto& it : dp) {
    for (auto& itt : it) {
      itt = -(1000000000000000007ll);
    }
  }
  dp[0][0] = 0;
  for (i = 1; i <= n; i++) {
    v1.clear();
    v2.clear();
    v3.clear();
    cin >> m;
    for (j = 0; j < m; j++) {
      cin >> a >> b;
      if (a == 1) {
        v1.push_back(b);
      }
      if (a == 2) {
        v2.push_back(b);
      }
      if (a == 3) {
        v3.push_back(b);
      }
    }
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    sort(v3.begin(), v3.end());
    reverse(v1.begin(), v1.end());
    reverse(v2.begin(), v2.end());
    reverse(v3.begin(), v3.end());
    for (j = 0; j < 10; j++) {
      dp[i][j] = dp[i - 1][j];
    }
    for (j = 0; j < 10; j++) {
      if (!v1.empty()) {
        if (j < 9) {
          dp[i][j + 1] = max(dp[i][j + 1], dp[i - 1][j] + v1[0]);
        } else {
          dp[i][0] = max(dp[i][0], dp[i - 1][9] + v1[0] * 2);
        }
      }
      if (!v2.empty()) {
        if (j < 9) {
          dp[i][j + 1] = max(dp[i][j + 1], dp[i - 1][j] + v2[0]);
        } else {
          dp[i][0] = max(dp[i][0], dp[i - 1][9] + v2[0] * 2);
        }
      }
      if (!v3.empty()) {
        if (j < 9) {
          dp[i][j + 1] = max(dp[i][j + 1], dp[i - 1][j] + v3[0]);
        } else {
          dp[i][0] = max(dp[i][0], dp[i - 1][9] + v3[0] * 2);
        }
      }
      if ((!v2.empty()) && (!v1.empty())) {
        if (j < 8) {
          dp[i][j + 2] = max(dp[i][j + 2], dp[i - 1][j] + v1[0] + v2[0]);
        } else {
          dp[i][j + 2 - 10] =
              max(dp[i][j + 2 - 10],
                  dp[i - 1][j] + max(v1[0], v2[0]) * 2 + min(v1[0], v2[0]));
        }
      }
      if (v1.size() >= 2) {
        if (j < 8) {
          dp[i][j + 2] = max(dp[i][j + 2], dp[i - 1][j] + v1[0] + v1[1]);
        } else {
          dp[i][j + 2 - 10] =
              max(dp[i][j + 2 - 10], dp[i - 1][j] + v1[0] * 2 + v1[1]);
        }
      }
      if (v1.size() >= 3) {
        if (j < 7) {
          dp[i][j + 3] =
              max(dp[i][j + 3], dp[i - 1][j] + v1[0] + v1[1] + v1[2]);
        } else {
          dp[i][j + 3 - 10] =
              max(dp[i][j + 3 - 10], dp[i - 1][j] + v1[0] * 2 + v1[1] + v1[2]);
        }
      }
    }
  }
  for (auto it : dp[n]) {
    res = max(res, it);
  }
  cout << res << "\n";
  return 0;
}
