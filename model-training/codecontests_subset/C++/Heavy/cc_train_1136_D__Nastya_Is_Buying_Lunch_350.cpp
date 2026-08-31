#include <bits/stdc++.h>
using namespace std;
long long n, m, A[500007], pointer;
vector<long long> V[500007];
set<long long> S, F, RF;
int main() {
  scanf("%lld %lld\n", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &A[i]);
  }
  scanf("\n");
  for (int i = 1; i <= m; i++) {
    long long x, y;
    scanf("%lld %lld\n", &x, &y);
    if (y == A[n]) {
      S.insert(x);
    }
    V[x].push_back(y);
  }
  pointer = n;
  long long res = 0;
  for (int i = n - 1; i >= 1; i--) {
    if (S.count(A[i]) != 0) {
      RF = F;
      int flag = 0;
      for (int j = 0; j < V[A[i]].size(); j++) {
        long long k = V[A[i]][j];
        if (F.count(k) != 0) {
          F.erase(k);
        }
        if (k == A[n]) {
          flag = 1;
        }
      }
      if (F.size() > 0 || flag == 0) {
        RF.insert(A[i]);
      } else {
        res++;
      }
      F = RF;
    } else {
      F.insert(A[i]);
    }
  }
link:
  printf("%lld\n", res);
}
