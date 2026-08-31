#include <bits/stdc++.h>
using namespace std;
int n, f[110][110 * 110];
pair<int, int> x[110];
bool cmp(pair<int, int> a, pair<int, int> b) { return a.second > b.second; }
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  int sum = 0;
  for (int i = 1; i <= n; i++) cin >> x[i].first, sum += x[i].first;
  for (int i = 1; i <= n; i++) cin >> x[i].second;
  sort(x + 1, x + n + 1, cmp);
  int vt = 0, temp = 0;
  for (int i = 1; i <= n; i++) {
    temp += x[i].second;
    if (temp >= sum) {
      vt = i;
      break;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = min(i - 1, vt); j >= 1; j--)
      for (int k = sum + 1; k >= 0; k--) {
        if (f[j][k] == 0) continue;
        if (k + x[i].second > sum) {
          f[j + 1][sum + 1] = max(f[j + 1][sum + 1], f[j][k] + x[i].first);
        } else
          f[j + 1][k + x[i].second] =
              max(f[j + 1][k + x[i].second], f[j][k] + x[i].first);
      }
    f[1][min(sum + 1, x[i].second)] =
        max(f[1][min(sum + 1, x[i].second)], x[i].first);
  }
  cout << vt << " ";
  cout << sum - max(f[vt][sum], f[vt][sum + 1]);
}
