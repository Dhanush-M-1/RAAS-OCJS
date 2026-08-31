#include <bits/stdc++.h>
using namespace std;
vector<int> func(int n, long long l, long long r) {
  long long start = 1;
  long long end = 2 * 1ll * (n - 1);
  vector<int> ans;
  if (start <= l && l <= end) {
    while (l <= r && l <= end) {
      if (l % 2 == 1) {
        ans.push_back(1);
      } else {
        ans.push_back(l / 2 + 1);
      }
      l++;
    }
  }
  for (int i = 2; i < n; ++i) {
    if (i == n - 1) {
      start = end + 1;
      end = start + 1;
      if (start <= l && l <= end) {
        while (l <= r && l <= end) {
          if (start == l) {
            ans.push_back(n - 1);
          } else {
            ans.push_back(n);
          }
          l++;
        }
      }
    } else {
      long long tmp_start = end;
      start = end + 1;
      end = start + 2 + (n - i - 1) * 1ll * 2;
      end = end - 1;
      if (start <= l && l <= end) {
        while (l <= r && l <= end) {
          int ref_value = l - tmp_start;
          if (ref_value == 1) {
            ans.push_back(i);
          } else if (l != end) {
            if (ref_value % 2 == 0) {
              ans.push_back(i + ref_value / 2);
            } else {
              ans.push_back(i);
            }
          } else {
            ans.push_back(n);
          }
          l++;
        }
      }
    }
  }
  start = end + 1;
  end = end + 1;
  if (start <= l && l <= end) {
    while (l <= r && l <= end) {
      ans.push_back(1);
      l++;
    }
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int tt;
  cin >> tt;
  while (tt--) {
    int n;
    long long l, r;
    cin >> n >> l >> r;
    vector<int> v = func(n, l, r);
    for (int x : v) {
      cout << x << " ";
    }
    cout << endl;
  }
  return 0;
}
