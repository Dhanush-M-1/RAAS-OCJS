#include <bits/stdc++.h>
using namespace std;
int n;
long long a[100005], b[100005], c[100005], x, y;
map<long long, int> mp, mp1, mp2;
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    ++mp1[a[i]];
  }
  for (int i = 0; i < n - 1; ++i) {
    cin >> b[i];
    ++mp[b[i]];
  }
  for (int i = 0; i < n; ++i) {
    if (mp[a[i]] < mp1[a[i]]) {
      x = a[i];
      break;
    }
  }
  for (int i = 0; i < n - 2; ++i) {
    cin >> c[i];
    ++mp2[c[i]];
  }
  for (int i = 0; i < n - 1; ++i) {
    if (mp2[b[i]] < mp[b[i]]) {
      y = b[i];
      break;
    }
  }
  cout << x << endl << y;
  return 0;
}
