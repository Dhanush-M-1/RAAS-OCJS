#include <bits/stdc++.h>
using namespace std;
const int MOD(1000000007);
const int INF((1 << 30) - 1);
const int MAXN(105);
int a[MAXN], add[MAXN];
int main() {
  int n;
  char c;
  int numadd = 1, k = 1;
  add[0] = 1;
  while (scanf(" %c", &c) == 1) {
    if (c == '=') {
      scanf("%d", &n);
      break;
    } else if (c != '?') {
      add[k++] = (c == '+');
      numadd += (c == '+');
    }
  }
  int sum = 0;
  for (int i = 0; i < k; i++) {
    if (add[i] == 1)
      a[i] = n, sum += n;
    else
      a[i] = 1, sum--;
  }
  if (sum < n) {
    printf("Impossible");
    return 0;
  }
  int d;
  for (int i = 0; i < k; i++) {
    d = min(sum - n, n - 1);
    if (add[i] == 1)
      a[i] -= d;
    else
      a[i] += d;
    sum -= d;
  }
  if (sum != n) {
    printf("Impossible");
    return 0;
  }
  printf("Possible\n");
  for (int i = 0; i < k; i++) {
    if (i != 0) printf("%c ", add[i] == 1 ? '+' : '-');
    printf("%d ", a[i]);
  }
  printf("= %d", n);
}
