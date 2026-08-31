#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
const int INF = 0x3f3f3f3f;
const long long LLINF = 0x3f3f3f3f3f3f3f3f;
const int MAX_N = (int)3e5 + 17;
const int mod = (int)1e9 + 7;
int N, M, T, K;
int a[MAX_N];
set<int> S[MAX_N];
int main() {
  while (~scanf("%d %d", &N, &M)) {
    for (int i = 1; i <= N; ++i) {
      scanf("%d", &a[i]);
      S[i].clear();
    }
    int x, y;
    for (int i = 0; i < M; ++i) {
      scanf("%d %d", &x, &y);
      S[x].insert(y);
    }
    int cur = N;
    for (int i = N - 1; i >= 1; --i) {
      if (S[a[i]].find(a[cur]) != S[a[i]].end()) {
        int p = i;
        while (p < cur - 1 && S[a[p]].find(a[p + 1]) != S[a[p]].end()) {
          swap(a[p], a[p + 1]);
          ++p;
        }
        if (p == cur - 1) {
          swap(a[p], a[p + 1]);
          cur--;
        }
      }
    }
    printf("%d\n", N - cur);
  }
  return 0;
}
