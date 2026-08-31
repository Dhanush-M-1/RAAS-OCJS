#include <bits/stdc++.h>
using namespace std;
long long tree1[200010], tree2[200010], cur1[200010], cur2[200010];
void update(int ind, long long dif1, long long dif2) {
  for (int i = ind; i < 200010; i = i + (i & (-1 * i)))
    tree1[i] += dif1, tree2[i] += dif2;
}
long long query1(long long a) {
  long long ans = 0;
  for (int i = a; i > 0; i = i - (i & (-1 * i))) ans += tree1[i];
  return ans;
}
long long getrg1(long long a, long long b) {
  if (a > b) return 0;
  if (a <= 1) return query1(b);
  return query1(b) - query1(a - 1);
}
long long query2(long long a) {
  long long ans = 0;
  for (int i = a; i > 0; i = i - (i & (-1 * i))) ans += tree2[i];
  return ans;
}
long long getrg2(long long a, long long b) {
  if (a > b) return 0;
  if (a <= 1) return query2(b);
  return query2(b) - query2(a - 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, x;
      cin >> d >> x;
      long long old1 = cur1[d];
      long long old2 = cur2[d];
      cur1[d] = min(b, cur1[d] + x);
      cur2[d] = min(a, cur2[d] + x);
      update(d, cur1[d] - old1, cur2[d] - old2);
    } else {
      int d;
      cin >> d;
      cout << getrg1(1, d - 1) + getrg2(d + k, n) << '\n';
    }
  }
}
