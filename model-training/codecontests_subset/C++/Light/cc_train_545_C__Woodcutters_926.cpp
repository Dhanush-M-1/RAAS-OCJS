#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int count = 1, prev;
  vector<pair<int, int> > v;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    v.push_back({x, y});
  }
  prev = v[0].first;
  for (int i = 1; i < n; i++) {
    if (i == n - 1)
      count++;
    else {
      int a = v[i].first;
      int b = v[i].second;
      if ((a - b) > prev) {
        count++;
        prev = a;
      } else if ((a + b) < v[i + 1].first) {
        prev = a + b;
        count++;
      } else
        prev = a;
    }
  }
  cout << count << "\n";
  return 0;
}
