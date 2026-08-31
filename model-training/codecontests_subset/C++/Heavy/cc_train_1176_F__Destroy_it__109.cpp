#include <bits/stdc++.h>
using namespace std;
const int N = 200000;
long long dp[N][10];
int n;
vector<vector<long long> > arr[N];
long long solve(int i, int mod) {
  if (i == n) return 0;
  if (dp[i][mod]) return dp[i][mod];
  long long ans = solve(i + 1, mod);
  if (arr[i][3].size())
    ans = max(ans,
              solve(i + 1, (mod + 1) % 10) + arr[i][3][0] * (mod == 9 ? 2 : 1));
  if (arr[i][2].size())
    ans = max(ans,
              solve(i + 1, (mod + 1) % 10) + arr[i][2][0] * (mod == 9 ? 2 : 1));
  if (arr[i][1].size())
    ans = max(ans,
              solve(i + 1, (mod + 1) % 10) + arr[i][1][0] * (mod == 9 ? 2 : 1));
  if (arr[i][1].size() && arr[i][2].size()) {
    int maxi = max(arr[i][1][0], arr[i][2][0]);
    int mini = min(arr[i][1][0], arr[i][2][0]);
    ans = max(ans,
              solve(i + 1, (mod + 2) % 10) + mini + maxi * (mod >= 8 ? 2 : 1));
  }
  if (arr[i][1].size() >= 2) {
    ans = max(ans, solve(i + 1, (mod + 2) % 10) + arr[i][1][1] +
                       arr[i][1][0] * (mod >= 8 ? 2 : 1));
  }
  if (arr[i][1].size() >= 3) {
    ans = max(ans, solve(i + 1, (mod + 3) % 10) + arr[i][1][2] + arr[i][1][1] +
                       arr[i][1][0] * (mod >= 7 ? 2 : 1));
  }
  return dp[i][mod] = ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int m;
    scanf("%d", &m);
    vector<vector<long long> > cards(4);
    while (m--) {
      long long x, y;
      scanf("%lld%lld", &x, &y);
      cards[x].push_back(y);
    }
    sort(cards[1].rbegin(), cards[1].rend());
    sort(cards[2].rbegin(), cards[2].rend());
    sort(cards[3].rbegin(), cards[3].rend());
    arr[i] = cards;
  }
  printf("%lld", solve(0, 0));
  return 0;
}
