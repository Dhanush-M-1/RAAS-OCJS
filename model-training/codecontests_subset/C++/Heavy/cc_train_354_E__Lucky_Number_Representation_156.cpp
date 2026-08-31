#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:33554432")
using namespace std;
const int a[3] = {0, 4, 7};
int n;
char num[1 << 5];
int len;
int used[20][6];
int path[20][6][6];
int M[1 << 8];
int C[1 << 8];
int go(int pos, int carry) {
  if (pos == -1) return carry == 0;
  if (used[pos][carry]) return 0;
  used[pos][carry] = 1;
  for (int i1 = 0; i1 < 3; ++i1)
    for (int i2 = i1; i2 < 3; ++i2)
      for (int i3 = i2; i3 < 3; ++i3)
        for (int i4 = i3; i4 < 3; ++i4)
          for (int i5 = i4; i5 < 3; ++i5)
            for (int i6 = i5; i6 < 3; ++i6) {
              int s = a[i1] + a[i2] + a[i3] + a[i4] + a[i5] + a[i6] + carry;
              if (M[s] == num[pos] - '0') {
                if (go(pos - 1, C[s])) {
                  path[pos][carry][0] = i1;
                  path[pos][carry][1] = i2;
                  path[pos][carry][2] = i3;
                  path[pos][carry][3] = i4;
                  path[pos][carry][4] = i5;
                  path[pos][carry][5] = i6;
                  return 1;
                }
              }
            }
  return 0;
}
long long nums[6];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < 1 << 8; ++i) {
    C[i] = i / 10;
    M[i] = i % 10;
  }
  for (int i = 0; i < n; ++i) {
    scanf("%s", num);
    int len = strlen(num);
    memset(used, 0, sizeof(used));
    if (!go(len - 1, 0))
      printf("-1\n");
    else {
      int pos = len - 1;
      int carry = 0;
      memset(nums, 0, sizeof(nums));
      long long cur = 1;
      while (pos >= 0) {
        int to = 0;
        for (int j = 0; j < 6; ++j) {
          nums[j] += cur * a[path[pos][carry][j]];
          to += a[path[pos][carry][j]];
        }
        to += carry;
        pos--;
        carry = to / 10;
        cur *= 10;
      }
      for (int i = 0; i < 6; ++i) printf("%I64d ", nums[i]);
      printf("\n");
    }
  }
  return 0;
}
