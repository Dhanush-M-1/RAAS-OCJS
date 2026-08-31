#include <bits/stdc++.h>
using namespace std;
int n;
int A[1000005];
int big[1000005];
int main() {
  int a = 0, b = 0, c = 0;
  long long ans = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &A[i]);
    ans += abs(A[i] - i);
    if (A[i] > i) {
      c++;
      big[A[i] - i]++;
    } else if (A[i] == i) {
      a++;
      big[0]++;
    } else {
      b++;
    }
  }
  int pos = n, id = 0;
  int ans_pos = 0;
  long long tmp = ans;
  while (--pos) {
    id++;
    tmp += b + a;
    tmp -= c;
    b = b + a;
    c = c - big[id];
    a = big[id];
    if (A[pos + 1] == n) {
      tmp += n - 2;
      int t = id + n - 1;
      if (t <= n) big[t]++;
      b--;
      c++;
    } else if (A[pos + 1] == 1) {
      b--;
      a++;
      tmp -= n;
    } else {
      b--;
      c++;
      int t = id + A[pos + 1] - 1;
      if (t <= n) big[t]++;
      tmp += -abs(A[pos + 1] - n - 1) + (A[pos + 1] - 1);
    }
    if (tmp <= ans) {
      ans = tmp;
      ans_pos = id;
    }
  }
  printf("%I64d %d\n", ans, ans_pos);
  return 0;
}
