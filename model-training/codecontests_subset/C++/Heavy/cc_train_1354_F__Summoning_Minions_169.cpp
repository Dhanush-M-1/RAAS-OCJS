#include <bits/stdc++.h>
using namespace std;
const pair<long long, long long> IMPOSSIBLE =
    make_pair(-999999999999999999, -1);
class Minion {
 public:
  long long a, b;
  int minionId;
  bool operator<(const Minion& that) const { return b < that.b; }
  Minion(int ma, int mb, int mid) : a(ma), b(mb), minionId(mid) {}
  Minion() {}
};
vector<int> getMaximumPowerSequence(int n, int k, vector<Minion> minions) {
  sort(minions.begin(), minions.end());
  pair<long long, long long> dp[n + 2][k + 1];
  for (int i = 0; i <= k; i++) dp[n + 1][i] = IMPOSSIBLE;
  dp[n + 1][0] = make_pair(0, -1);
  for (int oi = 0; oi < n; oi++) {
    pair<long long, long long>* olddp = dp[n + 1];
    if (oi > 0) olddp = dp[oi - 1];
    pair<long long, long long>* newdp = dp[oi];
    for (int i = 0; i <= k; i++) newdp[i] = IMPOSSIBLE;
    long long NOT_CHOSEN_BONUS = (long long)(k - 1) * minions[oi].b;
    for (int i = 0; i <= k; i++) {
      newdp[i] = max(newdp[i], make_pair(olddp[i].first + NOT_CHOSEN_BONUS,
                                         olddp[i].second));
      if (i + 1 <= k) {
        long long CHOSEN_BONUS = minions[oi].b * i + minions[oi].a;
        newdp[i + 1] =
            max(newdp[i + 1],
                make_pair(olddp[i].first + CHOSEN_BONUS, (long long)oi));
      }
    }
  }
  int currentStanding = n - 1;
  int toSelect = k;
  stack<int> selectedMinion;
  vector<bool> isSelected(n + 1, false);
  while (toSelect > 0) {
    int nextOffer = dp[currentStanding][toSelect].second;
    selectedMinion.push(minions[nextOffer].minionId);
    isSelected[minions[nextOffer].minionId] = true;
    currentStanding = nextOffer - 1;
    toSelect--;
  }
  vector<int> ans;
  while (selectedMinion.size() > 1) {
    int cm = selectedMinion.top();
    selectedMinion.pop();
    ans.push_back(cm);
  }
  for (int i = 1; i <= n; i++) {
    if (!isSelected[i]) {
      ans.push_back(i);
      ans.push_back(-i);
    }
  }
  while (selectedMinion.size() > 0) {
    int cm = selectedMinion.top();
    selectedMinion.pop();
    ans.push_back(cm);
  }
  return ans;
}
int main() {
  int tc;
  scanf("%d", &tc);
  while (tc--) {
    int n, k;
    scanf("%d%d", &n, &k);
    vector<Minion> minions;
    for (int i = 1; i <= n; i++) {
      int a, b;
      scanf("%d%d", &a, &b);
      minions.push_back(Minion(a, b, i));
    }
    vector<int> answer_sequence = getMaximumPowerSequence(n, k, minions);
    printf("%d\n", answer_sequence.size());
    for (int v : answer_sequence) printf("%d ", v);
    printf("\n");
  }
  return 0;
}
