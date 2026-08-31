#include <bits/stdc++.h>
using namespace std;
map<long long, vector<long long> > mp;
vector<long long> ans(long long x) {
  if (mp.count(x)) {
    return mp[x];
  }
  if (x == 0) {
    return mp[x] = {0, 0, 0, 0, 0, 0};
  }
  mp[x] = {-1, 0, 0, 0, 0, 0};
  if (x < 0) {
    return mp[x];
  }
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j + i <= 6; j++) {
      if ((x - i * 4 - j * 7) % 10 == 0) {
        auto v = ans((x - i * 4 - j * 7) / 10);
        if (v[0] != -1) {
          for (int k = 0; k < 6; k++) {
            v[k] *= 10;
            if (k < i) {
              v[k] += 4;
            } else if (k < i + j) {
              v[k] += 7;
            }
          }
          return mp[x] = v;
        }
      }
    }
  }
  return mp[x];
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    auto v = ans(x);
    if (v[0] != -1) {
      for (auto j : v) {
        cout << j << " ";
      }
    } else {
      cout << -1;
    }
    cout << endl;
  }
}
