#include <bits/stdc++.h>
using namespace std;
const int maxn = 200010;
int N, QAQ, k, s[maxn];
long long nu[maxn << 2], a, b;
struct Node {
  int le, ri;
  long long nua, nub;
} A[maxn << 2];
void Build(int i, int le, int ri) {
  A[i].le = le, A[i].ri = ri;
  A[i].nua = A[i].nub = 0LL;
  if (le == ri) {
    s[le] = i;
    return;
  }
  int mid = (A[i].le + A[i].ri) >> 1;
  Build((i << 1), le, mid);
  Build((i << 1 | 1), mid + 1, ri);
}
inline void Update(int p, long long c) {
  p = s[p];
  nu[p] += c;
  A[p].nua = (nu[p] < a ? nu[p] : a);
  A[p].nub = (nu[p] < b ? nu[p] : b);
  p >>= 1;
  while (p) {
    A[p].nua = A[p << 1].nua + A[p << 1 | 1].nua;
    A[p].nub = A[p << 1].nub + A[p << 1 | 1].nub;
    p >>= 1;
  }
}
long long Query(int i, int le, int ri, int tc) {
  if (A[i].le <= le && le <= ri && ri <= A[i].ri) {
    if (A[i].le == le && A[i].ri == ri) return tc == 1 ? A[i].nua : A[i].nub;
    int mid = (A[i].le + A[i].ri) >> 1;
    if (ri <= mid)
      return Query((i << 1), le, ri, tc);
    else if (le > mid)
      return Query((i << 1 | 1), le, ri, tc);
    else {
      return (Query((i << 1), le, mid, tc) +
              Query((i << 1 | 1), mid + 1, ri, tc));
    }
  } else
    return 0LL;
}
int main() {
  scanf("%d%d%I64d%I64d%d", &N, &k, &a, &b, &QAQ);
  for (int i = 0; i <= N * 4 + 1; ++i) nu[i] = 0LL;
  Build(1, 1, N);
  int tc;
  long long vl;
  while (QAQ--) {
    scanf("%d", &tc);
    if (tc == 1) {
      scanf("%d%I64d", &tc, &vl);
      Update(tc, vl);
    } else if (tc == 2) {
      scanf("%d", &tc);
      printf("%I64d\n", Query(1, 1, tc - 1, 2) + Query(1, tc + k, N, 1));
    }
  }
  return 0;
}
