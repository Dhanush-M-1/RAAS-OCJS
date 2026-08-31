#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> v1;
  vector<long long int> v2;
  vector<long long int> v;
  for (long long int i = 0; i < n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      v.push_back(t);
    } else if (a == 0 && b == 1) {
      v2.push_back(t);
    } else if (a == 1 && b == 0) {
      v1.push_back(t);
    }
  }
  if (v1.size() + v.size() < k || v2.size() + v.size() < k) {
    cout << -1 << "\n";
  } else {
    long long int m1 = v1.size();
    long long int m2 = v2.size();
    long long int m = v.size();
    if (m1 != 0) sort(v1.begin(), v1.end());
    if (m2 != 0) sort(v2.begin(), v2.end());
    if (m != 0) sort(v.begin(), v.end());
    vector<long long int> ans;
    if (m1 == 0 || m2 == 0) {
      for (long long int i = 0; i < m; i++) {
        ans.push_back(v[i]);
      }
    } else {
      long long int p = 0;
      for (long long int i = 0; i < m1; i++) {
        if (p < m2) {
          ans.push_back(v1[i] + v2[p]);
          p++;
        }
      }
      for (long long int i = 0; i < m; i++) {
        ans.push_back(v[i]);
      }
    }
    sort(ans.begin(), ans.end());
    long long int final = 0;
    for (long long int i = 0; i < k; i++) {
      final = final + ans[i];
    }
    cout << final << "\n";
  }
  return 0;
}
