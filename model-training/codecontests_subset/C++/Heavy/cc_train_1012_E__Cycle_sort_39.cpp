#include <bits/stdc++.h>
using namespace std;
int a[200010], b[200010], nxt[200010], cnt, n, s;
void solve(vector<int> &v, int i, int &j) {
  while (a[j] == a[i]) j++;
  if (j >= n) return;
  if (b[j] == a[i]) {
    swap(a[i], a[j]);
    cnt++;
    v.push_back(j++);
    solve(v, i, nxt[lower_bound(b, b + n, a[i]) - b]);
  }
}
int main() {
  cin >> n >> s;
  for (int i = 0; i < n; i++) {
    scanf("%d", a + i);
    b[i] = a[i];
    nxt[i] = i;
  }
  sort(b, b + n);
  a[n] = b[n] = -1;
  cnt = 0;
  vector<vector<int> > ans;
  for (int i = 0; i < n; i++) {
    if (b[i] == a[i]) continue;
    ans.push_back(vector<int>(1, i));
    cnt++;
    nxt[lower_bound(b, b + n, b[i]) - b] = i + 1;
    auto &v = ans.back();
    solve(v, i, nxt[lower_bound(b, b + n, a[i]) - b]);
    for (int k = 0; k < v.size(); k++) {
      int j0 = v[k];
      int &j = nxt[lower_bound(b, b + n, b[j0]) - b];
      while (b[j0] == b[j]) {
        if (b[j] != a[j]) {
          cnt++;
          vector<int> v1(1, j);
          int j1 = j++;
          solve(v1, j1, nxt[lower_bound(b, b + n, a[j1]) - b]);
          v.insert(v.begin() + k, v1.begin(), v1.end());
        } else
          j++;
      }
    }
  }
  if (cnt > s) {
    printf("-1\n");
  } else if (ans.size() < 3 || s - cnt < 3) {
    printf("%d\n", ans.size());
    while (ans.size() > 0) {
      auto &v = ans.back();
      printf("%d\n", v.size());
      for (int i : v) {
        printf("%d ", i + 1);
      }
      printf("\n");
      ans.pop_back();
    }
  } else {
    int x = max((int)ans.size() - s + cnt, 0), size = 0;
    for (int i = x; i < ans.size(); i++) {
      size += ans[i].size();
    }
    printf("%d\n%d\n", x + 2, size);
    for (int i = x; i < ans.size(); i++) {
      auto &v = ans[i];
      for (int i : v) {
        printf("%d ", i + 1);
      }
    }
    printf("\n%d\n", ans.size() - x);
    for (int i = ans.size() - 1; i >= x; i--) {
      printf("%d ", ans[i][0] + 1);
    }
    printf("\n");
    ans.resize(x);
    while (ans.size() > 0) {
      auto &v = ans.back();
      printf("%d\n", v.size());
      for (int i : v) {
        printf("%d ", i + 1);
      }
      printf("\n");
      ans.pop_back();
    }
  }
  return 0;
}
