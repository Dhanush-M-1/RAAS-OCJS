#include <bits/stdc++.h>
using namespace std;
int getMaxTrees(int n, vector<int> points, vector<int> heights, vector<int> t) {
  if (n == 0) {
    return 1;
  }
  int left = 0;
  int right = 0;
  int mid = 0;
  if (heights[n] + points[n] < points[n + 1]) {
    if (t[n + 1]) {
      if (heights[n] + points[n] < t[n + 1]) {
        t[n] = heights[n] + points[n];
        right = getMaxTrees(n - 1, points, heights, t);
      }
    } else {
      t[n] = heights[n] + points[n];
      right = getMaxTrees(n - 1, points, heights, t);
    }
  }
  if (points[n] - heights[n] > points[n - 1]) {
    if (t[n - 1]) {
      if (points[n] - heights[n] > t[n - 1]) {
        t[n] = points[n] - heights[n];
        left = getMaxTrees(n - 1, points, heights, t);
      }
    } else {
      t[n] = points[n] - heights[n];
      left = getMaxTrees(n - 1, points, heights, t);
    }
  }
  mid = getMaxTrees(n - 1, points, heights, t);
  if (left || right) {
    return 1 + max(max(left, right), mid);
  }
  return mid;
}
void solve() {
  long long n;
  cin >> n;
  vector<long long> points(n + 1);
  vector<long long> heights(n);
  vector<long long> t(n + 1, 0);
  for (long long i = 0; i < n; i++) {
    cin >> points[i] >> heights[i];
  }
  if (n <= 2) {
    cout << n << endl;
    return;
  }
  long long trees = 2;
  for (long long i = 1; i < n - 1; i++) {
    if (points[i] - heights[i] > (t[i - 1] > 0 ? t[i - 1] : points[i - 1])) {
      trees++;
    } else {
      if (points[i] + heights[i] < points[i + 1]) {
        t[i] = points[i] + heights[i];
        trees++;
      }
    }
  }
  cout << trees << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  t = 1;
  while (t--) {
    solve();
  }
}
