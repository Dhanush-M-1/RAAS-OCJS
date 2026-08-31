#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, lgrp = 0, rgrp = 0;
    long long int l, r;
    cin >> n >> l >> r;
    for (int k = 1; k <= n - 1; ++k) {
      if (l <= 2 * (n - k) * 1LL) {
        lgrp = k;
        break;
      } else {
        l -= 2 * (n - k) * 1LL;
      }
    }
    for (int k = 1; k <= n - 1; ++k) {
      if (r <= 2 * (n - k) * 1LL) {
        rgrp = k;
        break;
      } else {
        r -= 2 * (n - k) * 1LL;
      }
    }
    int start = 0;
    if (lgrp == 0) lgrp = n;
    if (rgrp == 0) rgrp = n;
    if (lgrp == n && rgrp == n) {
      cout << 1;
    } else if (lgrp != rgrp) {
      if (l % 2 == 1) {
        ++l;
        cout << lgrp << " ";
      }
      start = l / 2;
      cout << lgrp + start << " ";
      ++l;
      for (int i = l; i <= 2 * (n - lgrp); ++i) {
        if (i % 2 == 0) {
          ++start;
          cout << lgrp + start << " ";
        } else {
          cout << lgrp << " ";
        }
      }
      for (int i = lgrp + 1; i < rgrp; ++i) {
        start = 0;
        for (int j = 1; j <= 2 * (n - i); ++j) {
          if (j % 2 == 0) {
            ++start;
            cout << i + start << " ";
          } else {
            cout << i << " ";
          }
        }
      }
      if (rgrp == n) {
        cout << 1 << " ";
      } else {
        start = 0;
        for (int i = 1; i <= r; ++i) {
          if (i % 2 == 0) {
            ++start;
            cout << rgrp + start << " ";
          } else {
            cout << rgrp << " ";
          }
        }
      }
    } else {
      if (l == r) {
        if (l % 2 == 1) {
          cout << lgrp << " ";
          ++l;
        } else {
          start = l / 2;
          cout << lgrp + start << " ";
          ++l;
        }
      } else if (l % 2 == 1) {
        ++l;
        cout << lgrp << " ";
      }
      if (l <= r) {
        start = l / 2;
        cout << lgrp + start << " ";
        ++l;
      }
      for (int i = l; i <= r; ++i) {
        if (i % 2 == 0) {
          ++start;
          cout << lgrp + start << " ";
        } else {
          cout << lgrp << " ";
        }
      }
    }
    cout << "\n";
  }
  return 0;
}
