#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    long long int n, l, r;
    cin >> n >> l >> r;
    long long int l1 = 0, r1 = n - 1, mid, pos = -1;
    while (l1 <= r1) {
      mid = l1 + (r1 - l1) / 2;
      if (2 * mid * n - mid * (mid + 1) < l) {
        l1 = mid + 1;
        pos = mid;
      } else
        r1 = mid - 1;
    }
    long long int t = r - l + 1;
    l = l - (2 * pos * n - pos * (pos + 1));
    if (pos == n - 1) {
      cout << 1 << "\n";
      continue;
    }
    pos++;
    int i = 0;
    long long int count1, c;
    while (t > 0) {
      if (pos == n) {
        cout << 1;
        break;
      }
      if (i == 0) {
        if (l % 2 == 0) {
          cout << pos + l / 2 << " ";
          t--;
          l++;
        }
        count1 = 2 * (n - pos) - (l - 1);
        c = l / 2 + 1;
        i++;
      } else {
        count1 = 2 * (n - pos);
        c = 1;
      }
      while (count1 > 0 && t > 0) {
        if (t <= 0) break;
        cout << pos << " ";
        t--;
        if (t <= 0) break;
        cout << pos + c << " ";
        t--;
        c++;
        count1 -= 2;
      }
      pos++;
      if (t <= 0) break;
    }
    cout << "\n";
  }
}
