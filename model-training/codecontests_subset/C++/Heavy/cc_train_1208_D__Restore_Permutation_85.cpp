#include <bits/stdc++.h>
using namespace std;
const int M = 200010;
struct BIT {
  long long tree[M];
  BIT() { memset(tree, 0, sizeof tree); }
  void update(int idx, int val) {
    while (idx < M) {
      tree[idx] += val;
      idx += idx & (-idx);
    }
  }
  long long query(int idx) {
    long long sum = 0;
    while (idx > 0) {
      sum += tree[idx];
      idx -= idx & (-idx);
    }
    return sum;
  }
};
long long a[200010];
BIT B;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  long long sum = 0;
  for (int i = 1; i <= n; i++) {
    B.update(i, i);
  }
  vector<int> ans;
  for (int i = n - 1; i >= 0; i--) {
    int l = 1, h = n;
    while (l < h) {
      int m = (l + h) / 2;
      if (B.query(m) > a[i])
        h = m;
      else
        l = m + 1;
    }
    ans.push_back(h);
    B.update(h, -h);
  }
  for (int i = ans.size() - 1; i >= 0; i--) cout << ans[i] << " ";
  cout << endl;
  return 0;
}
