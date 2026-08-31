#include <bits/stdc++.h>
using namespace std;
int table[32][10];
char buf[32];
int len;
long long int ans[6];
bool go(int loc, int carry) {
  if (loc == len)
    return !carry;
  else if (table[loc][carry])
    return table[loc][carry] - 1;
  else {
    int& v = table[loc][carry];
    for (int i = 0; !v && i <= 6; i++)
      for (int j = 0; i + j <= 6; j++) {
        int d = carry + i * 4 + j * 7;
        if (d % 10 == buf[loc] && go(loc + 1, d / 10)) {
          v = 1;
          break;
        }
      }
    return v++;
  }
}
void go2(int loc, int carry, long long int radix) {
  if (loc < len) {
    for (int i = 0; i <= 6; i++)
      for (int j = 0; i + j <= 6; j++) {
        int d = carry + i * 4 + j * 7;
        if (d % 10 == buf[loc] && go(loc + 1, d / 10)) {
          for (int a = 0; a < i; a++) ans[a] += 4 * radix;
          for (int b = i; b < i + j; b++) ans[b] += 7 * radix;
          go2(loc + 1, d / 10, radix * 10);
          return;
        }
      }
  }
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    long long int N;
    scanf("%I64d", &N);
    len = 0;
    do buf[len++] = N % 10;
    while (N /= 10);
    memset(table, 0, sizeof(table));
    memset(ans, 0, sizeof(ans));
    if (!go(0, 0))
      puts("-1");
    else {
      go2(0, 0, 1);
      for (int i = 0; i < 6; i++) {
        if (i) printf(" ");
        printf("%I64d", ans[i]);
      }
      printf("\n");
    }
  }
  return 0;
}
