#include <bits/stdc++.h>
using namespace std;
vector<int> adj[1001];
vector<int> firsts;
int calculateDistance(int currPos, int prev) {
  if (adj[currPos].size() == 0) return 1;
  if (adj[currPos].size() == 1 && prev != 0) return 1;
  for (auto next : adj[currPos]) {
    if (next != prev) return 1 + calculateDistance(next, currPos);
  }
}
int findFirstQ(int curr, int prev) {
  if (adj[curr].size() == 0) return curr;
  if (adj[curr].size() == 1 && adj[curr][0] == prev) return curr;
  for (auto next : adj[curr]) {
    if (next != prev) return findFirstQ(next, curr);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, x;
  scanf("%d %d", &n, &x);
  int a, prevSmartBeaver = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a);
    if (a != 0) {
      adj[i].push_back(a);
      adj[a].push_back(i);
    } else {
      firsts.push_back(i);
    }
    if (a == x) prevSmartBeaver = i;
  }
  int distSmartBeaver = calculateDistance(x, prevSmartBeaver);
  int firstElQSmartB = findFirstQ(x, prevSmartBeaver);
  vector<int> lEachQ;
  lEachQ.push_back(0);
  for (auto v : firsts) {
    if (v != firstElQSmartB) lEachQ.push_back(calculateDistance(v, 0));
  }
  sort(lEachQ.begin(), lEachQ.begin() + lEachQ.size());
  bool possible[1001] = {false};
  possible[0] = true;
  for (int k = 1; k <= lEachQ.size() - 1; k++) {
    for (int w = n; w >= 0; w--) {
      if (possible[w]) possible[w + lEachQ[k]] = true;
    }
  }
  for (int i = 0; i <= n; i++) {
    if (possible[i]) cout << i + distSmartBeaver << "\n";
  }
  return 0;
}
