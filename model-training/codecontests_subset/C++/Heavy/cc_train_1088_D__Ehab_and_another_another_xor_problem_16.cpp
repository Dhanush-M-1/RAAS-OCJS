#include <bits/stdc++.h>
using namespace std;
int main() {
  int prev_flag = 99;
  long long int kc = 0, kd = 0;
  long long int c, d;
  long long int i1, i2;
  for (int i = 29; i >= 0; i--) {
    if (prev_flag == 99) {
      c = kc;
      d = kd;
      printf("? %lld %lld\n", c, d);
      fflush(stdout);
      scanf("%lld", &i1);
    } else
      i1 = prev_flag;
    c = (long long int)pow(2, i) + kc;
    d = (long long int)pow(2, i) + kd;
    printf("? %lld %lld\n", c, d);
    fflush(stdout);
    scanf("%lld", &i2);
    if (i1 == -1 && i2 == 1) {
      kc = kc;
      kd += ((long long int)pow(2, i));
      prev_flag = 99;
    } else if (i1 == 1 && i2 == -1) {
      kc += ((long long int)pow(2, i));
      kd = kd;
      prev_flag = 99;
    } else if (i1 == i2) {
      prev_flag = i1;
      long long int i3;
      c = kc;
      d = ((long long int)pow(2, i)) + kd;
      printf("? %lld %lld\n", c, d);
      fflush(stdout);
      scanf("%lld", &i3);
      if (i3 == -1) {
        kc = kc;
        kd = kd;
      } else if (i3 == 1) {
        kc = ((long long int)pow(2, i)) + kc;
        kd = ((long long int)pow(2, i)) + kd;
      }
    }
  }
  printf("! %lld %lld\n", kc, kd);
  fflush(stdout);
}
