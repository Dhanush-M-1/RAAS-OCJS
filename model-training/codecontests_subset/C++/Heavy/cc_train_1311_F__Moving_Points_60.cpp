#include <bits/stdc++.h>
using namespace std;
struct Point {
  long long x;
  long long v;
};
vector<Point> points;
long long SUM;
void add_pairwise_dist(long long start, long long end) {
  int m, i, j;
  if (start == end) return;
  m = start + (end - start) / 2;
  add_pairwise_dist(start, m);
  add_pairwise_dist(m + 1, end);
  vector<long long> rcumsum(end - start + 2);
  for (i = end; i >= start; i--) {
    rcumsum[i - start] = rcumsum[i - start + 1] + points[i].x;
  }
  j = m + 1;
  for (i = start; i <= m; i++) {
    while (j <= end && points[i].v > points[j].v) j++;
    if (j > end) break;
    SUM += rcumsum[j - start] - points[i].x * (end - j + 1);
  }
  vector<Point> temp(end - start + 1);
  i = start;
  j = m + 1;
  for (int k = 0; k < end - start + 1; k++) {
    if (i > m) {
      temp[k] = points[j++];
    } else if (j > end) {
      temp[k] = points[i++];
    } else if (points[i].v < points[j].v) {
      temp[k] = points[i++];
    } else {
      temp[k] = points[j++];
    }
  }
  for (int k = 0; k < end - start + 1; k++) {
    points[start + k] = temp[k];
  }
}
int main() {
  int n;
  cin >> n;
  points.resize(n);
  for (int i = 0; i < n; i++) cin >> points[i].x;
  for (int i = 0; i < n; i++) cin >> points[i].v;
  sort(points.begin(), points.end(),
       [](const Point &a, Point const &b) { return a.x < b.x; });
  add_pairwise_dist(0, n - 1);
  cout << SUM << endl;
}
