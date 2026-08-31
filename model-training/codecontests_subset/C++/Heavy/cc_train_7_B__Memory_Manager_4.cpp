#include <bits/stdc++.h>
int main(int argc, char* argv[]) {
  std::size_t m;
  signed int t, n;
  signed int mem_start[10000];
  signed int cnt, tmp, scs;
  char buf[64];
  scanf("%d %ld", &t, &m);
  memset(mem_start, 0, sizeof mem_start);
  cnt = 1;
  while (t--) {
    scanf("%s", buf);
    if (buf[0] != 'd') scanf("%d", &n);
    if (buf[0] == 'a') {
      tmp = 0;
      scs = false;
      if (n > m) {
        printf("NULL\n");
        continue;
      }
      for (signed int i = 0; i < m; i++) {
        if (mem_start[i] == 0) {
          tmp++;
        } else {
          tmp = 0;
        }
        if (tmp >= n) {
          for (signed int j = 1; j <= tmp; j++) mem_start[i - n + j] = cnt;
          scs = true;
          printf("%d\n", cnt++);
          break;
        }
      }
      if (!scs) printf("NULL\n");
    }
    if (buf[0] == 'e') {
      if (n <= 0) {
        goto ill;
      } else if (n < cnt) {
        scs = false;
        for (signed int i = 0; i < m; ++i) {
          if (mem_start[i] == n) {
            mem_start[i] = 0;
            scs = true;
          }
        }
        if (scs) continue;
      }
    ill:
      printf("ILLEGAL_ERASE_ARGUMENT\n");
      continue;
    }
    if (buf[0] == 'd') {
      tmp = 0;
      for (signed int i = 0; i < m; i++) {
        if (mem_start[i] == 0) {
          tmp++;
        } else if (tmp > 0) {
          memmove(mem_start - tmp + i, mem_start + i, tmp * sizeof(signed int));
          memset(mem_start + i, 0, tmp * sizeof(signed int));
          tmp = 1;
        } else {
          tmp = 0;
        }
      }
    }
  }
  return 0;
}
