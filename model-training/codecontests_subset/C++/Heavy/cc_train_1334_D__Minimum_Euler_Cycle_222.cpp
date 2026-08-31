#include <bits/stdc++.h>
using namespace std;
long long ind[100005];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  int t;
  cin >> t;
  for (int z = 1; z <= t; z++) {
    long long n;
    long long l, r;
    cin >> n >> l >> r;
    vector<int> res;
    ind[0] = 0;
    for (int i = 1; i < n; i++) {
      ind[i] = ind[i - 1] + 2 * (n - i);
    }
    ind[n] = ind[n - 1] + 1;
    bool isLast = 0;
    long long last = n * (n - 1) + 1;
    if (r == last) {
      r--;
      isLast = 1;
    }
    int groupL = 0;
    for (int i = 1; i <= n; i++) {
      if (ind[i] >= l) {
        groupL = i;
        break;
      }
    }
    int groupR = 0;
    for (int i = 1; i <= n; i++) {
      if (ind[i] >= r) {
        groupR = i;
        break;
      }
    }
    long long a = max(ind[groupL - 1] + 1, l);
    a -= ind[groupL - 1];
    long long b = min(ind[groupL], r);
    b -= ind[groupL - 1];
    for (long long i = a; i <= b; i++) {
      if (i % 2 == 1) {
        res.push_back(groupL);
      } else {
        long long k = i / 2;
        k += groupL;
        res.push_back(k);
      }
    }
    if (groupR > groupL) {
      int group = groupL;
      for (long long i = ind[groupL] + 1; i <= ind[groupR - 1]; i++) {
        long long k = i - ind[group];
        if (k % 2 == 1) {
          res.push_back(group + 1);
        } else {
          long long p = k / 2;
          p += group + 1;
          res.push_back(p);
          if (p == n) {
            group++;
          }
        }
      }
      long long c = max(ind[groupR - 1] + 1, l);
      c -= ind[groupR - 1];
      long long d = min(ind[groupR], r);
      d -= ind[groupR - 1];
      for (long long i = c; i <= d; i++) {
        if (i % 2 == 1) {
          res.push_back(groupR);
        } else {
          long long k = i / 2;
          k += groupR;
          res.push_back(k);
        }
      }
    }
    if (isLast == 1) {
      res.push_back(1);
    }
    for (int i = 0; i < res.size(); i++) {
      cout << res[i] << " ";
    }
    cout << "\n";
  }
  return 0;
}
