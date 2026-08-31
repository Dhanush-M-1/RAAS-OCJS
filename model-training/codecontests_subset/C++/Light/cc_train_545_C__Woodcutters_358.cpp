#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long c, i, j, k, l, n, x1, x2, y;
  vector<long long> v;
  unordered_map<long long, long long> m;
  cin >> n;
  i = 0;
  while (i < n) {
    cin >> k;
    v.push_back(k);
    cin >> k;
    m[v[i]] = k;
    i++;
  }
  i = 1;
  c = 1;
  while (i < n - 1) {
    x1 = v[i] - v[i - 1];
    x2 = v[i + 1] - v[i];
    y = m[v[i]];
    if (x1 > y) {
      c++;
    } else {
      if (x2 > y) {
        c++;
        v[i] = v[i] + m[v[i]];
      }
    }
    i++;
  }
  if (n > 1) {
    c++;
  }
  cout << c;
  return (0);
}
