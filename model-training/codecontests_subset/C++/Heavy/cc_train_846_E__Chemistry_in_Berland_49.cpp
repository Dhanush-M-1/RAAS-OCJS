#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const long long M = 1e9 + 7;
long long avl[N], req[N], x[N], k[N], need[N];
long long power(long long b, long long p) {
  long long res = 1;
  for (int i = 1; i <= p; i++) res *= b;
  return res;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &avl[i]);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &req[i]);
    need[i] = avl[i] - req[i];
  }
  for (int i = 2; i <= n; i++) {
    scanf("%lld", &x[i]);
    scanf("%lld", &k[i]);
  }
  for (int i = n; i > 0; i--) {
    int to = x[i];
    if (need[i] == 0) continue;
    if (need[i] > 0) {
      need[to] += need[i];
    } else {
      int flag = 0;
      for (int j = 1; j < 10; j++) {
        long long tk = power(10, j);
        if (tk > k[i]) break;
        long long tn = power(10, 14 - j);
        tn *= (-1);
        if (need[i] < tn) {
          flag = 1;
          break;
        }
      }
      if (flag) {
        printf("NO\n");
        return 0;
      }
      need[to] += k[i] * need[i];
    }
    if (need[to] < -1e15) {
      printf("NO\n");
      return 0;
    }
  }
  if (need[1] >= 0)
    printf("YES\n");
  else
    printf("NO\n");
}
