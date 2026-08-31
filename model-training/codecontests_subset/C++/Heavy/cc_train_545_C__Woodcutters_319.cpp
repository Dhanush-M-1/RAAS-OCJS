#include <bits/stdc++.h>
using namespace std;
int _I() {
  int x;
  scanf("%d", &x);
  return x;
}
struct node {
  int a, b;
  node(){};
  node(int a, int b) {
    this->a = a;
    this->b = b;
  }
  bool operator<(const node &R) const { return b > R.b; }
};
vector<pair<int, int> > arr;
int n;
int dp[100005];
int goo(int idx, int last) {
  if (idx == n) return 0;
  if (dp[idx] != -1) return dp[idx];
  int ans = 0;
  if (arr[idx].first - arr[idx].second > last) {
    ans = max(ans, goo(idx + 1, arr[idx].first) + 1);
  }
  if (arr[idx].first > last &&
      arr[idx].first + arr[idx].second < arr[idx + 1].first) {
    ans = max(ans, goo(idx + 1, arr[idx].first + arr[idx].second) + 1);
  }
  ans = max(ans, goo(idx + 1, max(last, arr[idx].first)));
  return dp[idx] = ans;
}
void solve() {
  n = _I();
  for (int i = 0; i < n; i++) {
    int a = _I();
    int b = _I();
    arr.push_back({a, b});
  }
  arr.push_back({INT_MAX, INT_MAX});
  sort(arr.begin(), arr.end());
  memset(dp, -1, sizeof(dp));
  printf("%d\n", goo(0, INT_MIN));
}
int main() {
  solve();
  return 0;
}
