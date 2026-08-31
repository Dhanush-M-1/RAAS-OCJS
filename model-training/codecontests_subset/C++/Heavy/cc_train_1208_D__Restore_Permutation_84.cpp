#include <bits/stdc++.h>
using namespace std;
const int MX = 200005;
vector<int> v;
long long n, a[MX], w[MX], tree[MX * 4 + 5];
long long con(int num, int nodeL, int nodeR) {
  if (nodeL == nodeR) return tree[num] = w[nodeL];
  long long mid = (nodeL + nodeR) / 2;
  return tree[num] =
             con(num * 2, nodeL, mid) + con(num * 2 + 1, mid + 1, nodeR);
}
long long sum(int L, int R, int num, int nodeL, int nodeR) {
  if (nodeR < L || nodeL > R) return 0;
  if (nodeL >= L && nodeR <= R) return tree[num];
  int mid = (nodeL + nodeR) / 2;
  return sum(L, R, num * 2, nodeL, mid) +
         sum(L, R, num * 2 + 1, mid + 1, nodeR);
}
long long upd(int idx, int num, int nodeL, int nodeR) {
  if (nodeL > idx || nodeR < idx) return 0;
  if (nodeL == nodeR) return tree[num] = 0;
  int mid = (nodeL + nodeR) / 2;
  upd(idx, num * 2, nodeL, mid);
  upd(idx, num * 2 + 1, mid + 1, nodeR);
  if (nodeL <= idx && nodeR >= idx) {
    tree[num] = tree[num * 2] + tree[num * 2 + 1];
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; i++) {
    w[i] = i + 1;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  con(1, 0, n - 1);
  for (int i = n - 1; i >= 0; i--) {
    int s = 0, e = n - 1;
    while (s <= e) {
      int m = (s + e) / 2;
      long long u = sum(0, m, 1, 0, n - 1);
      if (u <= a[i]) {
        s = m + 1;
      } else {
        e = m - 1;
      }
    }
    v.push_back(s + 1);
    upd(s, 1, 0, n - 1);
  }
  for (int i = v.size() - 1; i >= 0; i--) {
    cout << v[i] << " ";
  }
}
