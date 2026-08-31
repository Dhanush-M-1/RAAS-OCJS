#include <bits/stdc++.h>
using namespace std;
long long int n, t;
string s;
static long long int st[10000002], l = 0;
long long int sum[2] = {0};
int main() {
  getline(cin, s);
  if (s[0] == '-') {
    sum[1] = 1;
    st[l++] = -1;
  } else {
    sum[0] = 1;
    st[l++] = 1;
  }
  long long int pre = 0;
  for (int i = 1; s.length(); i++) {
    if (s[i] == '+') {
      st[l++] = 1;
      sum[0]++;
    } else if (s[i] == '-') {
      st[l++] = -1;
      sum[1]++;
    }
    if (s[i] >= '0' and s[i] <= '9') {
      while (s[i] >= '0' and s[i] <= '9') {
        pre *= 10;
        pre += (s[i] - '0');
        i++;
      }
      break;
    }
  }
  if (sum[0] * pre - sum[1] >= pre and sum[0] - sum[1] * pre <= pre) {
    puts("Possible\n");
    long long int ansA, ansB, am;
    for (int i = 1; i <= pre; i++) {
      long long int PRE = sum[1] * i + pre;
      long long int pre1 = PRE / sum[0];
      long long int pre2 = PRE / sum[0] + !!(PRE % sum[0]);
      if (pre2 >= 1 and pre2 <= pre and pre1 >= 1 and pre1 <= pre) {
        ansA = pre1;
        ansB = i;
        break;
      }
    }
    long long int cnt = 0;
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
    printf("%lld", st[0]);
    for (int i = 1; i < l; i++) {
      printf(" ");
      if (st[i] >= 0)
        printf("+");
      else
        printf("-");
      printf(" ");
      printf("%lld", abs(st[i]));
    }
    printf(" = %lld\n", pre);
  } else
    puts("Impossible");
  return 0;
}
