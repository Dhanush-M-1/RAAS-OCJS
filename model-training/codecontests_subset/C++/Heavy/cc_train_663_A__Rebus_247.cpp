#include <bits/stdc++.h>
int main() {
  long long int n = 0, p = 1, m = 0, num, sign[105], s = 0;
  char c = 0;
  while (c != '=') {
    scanf("%c ", &c);
    if (c == '?')
      n++;
    else if (c == '+') {
      p++;
      sign[s++] = 1;
    } else if (c == '-') {
      m++;
      sign[s++] = 0;
    }
  }
  scanf("%I64d", &num);
  if (n == 1) {
    printf("Possible\n%I64d = %I64d\n", num, num);
  } else if (m == 0) {
    if (n <= num) {
      printf("Possible\n");
      for (long long int i = 0; i < n - 1; i++) {
        printf("1 + ");
      }
      printf("%I64d = %I64d\n", num - n + 1, num);
    } else
      printf("Impossible\n");
  } else if (p <= m && p == 1)
    printf("Impossible\n");
  else if (p > m) {
    long long int d = p - m;
    if (d <= num) {
      printf("Possible\n");
      printf("%I64d ", num - d + 1);
      for (long long int i = 0; i < n - 1; i++) {
        if (sign[i])
          printf("+ ");
        else if (!sign[i])
          printf("- ");
        printf("1 ");
      }
      printf("= %I64d\n", num);
    } else {
      long long int itachi = num * m;
      if (p - itachi > num)
        printf("Impossible\n");
      else {
        printf("Possible\n");
        long long int baki = 1, cnt = 0, f = 1;
        if (p - itachi < num) {
          while (p + (num - 1) * cnt - itachi < num) {
            cnt++;
          }
          cnt--;
          baki = itachi + num - p - ((num - 1) * (cnt)) + 1;
        }
        printf("%I64d ", baki);
        for (long long int i = 0; i < n - 1; i++) {
          if (sign[i]) {
            if (cnt > 0) {
              printf("+ %I64d ", num);
              cnt--;
            } else
              printf("+ 1 ");
          } else if (!sign[i]) {
            printf("- %I64d ", num);
          }
        }
        printf("= %I64d\n", num);
      }
    }
  } else if (p <= m && p > 1) {
    long long int itachi = num * p;
    if (itachi - m < num)
      printf("Impossible\n");
    else {
      printf("Possible\n");
      long long int dd = num, cnt = 0, minu = (itachi - num) / m, mi = m;
      long long int monu = itachi - num - (minu * (m - 1));
      if (monu > num) {
        dd = monu - num;
        monu = num;
        while (dd > num) {
          dd = dd - num + 1;
          cnt++;
        }
        dd = num - dd;
      }
      printf("%I64d ", dd);
      for (long long int i = 0; i < n - 1; i++) {
        if (sign[i]) {
          if (cnt > 0) {
            printf("+ 1 ");
            cnt--;
          } else
            printf("+ %I64d ", num);
        } else if (!sign[i] && mi > 1) {
          printf("- %I64d ", minu);
          mi--;
        } else if (!sign[i] && mi == 1) {
          printf("- %I64d ", monu);
        }
      }
      printf("= %I64d\n", num);
    }
  }
  return 0;
}
