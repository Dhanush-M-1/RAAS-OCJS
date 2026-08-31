#include <bits/stdc++.h>
using namespace std;
vector<vector<int> > v;
int bpX, bpY, dp, cp;
void findEnd() {
  int curX = bpX;
  int curY = bpY;
  int pointer = dp;
  if (pointer == 0) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curY++;
    }
  } else if (pointer == 1) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curX++;
    }
  } else if (pointer == 2) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curY--;
    }
  } else {
    while (v[curX][curY] == v[bpX][bpY]) {
      curX--;
    }
  }
  if (pointer == 0) {
    curY--;
  } else if (pointer == 1) {
    curX--;
  } else if (pointer == 2) {
    curY++;
  } else {
    curX++;
  }
  pointer += cp;
  if (pointer == -1) {
    pointer = 3;
  } else if (pointer == 4) {
    pointer = 0;
  }
  if (pointer == 0) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curY++;
    }
  } else if (pointer == 1) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curX++;
    }
  } else if (pointer == 2) {
    while (v[curX][curY] == v[bpX][bpY]) {
      curY--;
    }
  } else {
    while (v[curX][curY] == v[bpX][bpY]) {
      curX--;
    }
  }
  if (pointer == 0) {
    curY--;
  } else if (pointer == 1) {
    curX--;
  } else if (pointer == 2) {
    curY++;
  } else {
    curX++;
  }
  bpX = curX;
  bpY = curY;
  return;
}
int main() {
  int m, n;
  scanf("%d %d\n", &m, &n);
  v.resize(m + 2);
  char c = getchar();
  v[1].push_back(0);
  while (c != '\n') {
    v[1].push_back(c - '0');
    c = getchar();
  }
  v[1].push_back(0);
  v[0].resize(v[1].size(), 0);
  v.back().resize(v[1].size(), 0);
  for (int i = 2; i <= m; i++) {
    v[i].push_back(0);
    c = getchar();
    while (c != '\n') {
      v[i].push_back(c - '0');
      c = getchar();
    }
    v[i].push_back(0);
  }
  bpX = 1;
  bpY = 1;
  dp = 0;
  cp = -1;
  for (int i = 0; i < n; i++) {
    findEnd();
    int X = bpX, Y = bpY;
    if (dp == 0) {
      Y++;
    } else if (dp == 1) {
      X++;
    } else if (dp == 2) {
      Y--;
    } else {
      X--;
    }
    if (v[X][Y] == 0) {
      if (cp == -1) {
        cp = 1;
      } else {
        cp = -1;
        dp++;
        if (dp == 4) {
          dp = 0;
        }
      }
    } else {
      bpX = X;
      bpY = Y;
    }
  }
  printf("%d", v[bpX][bpY]);
  return 0;
}
