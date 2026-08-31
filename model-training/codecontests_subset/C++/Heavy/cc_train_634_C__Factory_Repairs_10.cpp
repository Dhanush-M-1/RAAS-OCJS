#include <bits/stdc++.h>
using namespace std;
const int maxn = 500000;
int len = 1;
int a, b;
vector<vector<int>> tree(maxn, vector<int>(2, 0));
void update(int ind, int i, int x) {
  int curr = len + i;
  int delta;
  if (ind == 0) {
    delta = min(a, tree[curr][0] + x);
  } else {
    delta = min(b, tree[curr][1] + x);
  }
  delta -= tree[curr][ind];
  while (curr != 0) {
    tree[curr][ind] += delta;
    curr /= 2;
  }
}
int get_sum(int ind, int l, int r) {
  int currL = len + l;
  int currR = len + r;
  int ans = 0;
  while (currL <= currR) {
    if (currL % 2 == 1) {
      ans += tree[currL][ind];
    }
    if (currR % 2 == 0) {
      ans += tree[currR][ind];
    }
    currL = (currL + 1) / 2;
    currR = (currR - 1) / 2;
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  while (len < n) len *= 2;
  int type, di, ai;
  for (int i = 0; i < q; ++i) {
    cin >> type;
    if (type == 1) {
      cin >> di >> ai;
      update(0, di - 1, ai);
      update(1, di - 1, ai);
    } else {
      cin >> di;
      cout << get_sum(1, 0, di - 2) + get_sum(0, di + k - 1, n - 1) << "\n";
    }
  }
}
