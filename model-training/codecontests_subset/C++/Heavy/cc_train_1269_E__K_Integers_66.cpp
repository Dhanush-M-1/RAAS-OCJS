#include <bits/stdc++.h>
const int maxn = 2e5 + 10;
const int maxm = 1e5 + 10;
const long long int mod = 1e9 + 7;
const long long int INF = 1e18 + 100;
const int inf = 0x3f3f3f3f;
const double pi = acos(-1.0);
const double eps = 1e-8;
using namespace std;
int n, m;
int cas, tol, T;
set<int> st;
int a[maxn], p[maxn];
long long int sum[maxn];
void update(int x) {
  for (int i = x; i; i -= i & (-i)) sum[i]++;
}
long long int query(int x) {
  if (x == 0) return 0;
  int ans = 0;
  for (int i = x; i <= n; i += i & (-i)) ans += sum[i];
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), p[a[i]] = i;
  long long int ans = 0, k = 0;
  printf("0 ");
  update(p[1]);
  st.insert(p[1]);
  auto it = st.begin();
  for (int i = 2; i <= n; i++) {
    ans -= min(query(p[i] + 1), i - 1 - query(p[i] + 1));
    ans += query(p[i] + 1);
    update(p[i]), st.insert(p[i]);
    if (i % 2 == 0 && p[i] < (*it)) ans += abs((*it) - (*(--it))) - 1;
    if (i % 2 == 1 && p[i] > (*it)) it++;
    if (p[i] > (*it))
      ans += p[i] - (*it) + 1 - query((*it)) + query(p[i] + 1);
    else
      ans += (*it) - p[i] + 1 - query(p[i]) + query((*it) + 1);
    printf("%lld ", ans);
  }
  return 0;
}
