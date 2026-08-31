#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T sqr(T x) {
  return x * x;
}
const double EPS = 1e-9;
const int MAXN = 500 + 10;
int w[MAXN];
int b[MAXN * 10];
int n, m;
bool was[MAXN];
vector<int> order;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < (int)n; ++i) {
    scanf("%d", &w[i]);
  }
  for (int i = 0; i < (int)m; ++i) {
    scanf("%d", &b[i]);
    --b[i];
  }
  memset(was, false, sizeof was);
  for (int i = 0; i < (int)m; ++i) {
    if (!was[b[i]]) {
      order.push_back(b[i]);
      was[b[i]] = true;
    }
  }
  int res = 0;
  for (int i = 0; i < (int)m; ++i) {
    int pos = -1;
    for (int j = 0; j < (int)((int)(order).size()); ++j) {
      if (order[j] == b[i]) {
        pos = j;
      }
    }
    assert(pos != -1);
    for (int j = 0; j < (int)pos; ++j) {
      res += w[order[j]];
    }
    for (int j = pos; j > 0; --j) {
      order[j] = order[j - 1];
    }
    order[0] = b[i];
  }
  printf("%d\n", res);
  return 0;
}
