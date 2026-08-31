#include <bits/stdc++.h>
using namespace std;
int a[101];
int ans[101];
int main() {
  int n;
  string s = "";
  a[0] = 1;
  int k = 0;
  int ct1 = 1;
  int ct2 = 0;
  while (true) {
    cin >> s;
    cin >> s;
    k++;
    if (s == "=") break;
    a[k] = (s == "+") ? 1 : -1;
    if (a[k] == 1)
      ct1++;
    else
      ct2++;
  }
  cin >> n;
  if (ct1 * n - ct2 >= n && ct1 - n * ct2 <= n) {
    cout << "Possible\n";
    int sum = 0;
    for (int i = 0; i < k; i++) {
      ans[i] = 1;
      sum += ans[i] * a[i];
    }
    if (sum > n) {
      int j = 0;
      while (sum > n) {
        while (a[j] != -1 || ans[j] == n) {
          j++;
        }
        int k = min(sum - n, n - ans[j]);
        ans[j] += k;
        sum -= k;
      }
    } else {
      int j = 0;
      while (sum < n) {
        while (a[j] != 1 || ans[j] == n) {
          j++;
        }
        int k = min(n - sum, n - ans[j]);
        ans[j] += k;
        sum += k;
      }
    }
    cout << ans[0] << " ";
    for (int i = 1; i < k; i++) {
      cout << (a[i] == 1 ? "+ " : "- ") << ans[i] << " ";
    }
    cout << "= " << n;
  } else {
    cout << "Impossible\n";
  }
  return 0;
}
