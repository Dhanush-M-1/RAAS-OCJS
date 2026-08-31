#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a, b;
  vector<pair<int, int>> tree;
  tree.assign(n, make_pair(0, 0));
  for (int i = 0; i < n; i++) cin >> tree[i].first >> tree[i].second;
  int ans[n], left[n], right[n], stay[n];
  ans[0] = 1;
  left[0] = 1;
  right[0] = 1;
  stay[0] = 1;
  for (int i = 1; i < n; i++) {
    stay[i] = max(stay[i - 1], left[i - 1]);
    if (tree[i].first > tree[i - 1].first + tree[i - 1].second)
      stay[i] = max(stay[i], right[i - 1]);
    if (i < n - 1 && tree[i + 1].first > tree[i].first + tree[i].second) {
      right[i] = max(left[i - 1], stay[i - 1]);
      right[i] = max(right[i], right[i - 1]);
      right[i] += 1;
    } else if (i == n - 1) {
      right[i] = max(left[i - 1], stay[i - 1]);
      right[i] = max(right[i], right[i - 1]);
      right[i] += 1;
    } else {
      right[i] = -1000000;
    }
    int temp1 = -1000000;
    if (tree[i].first - tree[i].second > tree[i - 1].first) {
      temp1 = max(left[i - 1], stay[i - 1]);
    }
    if (tree[i].first - tree[i].second >
        tree[i - 1].first + tree[i - 1].second) {
      temp1 = max(temp1, right[i - 1]);
    }
    if (temp1 == -1000000)
      left[i] = temp1;
    else
      left[i] = temp1 + 1;
    ans[i] = max(left[i], right[i]);
    ans[i] = max(ans[i], stay[i]);
  }
  cout << ans[n - 1] << endl;
  return 0;
}
