#include <bits/stdc++.h>
using namespace std;
int wordAt[7000007];
int nextR[1000007];
int dyn[30][1000007];
int main() {
  int N, R, C;
  scanf("%d %d %d ", &N, &R, &C);
  ;
  string line;
  getline(cin, line);
  int len = line.size();
  int w = 0;
  for (int i = (0); i < (len); i++) {
    if (line[i] == ' ') w++;
    wordAt[i] = w;
  }
  int last = -1;
  bool next = true;
  w = 0;
  for (int i = (0); i < (len); i++) {
    if (next) {
      if (i + C >= len)
        nextR[w] = N;
      else
        nextR[w] = wordAt[i + C];
      w++;
      next = false;
    }
    if (line[i] == ' ') next = true;
  }
  nextR[N] = N;
  for (int i = (0); i < (N + 1); i++) dyn[0][i] = nextR[i];
  for (int d = (1); d < (30); d++) {
    for (int i = (0); i < (N + 1); i++) {
      dyn[d][i] = dyn[d - 1][dyn[d - 1][i]];
    }
  }
  int best = 0;
  int bestAt = 0;
  for (int i = (0); i < (N); i++) {
    int ro = R;
    int d = 0;
    int msk = 1;
    int at = i;
    while (ro) {
      if (ro & msk) {
        at = dyn[d][at];
        ro -= msk;
      }
      msk <<= 1;
      d++;
    }
    int cnt = at - i;
    if (cnt > best) {
      best = cnt;
      bestAt = i;
    }
  }
  int atW = bestAt;
  int atCh = 0;
  while (wordAt[atCh] != bestAt) atCh++;
  if (line[atCh] == ' ') atCh++;
  for (int i = (0); i < (R); i++) {
    int wr = nextR[atW];
    while (atCh < len && wordAt[atCh] != wr) printf("%c", line[atCh++]);
    ;
    if (line[atCh] == ' ') atCh++;
    atW = wr;
    printf("\n");
  }
  return 0;
}
