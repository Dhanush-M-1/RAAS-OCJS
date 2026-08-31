#include <bits/stdc++.h>
using namespace std;
int n, t;
char s[1100000];
long long st[100000l], l = 0;
long long sum[2] = {0};
int main() {
  gets(s);
  if (s[0] == '-') {
    sum[1] = 1;
    st[l++] = -1;
  } else {
    sum[0] = 1;
    st[l++] = 1;
  }
  long long pre = 0;
  for (int i = 1; s[i]; i++) {
    if (s[i] == '+') {
      st[l++] = 1;
      sum[0]++;
    } else if (s[i] == '-') {
      st[l++] = -1;
      sum[1]++;
    }
    if (s[i] >= '0' && s[i] <= '9') {
      while (s[i] >= '0' && s[i] <= '9') {
        pre *= 10;
        pre += (s[i] - '0');
        i++;
      }
      break;
    }
  }
  if (sum[0] * pre - sum[1] >= pre && sum[0] - sum[1] * pre <= pre) {
    printf("Possible\n");
    long long ansA, ansB, am;
    for (int i = 1; i <= pre; i++) {
      long long PRE = sum[1] * i + pre;
      long long pre1 = PRE / sum[0];
      long long pre2 = PRE / sum[0] + !!(PRE % sum[0]);
      if (pre2 >= 1 && pre2 <= pre && pre1 >= 1 && pre1 <= pre) {
        ansA = pre1;
        ansB = i;
        break;
      }
    }
    long long cnt = 0;
    for (int i = 0; i < l; i++) {
      if (st[i] > 0) {
        st[i] *= ansA;
        cnt += st[i];
      } else
        st[i] *= ansB;
    }
    cnt = sum[1] * ansB + pre - sum[0] * ansA;
    for (int i = 0; i < l; i++) {
      if (st[i] > 0) {
        if (cnt > 0) {
          st[i]++;
          cnt--;
        }
      }
    }
    printf("%I64d", st[0]);
    for (int i = 1; i < l; i++) {
      printf(" ");
      if (st[i] >= 0)
        printf("+");
      else
        printf("-");
      printf(" ");
      printf("%I64d", abs(st[i]));
    }
    printf(" = %I64d\n", pre);
  } else
    printf("Impossible\n");
  return 0;
}
