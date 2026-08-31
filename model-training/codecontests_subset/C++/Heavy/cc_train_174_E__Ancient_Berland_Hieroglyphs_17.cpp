#include <bits/stdc++.h>
using namespace std;
const int sz = 1000001;
int a[sz], b[sz], wh[sz], ans = 0;
list<int> c;
bool Next = 0;
void add(int i) {
  c.push_back(i);
  if (c.front() > i) Next = 1;
}
bool good(int t) {
  return c.empty() || !Next && (t > c.back() || t < c.front()) ||
         Next && t < c.front() && t > c.back();
}
void solve(int i) {
  int t = wh[a[i]];
  if (t == 0) {
    Next = 0;
    c.clear();
    return;
  } else
    t--;
  while (!good(t)) {
    int u = c.front();
    c.pop_front();
    if (c.empty() || u > c.front()) Next = 0;
  }
  add(t);
  ans = max(ans, (int)c.size());
}
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]);
    wh[b[i]] = i + 1;
  }
  for (int i = 0; i < n; i++) solve(i);
  for (int i = 0; i < n; i++) solve(i);
  cout << ans;
}
