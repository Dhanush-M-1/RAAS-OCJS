#include <bits/stdc++.h>
using namespace std;
long long func(int x, int y) { return 100000 * (long long)x + y; }
vector<pair<pair<int, int>, int> > diag[200100], xaxis[200100], yaxis[200100];
int main() {
  int i, j, k, n, X, Y;
  cin >> n;
  int x[n], y[n], first[n], second[n], third[n];
  fill(first, first + n, -1);
  fill(second, second + n, -1);
  fill(third, third + n, -1);
  unordered_map<long long, int> H;
  vector<pair<pair<int, int>, int> > v, u;
  for (i = 0; i < n; i++) {
    scanf("%d %d", &x[i], &y[i]);
    H[func(x[i], y[i])] = 1;
    v.push_back(make_pair(make_pair(x[i], y[i]), i));
    u.push_back(make_pair(make_pair(y[i], x[i]), i));
  }
  sort(v.begin(), v.end());
  sort(u.begin(), u.end());
  for (i = 0; i < v.size(); i++) {
    X = v[i].first.first;
    Y = v[i].first.second;
    diag[X - Y + 100050].push_back(v[i]);
    xaxis[Y + 100050].push_back(v[i]);
  }
  for (i = 0; i < u.size(); i++) {
    X = u[i].first.second;
    Y = u[i].first.first;
    yaxis[X + 100050].push_back(u[i]);
  }
  for (i = 0; i < 200099; i++) {
    for (j = diag[i].size() - 1; j >= 0; j--) {
      first[diag[i][j].second] = j;
    }
    for (j = xaxis[i].size() - 1; j >= 0; j--) {
      second[xaxis[i][j].second] = j;
    }
    for (j = yaxis[i].size() - 1; j >= 0; j--) {
      third[yaxis[i][j].second] = j;
    }
  }
  int val, x1, y1, cnt = 0;
  for (i = 0; i < n; i++) {
    if (first[i] < second[i] && first[i] < third[i]) {
      val = x[i] - y[i] + 100050;
      for (j = 0; j < first[i]; j++) {
        x1 = diag[val][j].first.first;
        y1 = diag[val][j].first.second;
        if (H[func(x1, y[i])]) {
          if (H[func(x[i], y1)]) cnt++;
        }
      }
    } else if (second[i] < third[i]) {
      val = y[i] + 100050;
      for (j = 0; j < second[i]; j++) {
        x1 = xaxis[val][j].first.first;
        y1 = y[i] + x1 - x[i];
        if (H[func(x[i], y1)]) {
          if (H[func(x1, y1)]) cnt++;
        }
      }
    } else {
      val = x[i] + 100050;
      for (j = 0; j < third[i]; j++) {
        y1 = yaxis[val][j].first.first;
        x1 = x[i] + y1 - y[i];
        if (H[func(x1, y[i])]) {
          if (H[func(x1, y1)]) cnt++;
        }
      }
    }
  }
  cout << cnt;
  return 0;
}
