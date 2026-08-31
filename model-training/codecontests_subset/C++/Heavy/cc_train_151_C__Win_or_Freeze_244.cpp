#include <bits/stdc++.h>
using namespace std;
const int N = 100009;
const int sq = 3200009;
int vis[sq + 5];
long long sieve(long long n) {
  int k = 0;
  long long ans = 1;
  for (int i = 4; i <= sq; i += 2) vis[i] = 1;
  if (n % 2 == 0 && n != 2) {
    k++;
    ans = ans * 2;
  }
  if (n % 4 == 0) {
    ans = 4;
    return ans;
  }
  for (long long i = 3; i <= sq; i += 2) {
    if (vis[i] == 0) {
      if (n % (i * i) == 0) return i * i;
      if (n % i == 0 && n != i) {
        k++;
        ans = ans * i;
        if (k == 2) return ans;
      }
      for (long long j = i + i; j <= sq; j += i) {
        vis[j] = 1;
      }
    }
  }
  if (k == 0) return 0;
  return -1;
}
int main() {
  long long n, num;
  scanf("%I64d", &n);
  num = sieve(n);
  if (num == -1 || num == n) {
    printf("2\n");
  } else {
    printf("1\n%I64d\n", num);
  }
  return 0;
}
