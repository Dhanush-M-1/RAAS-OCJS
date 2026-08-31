#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (cin >> n) {
    vector<int> v;
    long long res, me = 0, mf = 0;
    for (int i = 0; i < n; i++) {
      int c;
      cin >> c;
      v.push_back(c);
    }
    long long res1 = 1000000 - v[0];
    res = 1000007;
    v.push_back(1000000);
    for (int i = 0; i < v.size() - 1; i++) {
      me = v[i] - 1;
      mf = 1000000 - v[i + 1];
      if (i == n - 1) {
        res = min(res, me);
        continue;
      }
      res = min(res, max(me, mf));
    }
    cout << min(res, res1) << endl;
  }
  return 0;
}
