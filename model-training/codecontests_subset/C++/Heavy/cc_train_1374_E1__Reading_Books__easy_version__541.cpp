#include <bits/stdc++.h>
using namespace std;
int main() {
  int test = 1;
  while (test--) {
    int m, k, i;
    cin >> m >> k;
    int arr[3][m];
    for (i = 0; i < m; i++) cin >> arr[0][i] >> arr[1][i] >> arr[2][i];
    vector<int> a;
    vector<int> b;
    vector<int> c;
    for (i = 0; i < m; i++) {
      if (arr[1][i] == 1 && arr[2][i] == 1)
        c.push_back(arr[0][i]);
      else if (arr[1][i] == 1 && arr[2][i] == 0)
        a.push_back(arr[0][i]);
      else if (arr[1][i] == 0 && arr[2][i] == 1)
        b.push_back(arr[0][i]);
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    sort(c.begin(), c.end());
    int idx_a = 0, idx_b = 0, idx_c = 0, total = 0, ans = 0;
    while (total < k) {
      if (idx_a == a.size() || idx_b == b.size()) {
        for (; idx_c < c.size(); idx_c++) {
          if (total == k) break;
          total++;
          ans += c[idx_c];
        }
        break;
      } else if (idx_c == c.size()) {
        for (; idx_a < a.size() && idx_b < b.size(); idx_a++) {
          if (total == k) break;
          total++;
          ans += a[idx_a] + b[idx_b];
          idx_b++;
        }
        break;
      } else {
        if (a[idx_a] + b[idx_b] <= c[idx_c]) {
          ans += a[idx_a] + b[idx_b];
          total++;
          idx_a++;
          idx_b++;
        } else {
          ans += c[idx_c];
          idx_c++;
          total++;
        }
      }
    }
    if (total < k)
      cout << "-1";
    else
      cout << ans;
    cout << "\n";
  }
  return 0;
}
