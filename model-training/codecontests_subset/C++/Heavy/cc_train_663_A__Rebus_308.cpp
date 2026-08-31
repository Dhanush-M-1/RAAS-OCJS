#include <bits/stdc++.h>
using namespace std;
int main() {
  int c, d, tmp, plus, kurang, nilai, a, b, k, n = 0, min = 0, sum = 1, cek,
                                               simpan[100], cetak[100];
  char s;
  simpan[0] = 1;
  while (s != '=') {
    scanf("%c", &s);
    if (s == '?') n++;
    if (s == '-') {
      min++;
      simpan[n] = 0;
    }
    if (s == '+') {
      sum++;
      simpan[n] = 1;
    }
  }
  scanf("%d", &cek);
  if (sum != 0) {
    a = (cek + min) / sum;
    b = (cek + min) % sum;
  } else {
    a = 0;
    b = 0;
  }
  if (min != 0) {
    c = (sum - cek) / min;
    d = (sum - cek) % min;
  } else {
    c = 0;
    d = 0;
  }
  if ((b > 0 && a + 1 > cek) || (b == 0 && a > cek) || (a == 0 && c > cek) ||
      (c == 0 && a > cek) || (d > 0 && c + 1 > cek) || (d == 0 && c > cek) ||
      (a == 0 && c == 0)) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  if (a > 0) {
    for (tmp = 0; tmp < n; tmp++) {
      if (simpan[tmp] == 1) {
        if (b > 0) {
          cetak[tmp] = a + 1;
          b--;
        } else {
          cetak[tmp] = a;
        }
      } else {
        cetak[tmp] = 1;
      }
    }
  } else if (c > 0) {
    for (tmp = 0; tmp < n; tmp++) {
      if (simpan[tmp] == 0) {
        if (d > 0) {
          cetak[tmp] = c + 1;
          d--;
        } else {
          cetak[tmp] = c;
        }
      } else {
        cetak[tmp] = 1;
      }
    }
  }
  printf("%d ", cetak[0]);
  for (tmp = 1; tmp < n; tmp++) {
    if (simpan[tmp] == 1)
      printf("+ ");
    else
      printf("- ");
    printf("%d ", cetak[tmp]);
  }
  printf("= %d\n", cek);
}
