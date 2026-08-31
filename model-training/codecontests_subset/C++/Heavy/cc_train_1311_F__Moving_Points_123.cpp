#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
pair<int, int> p[N];
long long sum[N];
long long ans = 0;
int n;
pair<long long, long long> tree[N];
inline int lowbit(int x) { return x & (-x); }
void update(int x, int v) {
  while (x <= n) {
    tree[x].first++;
    tree[x].second += v;
    x += lowbit(x);
  }
}
pair<long long, long long> ask(int x) {
  pair<long long, long long> res;
  res.first = res.second = 0;
  while (x) {
    res.first += tree[x].first;
    res.second += tree[x].second;
    x -= lowbit(x);
  }
  return res;
}
int x[N];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> p[i].first;
  for (int i = 0; i < n; i++) cin >> p[i].second, x[i] = p[i].second;
  sort(x, x + n);
  sort(p, p + n);
  for (int i = 0; i < n; i++)
    p[i].second = lower_bound(x, x + n, p[i].second) - x + 1;
  for (int i = 0; i < n; i++) {
    pair<long long, long long> pai = ask(p[i].second);
    ans += pai.first * p[i].first - pai.second;
    update(p[i].second, p[i].first);
  }
  cout << ans << "\n";
  return 0;
}
