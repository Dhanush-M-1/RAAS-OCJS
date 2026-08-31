#include <bits/stdc++.h>
using namespace std;
int n;
long long s[200001];
int used[200001];
long long stree[800001];
int result[200001];
long long update(int node, int l, int r, int index, long long diff) {
  if (r < index || index < l) return stree[node];
  if (r == l) {
    stree[node] += diff;
    return stree[node];
  };
  return stree[node] = update(node * 2, l, (l + r) / 2, index, diff) +
                       update(node * 2 + 1, (l + r) / 2 + 1, r, index, diff);
}
long long query(int node, int l, int r, int left, int right) {
  if (r < left || l > right) return 0;
  if (l >= left && r <= right) return stree[node];
  return query(node * 2, l, (l + r) / 2, left, right) +
         query(node * 2 + 1, (l + r) / 2 + 1, r, left, right);
}
int bsearch(long long c) {
  int mi = 1;
  int ma = n;
  if (c == 0 && used[1] == 0) return 0;
  while (mi + 1 < ma) {
    int mid = (mi + ma) / 2;
    long long res = query(1, 1, n, 1, mid);
    if (res <= c)
      mi = mid;
    else
      ma = mid;
  }
  return mi;
}
int main(void) {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  for (int i = 1; i <= n; i++) {
    update(1, 1, n, i, i);
  }
  for (int i = n; i >= 1; i--) {
    result[i] = bsearch(s[i]) + 1;
    update(1, 1, n, result[i], -result[i]);
    used[result[i]] = 1;
  }
  for (int i = 1; i <= n; i++) {
    cout << result[i] << " ";
  }
}
