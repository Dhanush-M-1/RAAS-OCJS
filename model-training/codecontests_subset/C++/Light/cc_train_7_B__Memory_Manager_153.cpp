#include <bits/stdc++.h>
using namespace std;
int readint() {
  int i, j, s;
  while (!isdigit(i = getchar()) && i != '-')
    ;
  if (i == '-') {
    s = -1;
    j = 0;
  } else {
    s = 1;
    j = i - '0';
  }
  while (isdigit(i = getchar())) j = ((j << 1) + (j << 3) + (i - '0'));
  return j * s;
}
long long mem[100010];
int main() {
  long long T, M;
  cin >> T >> M;
  memset(mem, -1, sizeof(mem));
  long long id = 1;
  while (T--) {
    char buf[256];
    cin >> buf;
    if (buf[0] == 'a') {
      long long n;
      cin >> n;
      long long res = 0;
      for (long long i = 1; i <= M; i++) {
        for (long long j = i; j < i + n; j++) {
          if (j > M || mem[j] != -1) goto ng;
        }
        for (long long j = i; j < i + n; j++) mem[j] = id;
        res = id++;
        break;
      ng:;
      }
      if (res == 0)
        puts("NULL");
      else
        printf("%d\n", (int)res);
    } else if (buf[0] == 'e') {
      long long x;
      cin >> x;
      bool f = false;
      for (long long j = 1; j <= M; j++) {
        if (mem[j] == x) {
          mem[j] = -1;
          f = true;
        }
      }
      if (x == -1 || !f) puts("ILLEGAL_ERASE_ARGUMENT");
    } else if (buf[0] == 'd') {
      long long j = 1;
      for (long long i = 1; i <= M; i++) {
        if (mem[i] != -1) mem[j++] = mem[i];
      }
      while (j <= M) mem[j++] = -1;
    }
  }
  return 0;
}
