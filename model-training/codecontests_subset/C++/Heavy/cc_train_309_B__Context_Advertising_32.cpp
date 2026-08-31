#include <bits/stdc++.h>
using namespace std;
char buff[6000003];
int nwords, nrows, ncols;
int wordstart[1000000];
int wordlen[1000000];
int nxt[1000001];
int cur[1000001];
int res[1000000];
void input() {
  gets(buff);
  sscanf(buff, "%d%d%d", &nwords, &nrows, &ncols);
  gets(buff);
  int spos = 0, wpos = 0;
  while (true) {
    if (isalpha(buff[spos])) {
      if (wordlen[wpos] == 0) wordstart[wpos] = spos;
      ++wordlen[wpos];
    } else {
      if (wordlen[wpos] != 0) ++wpos;
      if (buff[spos] != ' ') break;
    }
    ++spos;
  }
}
void calcnxt() {
  int linelen = 0, wpos = 0;
  for (int i = (0); i < (nwords); ++i) {
    while (wpos < nwords &&
           linelen + wordlen[wpos] + (linelen == 0 ? 0 : 1) <= ncols) {
      linelen += wordlen[wpos] + (linelen == 0 ? 0 : 1);
      ++wpos;
    }
    nxt[i] = wpos;
    if (wpos == i)
      ++wpos;
    else {
      linelen -= wordlen[i];
      if (wpos != i + 1) linelen--;
    }
  }
  nxt[nwords] = nwords;
}
void calcres() {
  for (int i = (0); i < (nwords); ++i) res[i] = i;
  for (int i = (0); i <= (nwords); ++i) cur[i] = nxt[i];
  for (int i = 0; (1 << i) <= nrows; ++i) {
    if (nrows & (1 << i)) {
      for (int j = (0); j < (nwords); ++j) res[j] = cur[res[j]];
    }
    for (int j = (0); j < (nwords); ++j) cur[j] = cur[cur[j]];
  }
}
void output() {
  int wpos = 0;
  for (int i = (1); i < (nwords); ++i)
    if (res[i] - i > res[wpos] - wpos) wpos = i;
  for (int r = (0); r < (nrows); ++r) {
    for (int i = (wpos); i < (nxt[wpos]); ++i) {
      if (i != wpos) printf(" ");
      for (int j = (0); j < (wordlen[i]); ++j)
        printf("%c", buff[wordstart[i] + j]);
    }
    puts("");
    wpos = nxt[wpos];
  }
}
void run(int casenr) {
  input();
  calcnxt();
  calcres();
  output();
}
int main() {
  run(1);
  return 0;
}
