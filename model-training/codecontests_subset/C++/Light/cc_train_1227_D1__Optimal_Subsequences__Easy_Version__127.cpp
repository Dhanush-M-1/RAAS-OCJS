#include <bits/stdc++.h>
using namespace std;
int n, m;
pair<int, int> a[112];
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    a[i] = {-num, i};
  }
  sort(a, a + n);
  cin >> m;
  for (int i = 1; i <= m; i++) {
    int k, pos;
    cin >> k >> pos;
    vector<pair<int, int> > sub;
    for (int j = 0; j < k; j++) {
      sub.push_back({a[j].second, -a[j].first});
    }
    sort(sub.begin(), sub.end());
    cout << sub[pos - 1].second << "\n";
  }
}
