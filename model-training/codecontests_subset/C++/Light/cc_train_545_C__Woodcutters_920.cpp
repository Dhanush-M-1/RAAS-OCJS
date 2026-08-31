#include <bits/stdc++.h>
using namespace std;
const int N = 0;
int n, k, x, t;
string s;
vector<pair<int, int>> v;
int main() {
  scanf("%d", &n);
  for (int i = 0, a, b; i < n; i++) {
    scanf("%d%d", &a, &b);
    v.push_back({a, b});
  }
  int ans = min(n, 2);
  int prev = v[0].first;
  for (int i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > prev) {
      ans++;
      prev = v[i].first;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      ans++;
      prev = v[i].first + v[i].second;
    } else {
      prev = v[i].first;
    }
  }
  printf("%d\n", ans);
  return 0;
}
