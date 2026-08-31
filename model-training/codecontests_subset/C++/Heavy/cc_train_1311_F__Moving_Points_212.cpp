#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5;
int N;
pair<long long, long long> A[MAXN + 10];
long long ans;
vector<long long> comp;
long long tree1[MAXN + 10];
void update1(int i, long long v) {
  for (; i <= N; i += (i & -i)) tree1[i] += v;
}
long long query1(int i) {
  long long ret = 0;
  for (; i > 0; i -= (i & -i)) ret += tree1[i];
  return ret;
}
long long tree2[MAXN + 10];
void update2(int i, long long v) {
  for (; i <= N; i += (i & -i)) tree2[i] += v;
}
long long query2(int i) {
  long long ret = 0;
  for (; i > 0; i -= (i & -i)) ret += tree2[i];
  return ret;
}
int main() {
  int i, j;
  scanf("%d", &N);
  for (i = 1; i <= N; i++) scanf("%lld", &A[i].first);
  for (i = 1; i <= N; i++)
    scanf("%lld", &A[i].second), comp.push_back(A[i].second);
  sort(A + 1, A + N + 1);
  sort(comp.begin(), comp.end());
  comp.erase(unique(comp.begin(), comp.end()), comp.end());
  for (i = 1; i <= N; i++)
    A[i].second =
        lower_bound(comp.begin(), comp.end(), A[i].second) - comp.begin() + 1;
  for (i = 1; i <= N; i++) {
    ans += query2(A[i].second) * A[i].first - query1(A[i].second);
    update1(A[i].second, A[i].first);
    update2(A[i].second, 1);
  }
  printf("%lld\n", ans);
}
