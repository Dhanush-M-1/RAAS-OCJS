#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
struct P {
  int t, a, b;
};
vector<P> A, B, C;
int sa[N], sb[N], sc[N];
bool cmp(P a, P b) { return a.t < b.t; }
int main() {
  int n, k;
  P t;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d%d", &t.t, &t.a, &t.b);
    if (t.a && t.b) {
      C.push_back(t);
    } else if (t.a) {
      A.push_back(t);
    } else if (t.b) {
      B.push_back(t);
    }
  }
  if (A.size() + C.size() < k || B.size() + C.size() < k) {
    printf("-1\n");
    return 0;
  }
  sort(A.begin(), A.end(), cmp);
  sort(B.begin(), B.end(), cmp);
  sort(C.begin(), C.end(), cmp);
  if (A.size()) sa[1] = A[0].t;
  for (int i = 1; i < A.size(); ++i) {
    sa[i + 1] = sa[i] + A[i].t;
  }
  if (B.size()) sb[1] = B[0].t;
  for (int i = 1; i < B.size(); ++i) {
    sb[i + 1] = sb[i] + B[i].t;
  }
  if (C.size()) sc[1] = C[0].t;
  for (int i = 1; i < C.size(); ++i) {
    sc[i + 1] = sc[i] + C[i].t;
  }
  int Min = 0x7fffffff;
  for (int i = 0; i <= C.size(); ++i) {
    if (k - i > A.size() || k - i > B.size()) continue;
    if (sc[i] + sa[k - i] + sb[k - i] < Min)
      Min = sc[i] + sa[k - i] + sb[k - i];
  }
  printf("%d\n", Min);
  return 0;
}
