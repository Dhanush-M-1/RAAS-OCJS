#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  for (int i = (0); i < (t); i += 1) {
    long long n, l, r;
    cin >> n >> l >> r;
    bool z = false;
    if (r == n * (n - 1) + 1) {
      r--;
      z = true;
    }
    vector<int> arr;
    long long cnt = 0;
    bool stop = false;
    for (int j = (1); j < (n + 1); j += 1) {
      if (cnt + (2 * (n - j)) < l) {
        cnt += (2 * (n - j));
        continue;
      } else {
        for (int a = (j); a < (n + 1); a += 1) {
          if (stop) break;
          for (int k = (a + 1); k < (n + 1); k += 1) {
            cnt++;
            if (cnt > r) {
              stop = true;
              break;
            }
            if (cnt >= l) {
              arr.push_back(a);
            }
            cnt++;
            if (cnt > r) {
              stop = true;
              break;
            }
            if (cnt >= l) {
              arr.push_back(k);
            }
          }
        }
        break;
      }
    }
    if (z) arr.push_back(1);
    for (int j = (0); j < (arr.size()); j += 1) cout << arr[j] << " ";
    cout << "\n";
  }
  return 0;
}
