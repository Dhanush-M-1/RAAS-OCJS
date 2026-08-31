#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, k, c1 = 0, c2 = 0, v = 0, ans = 0, res;
  cin >> n >> k;
  long long a[n][3];
  vector<long long> s1, s2, s3;
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < 3; j++) {
      cin >> a[i][j];
      if (j == 1) {
        if (a[i][j] == 1) c1++;
      } else if (j == 2) {
        if (a[i][j] == 1) c2++;
      }
    }
  }
  if (c1 < k || c2 < k) {
    cout << "-1"
         << "\n";
  } else {
    for (long long i = 0; i < n; i++) {
      if (a[i][1] && a[i][2])
        s1.push_back(a[i][0]);
      else if (a[i][1])
        s2.push_back(a[i][0]);
      else if (a[i][2])
        s3.push_back(a[i][0]);
    }
    sort(s2.begin(), s2.end());
    sort(s3.begin(), s3.end());
    if (s2.size() < s3.size())
      res = s2.size();
    else
      res = s3.size();
    for (long long i = 0; i < res; i++) {
      s1.push_back(s2[i] + s3[i]);
    }
    sort(s1.begin(), s1.end());
    for (auto i : s1) {
      if (v >= k) break;
      ans += i;
      v++;
    }
    cout << ans << "\n";
    s1.clear();
    s2.clear();
    s3.clear();
  }
  return 0;
}
