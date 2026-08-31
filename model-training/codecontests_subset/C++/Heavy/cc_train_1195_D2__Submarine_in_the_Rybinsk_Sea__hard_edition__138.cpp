#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<pair<long long, int>> v;
  vector<int> d(10, 0);
  vector<long long> r(1000, 0);
  for (int i = 0; i < n; ++i) {
    long long a;
    int t = -1;
    cin >> a;
    if (a < 10) {
      ++d[0];
      t = 0;
    }
    if (a < 100 && t == -1) {
      ++d[1];
      t = 1;
    }
    if (a < 1000 && t == -1) {
      ++d[2];
      t = 2;
    }
    if (a < 10000 && t == -1) {
      ++d[3];
      t = 3;
    }
    if (a < 100000 && t == -1) {
      ++d[4];
      t = 4;
    }
    if (a < 1000000 && t == -1) {
      ++d[5];
      t = 5;
    }
    if (a < 10000000 && t == -1) {
      ++d[6];
      t = 6;
    }
    if (a < 100000000 && t == -1) {
      ++d[7];
      t = 7;
    }
    if (a < 1000000000 && t == -1) {
      ++d[8];
      t = 8;
    }
    if (t == -1) {
      ++d[9];
      t = 9;
    }
    v.push_back({a, t});
  }
  for (int i = 0; i < n; ++i) {
    vector<int> num;
    while (v[i].first > 0) {
      num.push_back(v[i].first % 10);
      v[i].first /= 10;
    }
    for (int j = 0; j < 10; ++j) {
      if (d[j] > 0) {
        if (v[i].second > j) {
          for (int k = 0; k <= j; ++k) {
            r[k * 2] += d[j] * num[k];
            r[k * 2 + 1] += d[j] * num[k];
          }
          for (int k = j + 1; k < num.size(); ++k) {
            r[(j + 1) * 2 + k - j - 1] += d[j] * num[k] * 2;
          }
        } else {
          for (int k = 0; k < num.size(); ++k) {
            r[k * 2] += d[j] * num[k];
            r[k * 2 + 1] += d[j] * num[k];
          }
        }
      }
    }
  }
  long long j = 0, k = 0;
  while (r[j] > 0) {
    r[j] += k;
    k = r[j] / 10;
    r[j] %= 10;
    ++j;
  }
  k %= mod;
  k += r[j];
  --j;
  while (j > -1) {
    k = k * 10 + r[j];
    k %= mod;
    --j;
  }
  cout << k;
  return 0;
}
