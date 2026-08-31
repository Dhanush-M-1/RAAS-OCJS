#include <bits/stdc++.h>
using namespace std;
char x[100100];
long x2[100100];
long mes[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
long wr = 0;
long res, cur, repsmax = -1;
long reps = 0;
long tmp1, tmp2, tmp3;
string s1;
int compare(const void *a, const void *b) { return (*(long *)a - *(long *)b); }
long check(long z) {
  if ((isdigit(x[z])) && (isdigit(x[z + 1])) && (isdigit(x[z + 3])) &&
      (isdigit(x[z + 4])) && (isdigit(x[z + 6])) && (isdigit(x[z + 7])) &&
      (isdigit(x[z + 8])) && (isdigit(x[z + 9]))) {
    if ((x[z + 2] == x[z + 5]) && (x[z + 2] == '-')) {
      tmp1 =
          ((long)(x[z]) - (long)('0')) * 10 + ((long)(x[z + 1]) - (long)('0'));
      tmp2 = ((long)(x[z + 3]) - (long)('0')) * 10 +
             ((long)(x[z + 4]) - (long)('0'));
      tmp3 = ((long)(x[z + 6]) - (long)('0')) * 1000 +
             ((long)(x[z + 7]) - (long)('0')) * 100 +
             (((long)(x[z + 8]) - (long)('0')) * 10) +
             ((long)(x[z + 9]) - (long)('0'));
      if ((tmp2 <= 12) && (tmp3 <= 2015) && (tmp3 >= 2013)) {
        if ((tmp1 <= mes[tmp2]) && (tmp2 != 0) && (tmp1 != 0)) {
          x2[wr++] = tmp1 + tmp2 * 100 + tmp3 * 10000;
        }
      }
    }
  }
  if ((!isdigit(x[z + 9])) && (x[z + 9] != '-')) {
    return -2;
  }
}
int main(int argc, char *argv[]) {
  scanf("%s", &x);
  long j = 0;
  while (check(j++) > -2) {
  }
  qsort(x2, wr - 1, sizeof(long), compare);
  cur = x2[0];
  for (long j = 0; j < wr; j++) {
    if (cur == x2[j]) {
      reps++;
    } else {
      if (reps > repsmax) {
        repsmax = reps;
        res = cur;
      }
      cur = x2[j];
      reps = 1;
    }
  }
  if (reps > repsmax) {
    repsmax = reps;
    res = cur;
  }
  cur = x2[j];
  reps = 1;
  ldiv_t divresult1;
  divresult1 = ldiv(res, 100);
  if (divresult1.rem < 10) {
    cout << "0";
  }
  cout << divresult1.rem << "-";
  ldiv_t divresult2;
  divresult2 = ldiv(res, 10000);
  if (((divresult2.rem - divresult1.rem) / 100) < 10) {
    cout << "0";
  }
  cout << (divresult2.rem - divresult1.rem) / 100 << "-";
  ldiv_t divresult3;
  divresult3 = ldiv(res, 100000000);
  cout << (divresult3.rem - divresult2.rem) / 10000;
  return EXIT_SUCCESS;
}
