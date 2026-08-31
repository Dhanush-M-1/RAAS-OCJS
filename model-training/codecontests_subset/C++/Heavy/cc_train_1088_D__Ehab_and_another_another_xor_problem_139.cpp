#include <bits/stdc++.h>
using namespace std;
int res;
bitset<30> a, b;
int aa = 11, bb = 22;
bool rever;
void query() {
  if (rever) {
    printf("? %u %u\n", b.to_ulong(), a.to_ulong());
  } else {
    printf("? %u %u\n", a.to_ulong(), b.to_ulong());
  }
  fflush(stdout);
  scanf("%d", &res);
  if (rever) {
    res *= -1;
  }
}
int main() {
  int big = 0;
  query();
  big = res;
  for (int i = 29; i >= 0; i--) {
    if (big == 0) {
      a[i] = 1;
      query();
      if (res == 1) {
        a[i] = 0;
      } else if (res == -1) {
        b[i] = 1;
      }
    } else {
      rever = false;
      if (big == -1) {
        swap(a, b);
        rever = true;
        big = 1;
      }
      a[i] = 1;
      b[i] = 1;
      query();
      if (res == 1) {
        a[i] = 0;
        query();
        if (res == -1) {
          b[i] = 0;
        } else {
          a[i] = 1;
        }
      } else if (res == -1) {
        b[i] = 0;
        query();
        big = res;
      }
      if (rever) {
        swap(a, b);
        big *= -1;
      }
    }
  }
  printf("! %u %u\n", a.to_ulong(), b.to_ulong());
  return 0;
}
