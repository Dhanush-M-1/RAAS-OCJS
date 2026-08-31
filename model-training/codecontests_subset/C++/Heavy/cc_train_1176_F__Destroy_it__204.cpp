#include <bits/stdc++.h>
using namespace std;
const int INF = numeric_limits<int>::max();
using ll = long long;
using ii = pair<int, int>;
using vi = vector<ll>;
using vvi = vector<vi>;
using vvvi = vector<vvi>;
using vii = vector<ii>;
using vvii = vector<vii>;
using vb = vector<bool>;
using vvb = vector<vb>;
int n;
vvvi cards;
vvi dp;
ll f(int turn, int rem) {
  if (turn == n) return 0;
  if (dp[turn][rem] != -1) return dp[turn][rem];
  ll ans = f(turn + 1, rem);
  if (cards[turn][1].size() >= 1) {
    ans = max(ans, f(turn + 1, (rem + 1) % 10) +
                       cards[turn][1][0] * (rem == 9 ? 2 : 1));
  }
  if (cards[turn][1].size() >= 2) {
    ans = max(ans, f(turn + 1, (rem + 2) % 10) +
                       cards[turn][1][0] * (rem >= 8 ? 2 : 1) +
                       cards[turn][1][1]);
  }
  if (cards[turn][2].size() >= 1) {
    ans = max(ans, f(turn + 1, (rem + 1) % 10) +
                       cards[turn][2][0] * (rem == 9 ? 2 : 1));
  }
  if (cards[turn][1].size() >= 1 && cards[turn][2].size() >= 1) {
    ll mx = max(cards[turn][1][0], cards[turn][2][0]);
    ll mn = min(cards[turn][1][0], cards[turn][2][0]);
    ans = max(ans, f(turn + 1, (rem + 2) % 10) + mx * (rem >= 8 ? 2 : 1) + mn);
  }
  if (cards[turn][1].size() >= 3) {
    ans = max(ans, f(turn + 1, (rem + 3) % 10) +
                       cards[turn][1][0] * (rem >= 7 ? 2 : 1) +
                       cards[turn][1][1] + cards[turn][1][2]);
  }
  if (cards[turn][3].size() >= 1) {
    ans = max(ans, f(turn + 1, (rem + 1) % 10) +
                       cards[turn][3][0] * (rem == 9 ? 2 : 1));
  }
  return dp[turn][rem] = ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  cards = vvvi(n, vvi(4));
  dp = vvi(n, vi(10, -1));
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    while (k--) {
      int c;
      ll d;
      cin >> c >> d;
      cards[i][c].push_back(d);
    }
    for (int c = 1; c <= 3; c++) {
      sort(cards[i][c].rbegin(), cards[i][c].rend());
    }
  }
  cout << f(0, 0);
}
