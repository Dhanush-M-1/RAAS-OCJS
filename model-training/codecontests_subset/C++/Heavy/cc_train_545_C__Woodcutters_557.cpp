#include <bits/stdc++.h>
using namespace std;
int pos[100005];
pair<int, int> tree[100005];
bool func(pair<int, int> x, pair<int, int> y) { return (x.first) < (y.first); }
int main() {
  int n;
  for (int i = 1; i < 100005; i++) {
    pos[i] = 2e9 + 1000;
  }
  pos[0] = -2e9;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &tree[i].first, &tree[i].second);
  }
  sort(tree, tree + n, func);
  int mx = 0, g;
  for (int i = 0; i < n; i++) {
    if (i != 0 && tree[i].first - tree[i].second <= tree[i - 1].first) {
    } else {
      g = lower_bound(pos, pos + n, tree[i].first - tree[i].second) - pos;
      pos[g] = min(pos[g], tree[i].first);
      mx = max(mx, g);
    }
    if (i != n - 1 && tree[i].first + tree[i].second >= tree[i + 1].first) {
    } else {
      g = lower_bound(pos, pos + n, tree[i].first) - pos;
      pos[g] = min(pos[g], tree[i].first + tree[i].second);
      mx = max(mx, g);
    }
  }
  printf("%d", mx);
}
