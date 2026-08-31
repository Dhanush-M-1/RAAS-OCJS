#include <bits/stdc++.h>
using namespace std;
const int N = 5e5 + 99;
int n, k, m, x, y, p0, p1, p2, b0, b1, b2, b3, a[N];
vector<pair<long long, int> > v0, v1, v2, v3;
long long ans = 1e18, sum;
void calc(int x) {
  if (p0 < v0.size() - 1) p0++, sum += v0[p0].first;
  if (p0 < v0.size() - 1) p0++, sum += v0[p0].first;
  if (k - x >= int(v1.size()) || k - x >= int(v2.size()) ||
      x + v2.size() + v1.size() + v0.size() - 3 < m ||
      x + max((k - x), 0) * 2 > m)
    return;
  while (x + p1 + p2 + p0 > m) {
    if (p0 && (p1 == max(k - x, 0) || v0[p0] >= v1[p1]) &&
        (p2 == max(k - x, 0) || v0[p0] >= v2[p2]))
      sum -= v0[p0--].first;
    else {
      if (p1 == max(k - x, 0) ||
          (p2 != max(k - x, 0) && v2[p2].first >= v1[p1].first)) {
        while (p2 == max(k - x, 0)) n = 1;
        sum -= v2[p2--].first;
      } else
        sum -= v1[p1--].first;
    }
  }
  if (sum + v3[x].first < ans)
    ans = sum + v3[x].first, b0 = p0, b1 = p1, b2 = p2, b3 = x;
}
int main() {
  cin >> n >> m >> k;
  v1.push_back(make_pair(0, 0)), v2.push_back(make_pair(0, 0)),
      v3.push_back(make_pair(0, 0)), v0.push_back(make_pair(0, 0));
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    ;
    scanf("%d%d", &x, &y);
    ;
    if (x == 1 && y == 1) v3.push_back(make_pair(a[i], i + 1));
    if (x == 1 && y == 0) v1.push_back(make_pair(a[i], i + 1));
    if (x == 0 && y == 1) v2.push_back(make_pair(a[i], i + 1));
    if (x == 0 && y == 0) v0.push_back(make_pair(a[i], i + 1));
  }
  p0 = v0.size() - 1, p1 = v1.size() - 1, p2 = v2.size() - 1;
  sort(v0.begin(), v0.end());
  sort(v1.begin(), v1.end());
  sort(v2.begin(), v2.end());
  sort(v3.begin(), v3.end());
  for (int i = 1; i < v0.size(); i++) sum += v0[i].first;
  for (int i = 1; i < v1.size(); i++) sum += v1[i].first;
  for (int i = 1; i < v2.size(); i++) sum += v2[i].first;
  for (int i = 1; i < v3.size(); i++) v3[i].first += v3[i - 1].first;
  for (int i = 0; i < v3.size(); i++) calc(i);
  if (ans == 1e18) return cout << -1, 0;
  cout << ans << endl;
  for (int i = 1; i < b0 + 1; i++) cout << v0[i].second << " ";
  for (int i = 1; i < b1 + 1; i++) cout << v1[i].second << " ";
  for (int i = 1; i < b2 + 1; i++) cout << v2[i].second << " ";
  for (int i = 1; i < b3 + 1; i++) cout << v3[i].second << " ";
}
