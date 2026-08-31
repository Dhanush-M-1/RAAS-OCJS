#include <bits/stdc++.h>
using namespace std;
typedef struct rectangle {
  int r, c;
  int w, h;
  int color;
  rectangle* rt;
  rectangle* rd;
  rectangle* lt;
  rectangle* ld;
  rectangle* tl;
  rectangle* tr;
  rectangle* dl;
  rectangle* dr;
} rect;
int main() {
  int i, j, k, l, m, n;
  char pict[51][51];
  int handled[51][51];
  for (i = 0; i < 51; i++)
    for (j = 0; j < 51; j++) handled[i][j] = -1;
  scanf("%d %d", &m, &n);
  for (i = 0; i < m; i++) scanf("%s", pict[i]);
  int cols = strlen(pict[0]);
  for (i = 0; i < m; i++)
    for (j = 0; j < cols; j++) pict[i][j] -= '0';
  vector<rect> rects;
  int q = 0;
  for (i = 0; i < m; i++)
    for (j = 0; j < cols; j++) {
      if (handled[i][j] == -1) {
        int w = 1, h = 1;
        for (int jj = j + 1; jj < cols && pict[i][j] == pict[i][jj]; w++, jj++)
          ;
        for (int ii = i + 1; ii < m && pict[i][j] == pict[ii][j]; h++, ii++)
          ;
        for (int ii = i; ii < i + h; ii++)
          for (int jj = j; jj < j + w; jj++) handled[ii][jj] = q;
        q++;
        rect re;
        re.r = i;
        re.c = j;
        re.w = w;
        re.h = h;
        re.color = pict[i][j];
        re.tr = re.tl = re.dl = re.dr = re.lt = re.ld = re.rt = re.rd = NULL;
        rects.push_back(re);
      }
    }
  for (i = 0; i < rects.size(); i++) {
    if (rects[i].r + rects[i].h < m) {
      rects[i].dl = pict[rects[i].r + rects[i].h][rects[i].c] != 0
                        ? &rects[handled[rects[i].r + rects[i].h][rects[i].c]]
                        : NULL;
      rects[i].dr =
          pict[rects[i].r + rects[i].h][rects[i].c + rects[i].w - 1] != 0
              ? &rects[handled[rects[i].r + rects[i].h]
                              [rects[i].c + rects[i].w - 1]]
              : NULL;
    }
    if (rects[i].r - 1 >= 0) {
      rects[i].tl = pict[rects[i].r - 1][rects[i].c] != 0
                        ? &rects[handled[rects[i].r - 1][rects[i].c]]
                        : NULL;
      rects[i].tr =
          pict[rects[i].r - 1][rects[i].c + rects[i].w - 1] != 0
              ? &rects[handled[rects[i].r - 1][rects[i].c + rects[i].w - 1]]
              : NULL;
    }
    if (rects[i].c + rects[i].w < cols) {
      rects[i].rt = pict[rects[i].r][rects[i].c + rects[i].w] != 0
                        ? &rects[handled[rects[i].r][rects[i].c + rects[i].w]]
                        : NULL;
      rects[i].rd =
          pict[rects[i].r + rects[i].h - 1][rects[i].c + rects[i].w] != 0
              ? &rects[handled[rects[i].r + rects[i].h - 1]
                              [rects[i].c + rects[i].w]]
              : NULL;
    }
    if (rects[i].c - 1 >= 0) {
      rects[i].lt = pict[rects[i].r][rects[i].c - 1] != 0
                        ? &rects[handled[rects[i].r][rects[i].c - 1]]
                        : NULL;
      rects[i].ld =
          pict[rects[i].r + rects[i].h - 1][rects[i].c - 1] != 0
              ? &rects[handled[rects[i].r + rects[i].h - 1][rects[i].c - 1]]
              : NULL;
    }
  }
  rect* bp = &rects[0];
  int dir = 0;
  int cp = 0;
  for (i = 0; i < n; i++) {
    rect* next;
    if (dir == 0) {
      if (cp == 0) next = bp->rt;
      if (cp == 1) next = bp->rd;
    }
    if (dir == 1) {
      if (cp == 0) next = bp->dr;
      if (cp == 1) next = bp->dl;
    }
    if (dir == 2) {
      if (cp == 0) next = bp->ld;
      if (cp == 1) next = bp->lt;
    }
    if (dir == 3) {
      if (cp == 0) next = bp->tl;
      if (cp == 1) next = bp->tr;
    }
    if (next != NULL)
      bp = next;
    else {
      if (cp == 0)
        cp = 1;
      else {
        cp = 0;
        dir = (dir + 1) % 4;
      }
    }
  }
  printf("%d\n", bp->color);
  return 0;
}
