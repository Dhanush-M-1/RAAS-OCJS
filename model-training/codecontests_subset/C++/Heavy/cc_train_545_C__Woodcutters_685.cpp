#include <bits/stdc++.h>
using namespace std;
pair<int, int> arr[100005];
pair<int, int> arr2[100005];
void solve() {
  int n;
  cin >> n;
  for (int i = 0; i <= n - 1; i += 1) {
    cin >> arr[i].first >> arr[i].second;
  }
  if (n == 1) {
    cout << "1";
    return;
  }
  arr2[0].first = 1;
  (arr[0].first + arr[1].second < arr[1].first) ? arr2[0].second = 1
                                                : arr2[0].second = 0;
  for (int i = 1; i <= n - 1; i += 1) {
    int pc = arr[i - 1].first, ph = arr[i - 1].second, cc = arr[i].first,
        ch = arr[i].second;
    int pl = arr2[i - 1].first, pr = arr2[i - 1].second;
    if (i == n - 1) {
      arr2[i].second = 1 + max(pl, pr);
      int k1 = -1, k2 = -1;
      if (cc - ch > pc + ph) {
        k1 = 1 + pr;
      } else {
        k1 = pr;
      }
      if (cc - ch > pc) {
        k2 = 1 + pl;
      } else {
        k2 = pl;
      }
      arr2[i].first = max(k1, k2);
    } else {
      int k1 = -1, k2 = -1;
      if (cc - ch > pc + ph) {
        k1 = 1 + pr;
      } else {
        k1 = pr;
      }
      if (cc - ch > pc) {
        k2 = 1 + pl;
      } else {
        k2 = pl;
      }
      arr2[i].first = max(k1, k2);
      int nc = arr[i + 1].first, nh = arr[i + 1].second;
      if (cc + ch < nc) {
        arr2[i].second = 1 + max(pl, pr);
      } else {
        arr2[i].second = max(pl, pr);
      }
    }
  }
  cout << max(arr2[n - 1].first, arr2[n - 1].second);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n = 1;
  for (int i = 0; i < n; i++) {
    solve();
  }
}
