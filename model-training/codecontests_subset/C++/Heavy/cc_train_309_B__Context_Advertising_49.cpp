#include <bits/stdc++.h>
int n, r, c, len[1000086], next[20][1000086];
char buf[6000086], *pos[1000086];
int main() {
  gets(buf);
  sscanf(buf, "%d%d%d", &n, &r, &c);
  memset(buf, ' ', sizeof(buf));
  gets(buf);
  buf[strlen(buf)] = ' ';
  char *cp = pos[1] = buf;
  for (int i = (2), asdf = (n + 1); i <= asdf; ++i) {
    while (*cp != ' ') ++cp;
    pos[i] = ++cp;
  }
  int cr = n, cs = -1;
  for (int i = (n); i >= (1); --i) {
    cs += (len[i] = pos[i + 1] - pos[i]);
    while (cs > c) cs -= len[cr--];
    next[0][i] = cr + 1;
  }
  next[0][n + 1] = n + 1;
  for (int j = (1); j <= (19); ++j)
    for (int i = (1), asdf = (n + 1); i <= asdf; ++i)
      next[j][i] = next[j - 1][next[j - 1][i]];
  int bans = -1, bi, br;
  for (int i = (1); i <= (n); ++i) {
    int cr = i;
    for (int j = (0); j <= (19); ++j)
      if (r & (1 << j)) cr = next[j][cr];
    if (cr - i > bans) {
      bans = cr - i;
      bi = i;
      br = cr;
    }
  }
  if (bi == br) return 0;
  for (int c = bi; c != br; c = next[0][c]) *(pos[c] - 1) = '\n';
  *(pos[br] - 1) = 0;
  puts(pos[bi]);
  return 0;
}
