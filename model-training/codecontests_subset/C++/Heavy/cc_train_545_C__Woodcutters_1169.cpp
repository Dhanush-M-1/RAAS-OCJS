#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int>> v;
  for (long long int i = 0; i < n; i++) {
    long long int x, y;
    cin >> x >> y;
    v.push_back({x, y});
  }
  long long int s = v[0].first - v[0].second, e = v[0].first;
  long long int t = 2;
  if (n == 1)
    t = 1;
  else {
    for (long long int i = 1; i < n - 1; i++) {
      if (v[i].first - v[i].second > e) {
        t++;
        e = v[i].first;
      } else if (v[i].first + v[i].second < v[i + 1].first) {
        t++;
        e = v[i].first + v[i].second;
      } else
        e = v[i].first;
    }
  }
  cout << t << endl;
}
