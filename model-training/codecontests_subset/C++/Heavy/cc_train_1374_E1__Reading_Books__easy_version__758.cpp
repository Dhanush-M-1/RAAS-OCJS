#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<int> a, b, ab;
  for (int i = 1; i <= n; ++i) {
    int x, l, r;
    cin >> x >> l >> r;
    if (l == 1 and r == 0) {
      a.push_back(x);
    } else if (l == 0 and r == 1) {
      b.push_back(x);
    } else if (l == 1 and r == 1) {
      ab.push_back(x);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(ab.begin(), ab.end());
  for (int i = 1; i < a.size(); ++i) {
    a[i] += a[i - 1];
  }
  for (int i = 1; i < b.size(); ++i) {
    b[i] += b[i - 1];
  }
  for (int i = 1; i < ab.size(); ++i) {
    ab[i] += ab[i - 1];
  }
  int answer = 2e9 + 10;
  for (int i = 0; i <= k; ++i) {
    int x = k - i, t = 2e9 + 10;
    if (i == 0) {
      if (x <= ab.size()) {
        t = ab[x - 1];
      }
    } else if (i == k) {
      if (i <= a.size() and i <= b.size()) {
        t = a[i - 1] + b[i - 1];
      }
    } else {
      if (x <= ab.size() and i <= a.size() and i <= b.size()) {
        t = ab[x - 1] + a[i - 1] + b[i - 1];
      }
    }
    answer = min(answer, t);
  }
  if (answer == 2e9 + 10) {
    answer = -1;
  }
  cout << answer;
}
