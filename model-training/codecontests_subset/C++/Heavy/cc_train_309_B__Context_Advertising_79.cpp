#include <bits/stdc++.h>
using namespace std;
int A[1 << 20];
int S[1 << 20];
char buf[8 << 20];
int R[20][1 << 20];
string W[1 << 20];
int main() {
  int n, r, c;
  scanf("%d%d%d", &n, &r, &c);
  ++c;
  int i, j;
  for (i = (0); i < (n); ++i) {
    scanf("%s", buf);
    A[i] = strlen(buf) + 1;
    W[i] = buf;
  }
  S[0] = 0;
  for (i = (0); i < (n); ++i) S[i + 1] = S[i] + A[i];
  int pos = 0;
  for (i = (0); i < (n + 1); ++i) {
    while (pos < n && S[pos + 1] - S[i] <= c) ++pos;
    R[0][i] = pos;
  }
  for (i = (1); i < (20); ++i)
    for (j = (0); j < (n + 1); ++j) R[i][j] = R[i - 1][R[i - 1][j]];
  int res = -1;
  pos = -1;
  for (i = (0); i < (n); ++i) {
    int t = i;
    for (j = (0); j < (20); ++j)
      if ((r & (1 << j)) != 0) t = R[j][t];
    if (res < t - i) {
      res = t - i;
      pos = i;
    }
  }
  for (i = (0); i < (r); ++i) {
    int next = R[0][pos];
    for (j = (pos); j < (next); ++j)
      printf("%s%c", W[j].c_str(), j == next - 1 ? '\n' : ' ');
    pos = next;
  }
  return 0;
};
