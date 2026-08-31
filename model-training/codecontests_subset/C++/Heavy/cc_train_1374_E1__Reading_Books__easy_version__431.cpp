#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9 + 1;
int n, m, k, p1, p2, sum = 0, sumSmall = 0, minVal = INF;
pair<int, int> rs;
vector<pair<int, int> > a[2][2];
set<pair<int, int> > small, large;
void updateSmall(pair<int, int> val, int type) {
  if (type == 0) {
    small.insert(val);
    sumSmall += val.first;
  } else {
    small.erase(small.find(val));
    sumSmall -= val.first;
  }
}
void balance() {
  while (small.size() > m - p1 - 2 * p2 - 3) {
    large.insert(*small.rbegin());
    updateSmall(*small.rbegin(), 1);
  }
  while (small.size() < m - p1 - 2 * p2 - 3) {
    updateSmall(*large.begin(), 0);
    large.erase(large.begin());
  }
  while (small.size() > 0 && large.size() > 0) {
    pair<int, int> p1 = *small.rbegin();
    pair<int, int> p2 = *large.begin();
    if (p1.first <= p2.first) break;
    updateSmall(p1, 1);
    large.erase(large.find(p2));
    updateSmall(p2, 0);
    large.insert(p1);
  }
}
void init() {
  p1 = min((int)a[1][1].size(), k) - 1,
  p2 = max(k - (int)a[1][1].size(), 0) - 1;
  for (int i = 0; i <= p1; i++) sum += a[1][1][i].first;
  for (int i = 0; i <= p2; i++) sum += a[0][1][i].first + a[1][0][i].first;
  for (int i = p1 + 1; i < a[1][1].size(); i++) updateSmall(a[1][1][i], 0);
  for (int i = p2 + 1; i < a[0][1].size(); i++) updateSmall(a[0][1][i], 0);
  for (int i = p2 + 1; i < a[1][0].size(); i++) updateSmall(a[1][0][i], 0);
  for (int i = 0; i < a[0][0].size(); i++) updateSmall(a[0][0][i], 0);
  balance();
  minVal = sum + sumSmall;
  rs = pair<int, int>(p1, p2);
}
void process() {
  while (p1 >= 0) {
    updateSmall(a[1][1][p1], 0);
    sum -= a[1][1][p1--].first;
    p2++;
    if (p2 >= min(a[0][1].size(), a[1][0].size())) return;
    if (m - p1 - 2 * p2 - 3 < 0) return;
    sum += a[0][1][p2].first + a[1][0][p2].first;
    if (small.find(a[0][1][p2]) != small.end())
      updateSmall(a[0][1][p2], 1);
    else
      large.erase(large.find(a[0][1][p2]));
    if (small.find(a[1][0][p2]) != small.end())
      updateSmall(a[1][0][p2], 1);
    else
      large.erase(large.find(a[1][0][p2]));
    balance();
    if (minVal > sum + sumSmall) {
      minVal = sum + sumSmall;
      rs = pair<int, int>(p1, p2);
    }
  }
}
void print() {
  cout << minVal << '\n';
  for (int i = 0; i <= rs.first; i++) cout << a[1][1][i].second << ' ';
  for (int i = 0; i <= rs.second; i++)
    cout << a[0][1][i].second << ' ' << a[1][0][i].second << ' ';
  vector<pair<int, int> > comb;
  for (int i = 0; i < a[0][0].size(); i++) comb.push_back(a[0][0][i]);
  for (int i = rs.first + 1; i < a[1][1].size(); i++)
    comb.push_back(a[1][1][i]);
  for (int i = rs.second + 1; i < a[0][1].size(); i++)
    comb.push_back(a[0][1][i]);
  for (int i = rs.second + 1; i < a[1][0].size(); i++)
    comb.push_back(a[1][0][i]);
  sort(comb.begin(), comb.end());
  int rem = m - rs.first - 2 * rs.second - 3;
  for (int i = 0; i < rem; i++) cout << comb[i].second << ' ';
}
int main() {
  cin >> n >> m >> k;
  int t, x, y;
  for (int i = 1; i <= n; i++) {
    cin >> t >> x >> y;
    a[x][y].push_back(pair<int, int>(t, i));
  }
  for (int i = 0; i <= 1; i++)
    for (int j = 0; j <= 1; j++) sort(a[i][j].begin(), a[i][j].end());
  if (a[1][1].size() + min(a[1][0].size(), a[0][1].size()) < k ||
      min((int)a[1][1].size(), m) + 2 * max(k - (int)a[1][1].size(), 0) > m) {
    cout << -1;
    return 0;
  }
  init();
  process();
  print();
}
