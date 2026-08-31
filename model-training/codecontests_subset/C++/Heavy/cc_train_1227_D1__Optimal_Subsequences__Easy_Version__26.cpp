#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    pos--;
    vector<vector<int>> ans(k);
    vector<long long> sums(k);
    int last = 0;
    for (int i = 0; i < n; i++) {
      for (int j = last; j >= 0; j--) {
        if (j >= k) continue;
        if (ans[j].size() == 0) {
          if (j == 0) {
            ans[j].push_back(arr[i]);
            sums[j] = arr[i];
          } else {
            ans[j] = ans[j - 1];
            ans[j].push_back(arr[i]);
            sums[j] = sums[j - 1] + arr[i];
          }
        } else {
          if (j == 0) {
            if (arr[i] > sums[j]) {
              ans[j][0] = arr[i];
              sums[j] = arr[i];
            }
          } else if (sums[j - 1] + arr[i] > sums[j]) {
            sums[j] = sums[j - 1] + arr[i];
            ans[j] = ans[j - 1];
            ans[j].push_back(arr[i]);
          } else if (sums[j - 1] + arr[i] == sums[j]) {
            bool change = 0;
            for (int k = 0; k < ans[j - 1].size(); k++) {
              if (ans[j - 1][k] < ans[j][k]) {
                change = 1;
                break;
              } else if (ans[j - 1][k] > ans[j][k]) {
                break;
              }
            }
            if (change) {
              ans[j] = ans[j - 1];
              ans[j].push_back(arr[i]);
            }
          }
        }
      }
      last += 1;
    }
    cout << ans[k - 1][pos] << "\n";
  }
  return 0;
}
