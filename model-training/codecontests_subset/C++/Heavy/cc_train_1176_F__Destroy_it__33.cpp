#include <bits/stdc++.h>
using namespace std;
int n, k;
long long t[5][5], f1[11], f2[11], maxx[5][5];
bool cmp(long long u, long long v) { return u > v; }
int main() {
  cin >> n;
  memset(f1, -1, sizeof(f1));
  memset(f2, -1, sizeof(f2));
  f1[0] = 0;
  while (n--) {
    cin >> k;
    vector<long long> a[5];
    memset(t, -1, sizeof(t));
    for (int i = 1; i <= k; ++i) {
      int cost;
      long long dam;
      cin >> cost >> dam;
      a[cost].push_back(dam);
    }
    for (int i = 1; i <= 3; ++i) sort(a[i].begin(), a[i].end(), cmp);
    if (a[1].size() >= 1) {
      t[1][1] = a[1][0];
      maxx[1][1] = a[1][0];
    }
    if (a[2].size() >= 1) {
      t[2][1] = a[2][0];
      maxx[2][1] = a[2][0];
    }
    if (a[1].size() >= 2) {
      t[2][2] = a[1][0] + a[1][1];
      maxx[2][2] = a[1][0];
    }
    if (a[3].size() >= 1) {
      t[3][1] = a[3][0];
      maxx[3][1] = a[3][0];
    }
    if (a[1].size() >= 1 && a[2].size() >= 1) {
      t[3][2] = a[1][0] + a[2][0];
      maxx[3][2] = max(a[1][0], a[2][0]);
    }
    if (a[1].size() >= 3) {
      t[3][3] = a[1][0] + a[1][1] + a[1][2];
      maxx[3][3] = a[1][0];
    }
    for (int i = 0; i <= 9; ++i) {
      if (f1[i] == -1) continue;
      for (int j = 1; j <= 3; ++j) {
        for (int ii = 1; ii <= 3; ++ii) {
          if (t[j][ii] == -1) continue;
          int numcard = i + ii;
          if (numcard >= 10)
            f2[numcard % 10] =
                max(f2[numcard % 10], f1[i] + t[j][ii] + maxx[j][ii]);
          else
            f2[numcard] = max(f2[numcard], f1[i] + t[j][ii]);
        }
      }
    }
    for (int i = 0; i <= 9; ++i) {
      f1[i] = max(f1[i], f2[i]);
      f2[i] = -1;
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; ++i) ans = max(ans, f1[i]);
  cout << ans;
}
