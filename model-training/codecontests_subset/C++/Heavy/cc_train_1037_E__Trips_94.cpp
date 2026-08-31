#include <bits/stdc++.h>
using namespace std;
set<long long> V[400010];
long long n, m, k, D[400010], A[400010], B[400010], ans;
signed main() {
  scanf("%lld%lld%lld", &n, &m, &k);
  ans = n;
  for (long long i = 1; i <= m; i++) {
    long long a, b;
    scanf("%lld%lld", &a, &b);
    A[i] = a;
    B[i] = b;
    D[a]++;
    D[b]++;
    V[a].insert(b);
    V[b].insert(a);
  }
  vector<long long> Tp, Ans;
  Ans.clear();
  Tp.clear();
  for (long long i = 1; i <= n; i++)
    if (D[i] < k) Tp.push_back(i);
  for (long long i = m; i >= 1; i--) {
    for (long long j = 0; j < Tp.size(); j++) {
      long long x = Tp[j];
      if (D[x] <= -100000)
        continue;
      else
        ans--;
      for (set<long long>::iterator it = V[x].begin(); it != V[x].end(); it++) {
        V[*it].erase(x);
        if (--D[*it] < k) Tp.push_back(*it);
      }
      V[x].clear();
      D[x] = -100000;
    }
    Ans.push_back(ans);
    Tp.clear();
    if (!V[A[i]].count(B[i])) continue;
    D[A[i]]--;
    D[B[i]]--;
    V[A[i]].erase(B[i]);
    V[B[i]].erase(A[i]);
    if (D[A[i]] < k) Tp.push_back(A[i]);
    if (D[B[i]] < k) Tp.push_back(B[i]);
  }
  for (long long i = (long long)Ans.size() - 1; i >= 0; i--)
    printf("%lld\n", Ans[i]);
  return 0;
}
