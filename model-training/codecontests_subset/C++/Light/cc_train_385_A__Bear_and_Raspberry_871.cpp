#include <bits/stdc++.h>
using namespace std;
int in() {
  int x = 0, c;
  for (; (unsigned long long)((c = getchar()) - '0') >= 10;) {
    if (c == '-') return -in();
    if (!~c) throw ~0;
  }
  do {
    x = (x << 3) + (x << 1) + (c - '0');
  } while ((unsigned long long)((c = getchar()) - '0') < 10);
  return x;
}
long long in64() {
  long long x = 0, c;
  for (; (unsigned long long)((c = getchar()) - '0') >= 10;) {
    if (c == '-') return -in();
    if (!~c) throw ~0;
  }
  do {
    x = (x << 3) + (x << 1) + (c - '0');
  } while ((unsigned long long)((c = getchar()) - '0') < 10);
  return x;
}
void out(int n) {
  char buf[33];
  int i = 30;
  if (n < 0) putchar('-'), n = -n;
  do {
    buf[i--] = '0' + n % 10;
    n /= 10;
  } while (n);
  while (i < 30) putchar(buf[++i]);
}
void out64(long long n) {
  char buf[55];
  int i = 50;
  if (n < 0) putchar('-'), n = -n;
  do {
    buf[i--] = '0' + n % 10;
    n /= 10;
  } while (n);
  while (i < 50) putchar(buf[++i]);
}
void readArray(int array1[], int len) {
  for (int i = 0; i < len; i++) {
    array1[i] = in();
  }
}
void read2Array(int array1[], int array2[], int len) {
  for (int i = 0; i < len; i++) {
    array1[i] = in();
    array2[i] = in();
  }
}
int main() {
  int dayNow, dayPre = 0, maxi = 0;
  int n = in();
  int c = in();
  for (int i = (0), _b = (n); i < _b; i++) {
    dayNow = in();
    maxi = max(maxi, dayPre - dayNow);
    dayPre = dayNow;
  }
  cout << max(0, maxi - c);
}
