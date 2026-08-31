#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 10;
const int MOD = 998244353;
const int INF = 0x3f3f3f3f;
struct Node {
  int x;
  int v;
} a[MAXN];
bool cmp(Node a, Node b) {
  if (a.v == b.v) {
    return a.x < b.x;
  }
  return a.v < b.v;
}
int N, M;
vector<int> dic;
int main() {
  int now;
  long long ans;
  while (~scanf("%d", &N)) {
    dic.clear();
    for (int i = 0; i < N; i++) {
      scanf("%d", &a[i].x);
      dic.push_back(a[i].x);
    }
    for (int i = 0; i < N; i++) {
      scanf("%d", &a[i].v);
    }
    sort(a, a + N, cmp);
    sort(dic.begin(), dic.end());
    ans = 0;
    for (int i = 0; i < N; i++) {
      now = upper_bound(dic.begin(), dic.end(), a[i].x) - dic.begin();
      ans += (long long)(now - N + i) * a[i].x;
    }
    printf("%lld\n", ans);
  }
  return 0;
}
