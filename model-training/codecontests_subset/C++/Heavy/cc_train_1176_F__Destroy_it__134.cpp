#include <bits/stdc++.h>
using namespace std;
using lint = long long;
using ulint = unsigned long long;
const int T = 10;
lint dp[T], nxt[T];
void relax(lint &x, lint y) { x = max(x, y); }
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  fill(begin(dp), end(dp), -1);
  fill(begin(nxt), end(nxt), -1);
  int n;
  cin >> n;
  dp[0] = 0;
  while (n--) {
    int k;
    cin >> k;
    vector<lint> cards[4];
    for (int i = 0; i < k; i++) {
      int c, d;
      cin >> c >> d;
      cards[c].push_back(d);
    }
    for (auto &vec : cards) {
      sort(vec.begin(), vec.end(), greater<lint>());
    }
    for (int i = 0; i < T; i++) {
      if (dp[i] == -1) continue;
      bool flag1 = i + 1 >= T;
      bool flag2 = i + 2 >= T;
      bool flag3 = i + 3 >= T;
      relax(nxt[i], dp[i]);
      if (cards[1].size() >= 1)
        relax(nxt[(i + 1) % T], dp[i] + cards[1][0] * (flag1 + 1));
      if (cards[2].size() >= 1)
        relax(nxt[(i + 1) % T], dp[i] + cards[2][0] * (flag1 + 1));
      if (cards[3].size() >= 1)
        relax(nxt[(i + 1) % T], dp[i] + cards[3][0] * (flag1 + 1));
      if (cards[1].size() >= 2)
        relax(nxt[(i + 2) % T],
              dp[i] + cards[1][0] * (flag2 + 1) + cards[1][1]);
      if (cards[1].size() >= 1 && cards[2].size() >= 1)
        relax(nxt[(i + 2) % T], dp[i] + cards[1][0] + cards[2][0] +
                                    max(cards[1][0], cards[2][0]) * flag2);
      if (cards[1].size() >= 3)
        relax(nxt[(i + 3) % T],
              dp[i] + cards[1][0] * (flag3 + 1) + cards[1][1] + cards[1][2]);
    }
    copy(begin(nxt), end(nxt), begin(dp));
  }
  cout << *max_element(begin(dp), end(dp)) << endl;
}
