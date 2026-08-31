#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, i, y, count = 1;
  cin >> n;
  vector<pair<long long, long long>> v;
  for (i = 0; i < n; i++) {
    cin >> x >> y;
    v.push_back(make_pair(x, y));
  }
  long last = v[n - 1].second + v[n - 1].first + 1;
  for (i = n - 1; i > 0; i--) {
    if (v[i].first + v[i].second < last) {
      last = v[i].first;
      count++;
    } else if (i != 0 && v[i].first - v[i].second > v[i - 1].first) {
      count++;
      last = v[i].first - v[i].second;
    } else if (v[i].first < last) {
      last = v[i].first;
    }
  }
  cout << count << endl;
  return 0;
}
