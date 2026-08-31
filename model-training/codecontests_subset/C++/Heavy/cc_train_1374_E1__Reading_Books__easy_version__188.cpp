#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int64_t n, k, ac = 0, bc = 0;
  cin >> n >> k;
  vector<int64_t> main;
  vector<int64_t> a_array;
  vector<int64_t> b_array;
  while (n--) {
    int64_t t, a, b;
    cin >> t >> a >> b;
    if (a == 1) ac += 1;
    if (b == 1) bc += 1;
    if (a == 1 && b == 1)
      main.push_back(t);
    else {
      if (a == 1) a_array.push_back(t);
      if (b == 1) b_array.push_back(t);
    }
  }
  if (ac >= k && bc >= k) {
    int64_t i, ans = 0;
    sort(main.begin(), main.end());
    sort(a_array.begin(), a_array.end());
    sort(b_array.begin(), b_array.end());
    int64_t l = 0, m = 0, n = 0;
    int64_t aSize = a_array.size();
    int64_t bSize = b_array.size();
    int64_t mSize = main.size();
    for (i = 1; i <= k; i++) {
      if (aSize >= 1 && bSize >= 1) {
        if (mSize >= 1) {
          if ((a_array[l] + b_array[m]) <= main[n]) {
            ans = ans + a_array[l] + b_array[m];
            l += 1;
            m += 1;
            aSize -= 1;
            bSize -= 1;
          } else {
            ans += main[n];
            n += 1;
            mSize -= 1;
          }
        } else {
          ans = ans + a_array[l] + b_array[m];
          l += 1;
          m += 1;
          aSize -= 1;
          bSize -= 1;
        }
      } else {
        ans += main[n];
        n += 1;
        mSize -= 1;
      }
    }
    cout << ans;
  } else
    cout << -1;
  return 0;
}
