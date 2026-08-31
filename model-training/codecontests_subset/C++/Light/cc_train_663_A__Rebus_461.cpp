#include <bits/stdc++.h>
const int MAX = 1000009;
char m[MAX];
int zheng[MAX], fu[MAX];
int main() {
  int i, j, l, numz = 1, numf = 0, sumz, sumf, f = 1, z = 1, n = 0, t;
  gets(m);
  l = strlen(m);
  for (i = 0; i < l; i++)
    if (m[i] == '+')
      numz++;
    else if (m[i] == '-')
      numf++;
    else if (m[i] == '=')
      break;
  for (j = i + 2; j < l; j++) n = n * 10 + m[j] - '0';
  if (numz * n - numf < n || numz - n * numf > n) {
    printf("Impossible\n");
    return 0;
  }
  sumz = numz, sumf = numf;
  if (sumz - sumf > n) {
    t = sumz - sumf - n;
    while (t) {
      if (t > n - 1) {
        t -= (n - 1);
        fu[f] = n - 1;
        f++;
      } else {
        fu[f] = t;
        break;
      }
    }
  } else {
    t = n - (sumz - sumf);
    while (t) {
      if (t > n - 1) {
        t -= (n - 1);
        zheng[z] = n - 1;
        z++;
      } else {
        zheng[z] = t;
        break;
      }
    }
  }
  z = f = 1;
  printf("Possible\n%d ", zheng[z++] + 1);
  for (j = 2; j < i; j += 4) {
    if (m[j] == '+')
      printf("+ %d ", zheng[z++] + 1);
    else if (m[j] == '-')
      printf("- %d ", fu[f++] + 1);
  }
  printf("= %d\n", n);
}
