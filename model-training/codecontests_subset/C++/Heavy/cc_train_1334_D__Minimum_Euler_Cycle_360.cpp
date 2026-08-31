#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int count = 0;
    long long int i = 1;
    while (i < n) {
      if (count + (2 * (n - i)) >= l) {
        long long int check = l - count;
        long long int start = i + ((check + 1) / 2);
        while (l <= r && i < n) {
          if (l % 2 == 0) {
            cout << start << " ";
            start++;
          } else {
            cout << i << " ";
          }
          if (start == n + 1) {
            i++;
            start = i + 1;
          }
          l++;
        }
        i = n;
      }
      count += 2 * (n - i);
      i++;
    }
    if (l <= r) {
      cout << 1;
    }
    cout << endl;
  }
}
