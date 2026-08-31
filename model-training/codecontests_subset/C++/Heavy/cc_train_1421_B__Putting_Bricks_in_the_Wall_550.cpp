#include <bits/stdc++.h>
using namespace std;
int t, n;
vector<pair<int, int> > ho1, ho2;
char a[207][207];
int main() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      cin >> a[i] + 1;
    }
    ho1.clear();
    ho2.clear();
    if (a[1][2] == '0') {
      ho1.push_back({1, 2});
    } else
      ho2.push_back({1, 2});
    if (a[2][1] == '0') {
      ho1.push_back({2, 1});
    } else
      ho2.push_back({2, 1});
    if (a[n][n - 1] == '1') {
      ho1.push_back({n, n - 1});
    } else
      ho2.push_back({n, n - 1});
    if (a[n - 1][n] == '1') {
      ho1.push_back({n - 1, n});
    } else
      ho2.push_back({n - 1, n});
    if (ho1.size() > ho2.size()) {
      printf("%d\n", ho2.size());
      for (int i = 0; i < ho2.size(); i++) {
        printf("%d %d\n", ho2[i].first, ho2[i].second);
      }
    } else {
      printf("%d\n", ho1.size());
      for (int i = 0; i < ho1.size(); i++) {
        printf("%d %d\n", ho1[i].first, ho1[i].second);
      }
    }
  }
}
