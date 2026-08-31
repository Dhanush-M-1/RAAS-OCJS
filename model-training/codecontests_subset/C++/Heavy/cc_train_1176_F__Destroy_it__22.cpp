#include <bits/stdc++.h>
using namespace std;
int n;
vector<long long> v[3][200043];
long long dp[200043][12];
long long fun(int pos, int cnt) {
  if (pos == n) return 0;
  if (dp[pos][cnt] != -1) return dp[pos][cnt];
  long long ans = fun(pos + 1, cnt);
  ans = max(ans,
            fun(pos + 1, (cnt + 1) % 10) + ((cnt == 9) ? 2 : 1) * v[0][pos][0]);
  ans = max(ans,
            fun(pos + 1, (cnt + 1) % 10) + ((cnt == 9) ? 2 : 1) * v[1][pos][0]);
  ans = max(ans,
            fun(pos + 1, (cnt + 1) % 10) + ((cnt == 9) ? 2 : 1) * v[2][pos][0]);
  ans = max(ans, fun(pos + 1, (cnt + 2) % 10) +
                     ((cnt >= 8) ? 2 : 1) * v[0][pos][0] + v[0][pos][1]);
  ans = max(ans, fun(pos + 1, (cnt + 3) % 10) +
                     ((cnt >= 7) ? 2 : 1) * v[0][pos][0] + v[0][pos][1] +
                     v[0][pos][2]);
  long long mini = min(v[0][pos][0], v[1][pos][0]);
  long long maxi = max(v[0][pos][0], v[1][pos][0]);
  ans = max(ans,
            fun(pos + 1, (cnt + 2) % 10) + ((cnt >= 8) ? 2 : 1) * maxi + mini);
  return dp[pos][cnt] = ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  memset(dp, -1, sizeof(dp));
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    priority_queue<long long> c1;
    long long mini1 = -1e15;
    long long mini2 = -1e15;
    for (int l = 0; l < k; l++) {
      long long c, d;
      cin >> c >> d;
      if (c == 1)
        c1.push(d);
      else if (c == 2)
        mini1 = max(d, mini1);
      else
        mini2 = max(d, mini2);
    }
    int k1 = 0;
    while (k1 < 3 && !c1.empty()) {
      v[0][i].push_back(c1.top());
      c1.pop();
      k1++;
    }
    if (k1 < 3) {
      while (k1 < 3) {
        v[0][i].push_back(-1e15);
        k1++;
      }
    }
    v[1][i].push_back(mini1);
    v[2][i].push_back(mini2);
  }
  long long ans = fun(0, 0);
  cout << ans << endl;
  return 0;
}
