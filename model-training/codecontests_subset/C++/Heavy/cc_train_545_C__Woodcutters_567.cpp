#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int x, y, i, j, k;
  int n;
  cin >> n;
  pair<int, int> a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i].first >> a[i].second;
  }
  a[0].second = a[0].first - a[0].second;
  a[n - 1].second = a[n - 1].first - a[n - 1].second;
  k = 0;
  int sum;
  if (n == 1) {
    sum = 1;
  } else {
    sum = 2;
  }
  for (i = 1; i < n - 1; i++) {
    if (a[i].first - a[i - 1].first > a[i].second &&
        a[i].first - a[i - 1].second > a[i].second) {
      a[i].second = a[i].first - a[i].second;
      sum += 1;
    } else if (a[i + 1].first - a[i].first > a[i].second) {
      a[i].second = a[i].first + a[i].second;
      sum += 1;
    } else {
      sum += 0;
      a[i].second = a[i].first;
    }
  }
  cout << sum << endl;
}
