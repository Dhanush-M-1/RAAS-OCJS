#include <bits/stdc++.h>
using namespace std;
long long dp[2000005];
long long a[2000005];
int main() {
  long long q;
  q = 1;
  for (int r = 0; r < q; r++) {
    long long n, k;
    cin >> n >> k;
    vector<int> ans;
    vector<int> a;
    vector<int> b;
    long long x, y, z;
    for (int i = 0; i < n; i++) {
      cin >> x >> y >> z;
      if (y == 1 && z == 1)
        ans.push_back(x);
      else if (y == 1)
        a.push_back(x);
      else if (z == 1)
        b.push_back(x);
    }
    if (a.size() != 0 && b.size() != 0) {
      sort(a.begin(), a.end());
      sort(b.begin(), b.end());
    }
    long long s = min(a.size(), b.size());
    for (int i = 0; i < s; i++) {
      ans.push_back(a[i] + b[i]);
    }
    if (ans.size() < k) {
      cout << "-1";
      return 0;
    }
    sort(ans.begin(), ans.end());
    long long sum = 0;
    for (int i = 0; i < k; i++) {
      sum += ans[i];
    }
    cout << sum;
  }
  return 0;
}
