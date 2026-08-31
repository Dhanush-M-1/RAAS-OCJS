#include <bits/stdc++.h>
using namespace std;
long long int power_mod(long long int a, long long int x) {
  if (x == 0) return 1;
  long long int y = power_mod(a, x / 2);
  long long int ans = (y * y) % 1000000007;
  if (x % 2) ans = (ans * a) % 1000000007;
  return ans;
}
long long int inv(long long int a) { return power_mod(a, 1000000007 - 2); }
long long int power(long long int a, long long int x) {
  if (x == 0) return 1;
  long long int y = power(a, x / 2);
  long long int ans = (y * y);
  if (x % 2) ans *= a;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int curr = 1;
    vector<long long int> v(n + 1);
    long long int sum = 0;
    long long int index = 1;
    vector<long long int> ans;
    for (long long int i = 1; i <= n - 1; i++) {
      if (sum + 2 * (n - i) >= l) {
        long long int curr = i;
        long long int curr_next = i + 1;
        long long int count = 2 * (n - i);
        for (long long int j = sum + 1; j <= min(n * (n - 1), r); j++) {
          if (j >= l) {
            ans.push_back(curr);
          }
          count--;
          if (count == 0) {
            i++;
            curr = i;
            curr_next = i + 1;
            count = 2 * (n - i);
            continue;
          }
          j++;
          if (j > r) break;
          if (j >= l) {
            ans.push_back(curr_next);
          }
          curr_next++;
          count--;
          if (count == 0) {
            i++;
            curr = i;
            curr_next = i + 1;
            count = 2 * (n - i);
            continue;
          }
        }
        break;
      } else {
        sum = sum + (2 * (n - i));
      }
    }
    if (r == (n * (n - 1)) + 1) ans.push_back(1);
    for (auto i : ans) cout << i << " ";
    cout << endl;
  }
}
