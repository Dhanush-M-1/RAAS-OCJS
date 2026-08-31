#include <bits/stdc++.h>
void read_int32_t(FILE *__restrict stream, int32_t *__restrict nr) {
  uint8_t ch;
  *nr = 0;
  while ((ch = fgetc(stream)) && ('0' <= ch && ch <= '9')) {
    *nr *= 10;
    *nr += ch - '0';
  }
}
struct save_tree {
  int32_t pos;
  int32_t h;
};
int32_t dp[100001];
uint8_t fall[100001];
struct save_tree trees[100001];
int32_t last;
int32_t n;
int32_t max(int32_t o1, int32_t o2) { return o1 > o2 ? o1 : o2; }
void update(int32_t pos) {
  last = max(last, trees[pos - 1].pos);
  dp[pos] = dp[pos - 1];
  if (fall[pos - 1] == 0 &&
      (trees[pos - 1].pos + trees[pos - 1].h < trees[pos].pos)) {
    last = trees[pos - 1].pos + trees[pos - 1].h;
    ++dp[pos];
    fall[pos - 1] = 1;
  }
  if (trees[pos].pos - trees[pos].h > last) {
    last = trees[pos].pos;
    ++dp[pos];
    fall[pos] = 1;
  }
}
int main(void) {
  {
    read_int32_t(stdin, &n);
    {
      int32_t i;
      for (i = 0; i < n; ++i) {
        read_int32_t(stdin, &trees[i].pos);
        read_int32_t(stdin, &trees[i].h);
      }
    }
  }
  {
    last = trees[0].pos;
    fall[0] = 1;
    dp[0] = 1;
    {
      int32_t i;
      for (i = 1; i < n; ++i) {
        update(i);
      }
    }
  }
  {
    if (fall[n - 1] == 1) {
      fprintf(stdout, "%u", dp[n - 1]);
    } else {
      fprintf(stdout, "%u", dp[n - 1] + 1);
    }
  }
  return 0;
}
