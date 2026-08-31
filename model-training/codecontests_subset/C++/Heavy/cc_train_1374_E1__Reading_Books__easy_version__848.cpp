#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, k;
  cin >> n >> k;
  vector<long long> a;
  vector<long long> b;
  vector<long long> same;
  for (long long i = 0; i < n; i++) {
    long long t, x, y;
    cin >> t >> x >> y;
    if (x == 1 && y == 1)
      same.push_back(t);
    else if (x == 1)
      a.push_back(t);
    else if (y == 1)
      b.push_back(t);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(same.begin(), same.end());
  long long a_n = (long long)a.size();
  long long b_n = (long long)b.size();
  long long same_n = (long long)same.size();
  if ((same_n + a_n < k) || (same_n + b_n < k)) {
    cout << -1 << endl;
  } else {
    long long cnt = 0, ans = 0, i = 0, j = 0;
    while (cnt < k) {
      if (i < same_n && j < a_n && j < b_n && same[i] < (a[j] + b[j])) {
        cnt++;
        ans += same[i];
        i++;
      } else if (j < a_n && j < b_n) {
        cnt++;
        ans += (a[j] + b[j]);
        j++;
      } else
        break;
    }
    if (cnt < k) {
      if (i < same_n) {
        while (i < same_n && cnt < k) {
          cnt++;
          ans += same[i];
          i++;
        }
      } else {
        while (j < a_n && j < b_n && cnt < k) {
          cnt++;
          ans += (a[j] + b[j]);
          j++;
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
