#include <bits/stdc++.h>
using namespace std;
const int N = 100001;
bool heavy[N];
vector<int> x[N], y[N];
bool check(int xx, int yy) {
  return binary_search(x[xx].begin(), x[xx].end(), yy);
}
int main() {
  int n, ans = 0;
  cin >> n;
  int mx = (int)sqrt(n + .0);
  for (int i = 0; i < n; i++) {
    int px, py;
    cin >> px >> py;
    x[px].push_back(py);
  }
  for (int i = 0; i < N; i++) {
    sort(x[i].begin(), x[i].end());
    if (x[i].size() >= mx) heavy[i] = 1;
  }
  for (int i = 0; i < N; i++)
    if (!heavy[i])
      for (int j = 0; j < x[i].size(); j++)
        for (int k = j + 1; k < x[i].size(); k++) {
          int y1 = x[i][j], y2 = x[i][k], d = y2 - y1;
          if (check(i + d, y1) && check(i + d, y2)) ans++;
          if (i >= d && heavy[i - d] && check(i - d, y1) && check(i - d, y2))
            ans++;
        }
    else
      for (int j = 0; j < x[i].size(); j++) y[x[i][j]].push_back(i);
  for (int i = 0; i < N; i++)
    for (int j = 0; j < y[i].size(); j++)
      for (int k = j + 1; k < y[i].size(); k++) {
        int x1 = y[i][j], x2 = y[i][k], d = x2 - x1;
        if (heavy[x1] && heavy[x2] && check(x1, i + d) && check(x2, i + d))
          ans++;
      }
  cout << ans << endl;
  return 0;
}
