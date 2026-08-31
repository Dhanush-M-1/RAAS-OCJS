#include <bits/stdc++.h>
using namespace std;
const double PI = 4 * atan(1);
const long long INF = 1e18;
const int MX = 100001;
int T, n;
long long l, r;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> T;
  while (T--) {
    cin >> n >> l >> r;
    long long first_elt = 1;
    long long num_visited = 0;
    long long length = 2 * (n - 1);
    while (num_visited + length < l) {
      num_visited += length;
      length -= 2;
      first_elt++;
      if (first_elt == n) {
        length = 1;
      }
    }
    vector<int> ans;
    int remaining = r - num_visited;
    while (ans.size() < remaining) {
      if (first_elt == n) {
        ans.push_back(1);
        break;
      }
      for (int i = first_elt + 1; i <= n; i++) {
        ans.push_back(first_elt);
        ans.push_back(i);
      }
      first_elt++;
    }
    for (long long i = 0; i < (long long)ans.size(); i++) {
      long long perm_index = num_visited + i + 1;
      if (perm_index >= l && perm_index < r) {
        cout << ans[i] << " ";
      }
      if (perm_index == r) {
        cout << ans[i] << "\n";
      }
    }
  }
}
