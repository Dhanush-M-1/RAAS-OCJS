#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:256000000")
using namespace std;
const int INF = (1 << 29) + 5;
const long long int LLINF = (1ll << 60) + 5;
const int MOD = 1000 * 1000 * 1000 + 7;
const int MAX_N = 2000 * 100 + 5;
int n, k, a, b, q;
long long int arr[2][MAX_N];
long long int tree[2][MAX_N];
long long int get(int x, int at) {
  long long int ans = 0;
  for (; x >= 0; x = (x & (x + 1)) - 1) ans += tree[at][x];
  return ans;
}
void inc(int x, long long int add, int at) {
  for (; x <= n; x = (x | (x + 1))) tree[at][x] += add;
}
long long int sum(int l, int r, int at) { return get(r, at) - get(l - 1, at); }
int main() {
  memset(tree, 0, sizeof(tree));
  memset(arr, 0, sizeof(arr));
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  int type, d;
  long long int add;
  for (int i = 0; i < q; ++i) {
    scanf("%d", &type);
    if (type == 1) {
      scanf("%d %I64d", &d, &add);
      long long int up = min(a - arr[0][d], add);
      arr[0][d] = min(arr[0][d] + add, a * 1ll);
      inc(d, up, 0);
      up = min(b - arr[1][d], add);
      arr[1][d] = min(arr[1][d] + add, b * 1ll);
      inc(d, up, 1);
    } else {
      scanf("%d", &d);
      printf("%I64d\n", get(d - 1, 1) + sum(d + k, n, 0));
    }
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
