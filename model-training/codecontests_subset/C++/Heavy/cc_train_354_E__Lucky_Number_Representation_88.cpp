#include <bits/stdc++.h>
using namespace std;
long long a[6];
vector<pair<int, int> > to[10];
bool go(long long n) {
  if (n < 0) {
    return false;
  } else if (n == 0) {
    memset(a, 0, sizeof(a));
    return true;
  }
  int d = n % 10;
  for (int i = 0; i < (int)to[d].size(); ++i) {
    if (go((n - to[d][i].first * 4 - to[d][i].second * 7) / 10)) {
      int cnt4 = to[d][i].first;
      int cnt7 = to[d][i].second;
      for (int j = 0; j < 6; ++j) {
        a[j] = a[j] * 10LL;
        if (cnt4-- > 0) {
          a[j] += 4LL;
        } else if (cnt7-- > 0) {
          a[j] += 7LL;
        }
      }
      return true;
    }
  }
  return false;
}
int main() {
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j <= 6; ++j) {
      for (int k = 0; k <= 6 - j; ++k) {
        if ((j * 4 + k * 7) % 10 == i) {
          to[i].push_back(make_pair(j, k));
        }
      }
    };
    for (int j = 0; j < (int)to[i].size(); ++j) {
      ;
    }
  }
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    if (go(n)) {
      for (int i = 0; i < 6; ++i) {
        cout << a[i] << " ";
      }
      cout << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
