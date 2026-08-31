#include <bits/stdc++.h>
using namespace std;
int n;
int a[105], b[105];
int sum;
bool visited[105][105 * 105];
pair<int, int> dp[105][105 * 105];
pair<int, int> cal(int pos, int left) {
  if (left <= 0) return make_pair(0, left);
  if (pos > n) return make_pair(1e9, 0);
  assert(left);
  if (visited[pos][left]) return dp[pos][left];
  visited[pos][left] = true;
  return dp[pos][left] = min(
             cal(pos + 1, left),
             make_pair(1 + cal(pos + 1, left - b[pos]).first,
                       b[pos] - a[pos] + cal(pos + 1, left - b[pos]).second));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i], sum += a[i];
  for (int i = 1; i <= n; i++) cin >> b[i];
  cout << cal(1, sum).first << ' ' << cal(1, sum).second << '\n';
}
