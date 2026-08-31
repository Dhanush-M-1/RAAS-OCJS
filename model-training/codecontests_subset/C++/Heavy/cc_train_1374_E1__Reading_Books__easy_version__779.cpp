#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10;
const long long inf = 1e9;
struct node {
  long long num, tim;
} A[N], B[N], C[N], D[N];
bool cmp(node l1, node l2) { return l1.tim < l2.tim; }
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, m, k, x, y, z, a = 0, b = 0, c = 0, d = 0;
  cin >> n >> m >> k;
  for (long long i = 1; i <= n; ++i) {
    cin >> x >> y >> z;
    if (y && z) {
      C[c].num = i;
      C[c++].tim = x;
    } else if (y) {
      A[a].num = i;
      A[a++].tim = x;
    } else if (z) {
      B[b].num = i;
      B[b++].tim = x;
    } else {
      D[d].num = i;
      D[d++].tim = x;
    }
  }
  if (a + c < k || b + c < k) {
    cout << -1 << endl;
    return 0;
  }
  if (c < k && (k - c) * 2 + c > m) {
    cout << -1 << endl;
    return 0;
  }
  sort(A, A + a, cmp);
  sort(B, B + b, cmp);
  sort(C, C + c, cmp);
  sort(D, D + d, cmp);
  long long ai = 0, bi = 0, ci = 0, di = 0, sum = 0;
  for (; ci < c; ++ci) {
    if (ci == k) break;
    sum += C[ci].tim;
  }
  while (ai + ci < k) {
    sum += A[ai].tim + B[bi].tim;
    ai++, bi++;
  }
  while (ai + bi + ci + di < m) {
    long long pro1, pro2, pro3, pro4, pro5;
    if (ai < a && bi < b && ci)
      pro1 = A[ai].tim + B[bi].tim - C[ci - 1].tim;
    else
      pro1 = inf;
    if (ai < a)
      pro2 = A[ai].tim;
    else
      pro2 = inf;
    if (bi < b)
      pro3 = B[bi].tim;
    else
      pro3 = inf;
    if (ci < c)
      pro4 = C[ci].tim;
    else
      pro4 = inf;
    if (di < d)
      pro5 = D[di].tim;
    else
      pro5 = inf;
    long long mini = min(pro1, min(pro2, min(pro3, min(pro4, pro5))));
    if (mini == inf) {
      cout << -1 << endl;
      return 0;
    }
    sum += mini;
    if (mini == pro1 && pro1 < inf)
      ai++, bi++, ci--;
    else if (mini == pro2 && pro2 < inf)
      ai++;
    else if (mini == pro3 && pro3 < inf)
      bi++;
    else if (mini == pro4 && pro4 < inf)
      ci++;
    else if (mini == pro5 && pro5 < inf)
      di++;
  }
  cout << sum << endl;
  for (long long i = 0; i < ai; ++i) cout << A[i].num << " ";
  for (long long i = 0; i < bi; ++i) cout << B[i].num << " ";
  for (long long i = 0; i < ci; ++i) cout << C[i].num << " ";
  for (long long i = 0; i < di; ++i) cout << D[i].num << " ";
  return 0;
}
