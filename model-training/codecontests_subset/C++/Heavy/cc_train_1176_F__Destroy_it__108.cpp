#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<long long> dp(10, INT64_MIN / 16), tp(10, 0);
  dp[0] = 0;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    long long m11 = INT64_MIN / 4, m12 = INT64_MIN / 4, m13 = INT64_MIN / 4,
              m20 = INT64_MIN / 4, m30 = INT64_MIN / 4;
    for (int j = 0; j < k; j++) {
      long long cost, damage;
      cin >> cost >> damage;
      if (cost == 1 && damage > m11) {
        m13 = m12;
        m12 = m11;
        m11 = damage;
      } else if (cost == 1 && damage > m12) {
        m13 = m12;
        m12 = damage;
      } else if (cost == 1 && damage > m13)
        m13 = damage;
      else if (cost == 2)
        m20 = max(m20, damage);
      else if (cost == 3)
        m30 = max(m30, damage);
    }
    long long d1 = max(m11, max(m20, m30)), d2 = max(m11 + m12, m11 + m20),
              d3 = m11 + m12 + m13;
    long long b1 = d1, b2 = max(m11, m20), b3 = m11;
    tp = vector<long long>(dp);
    for (int j = 0; j < 10; j++) {
      if (d1 > 0)
        dp[(j + 1) % 10] =
            max(dp[(j + 1) % 10], d1 + tp[j] + (j + 1 >= 10 ? b1 : 0));
      if (d2 > 0)
        dp[(j + 2) % 10] =
            max(dp[(j + 2) % 10], d2 + tp[j] + (j + 2 >= 10 ? b2 : 0));
      if (d3 > 0)
        dp[(j + 3) % 10] =
            max(dp[(j + 3) % 10], d3 + tp[j] + (j + 3 >= 10 ? b3 : 0));
    }
  }
  cout << *max_element(dp.begin(), dp.end()) << endl;
}
