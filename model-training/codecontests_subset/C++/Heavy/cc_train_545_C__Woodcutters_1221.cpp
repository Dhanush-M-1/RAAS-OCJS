#include <bits/stdc++.h>
using namespace std;
long long vis[100001] = {0};
long long col[100000] = {0};
vector<vector<long long> > v(50);
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, i, j;
  cin >> n;
  vector<pair<int, int> > v;
  for (i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    v.push_back(make_pair(x, y));
  }
  if (n == 1) {
    cout << "1";
    return 0;
  }
  if (n == 2) {
    cout << "2";
    return 0;
  }
  int c1 = 2;
  long long max = v[0].first;
  for (i = 1; i < n - 1; i++) {
    if (v[i].first - max > v[i].second) {
      c1++;
      max = v[i].first;
    } else if (v[i + 1].first - v[i].first > v[i].second) {
      c1++;
      max = v[i].second + v[i].first;
    } else
      max = v[i].first;
  }
  cout << c1;
}
