#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000001;
const int MAXBIT = 21;
const int MAXL = 7000000;
int n, r, c, nxt[MAXBIT][MAXN], length[MAXN], realEnd[MAXN];
vector<string> words;
char word[MAXL];
void print(int pos) {
  for (int i = (0); i < (r); i++) {
    bool space = false;
    for (int j = (pos); j < (nxt[0][pos]); j++) {
      if (space) putchar(' ');
      space = true;
      printf("%s", words[j].c_str());
    }
    pos = nxt[0][pos];
    putchar('\n');
  }
}
int main() {
  scanf("%d%d%d", &n, &r, &c);
  words = vector<string>(n);
  for (int i = (0); i < (n); i++) {
    scanf("%s", word);
    length[i] = strlen(word);
    words[i] = word;
  }
  int last = n, sumlength = 0;
  nxt[0][n] = n;
  for (int i = n - 1; i >= 0; i--) {
    sumlength += length[i];
    while (i < last && sumlength + last - i - 1 > c) {
      sumlength -= length[--last];
    }
    nxt[0][i] = last;
  }
  for (int bit = 0; 1 << bit < n; bit++) {
    for (int i = (0); i < (n + 1); i++) {
      nxt[bit + 1][i] = nxt[bit][nxt[bit][i]];
    }
  }
  for (int i = (0); i < (n); i++) {
    int p = i;
    for (int mask = r; mask; mask &= mask - 1) {
      int bit = __builtin_ctz(mask);
      p = nxt[bit][p];
    }
    realEnd[i] = p;
  }
  int resPos = n - 1;
  for (int i = (0); i < (n); i++) {
    if (realEnd[i] - i > realEnd[resPos] - resPos) {
      resPos = i;
    }
  }
  print(resPos);
  return 0;
}
