#include <bits/stdc++.h>
using namespace std;
enum { UP = 0, RIGHT, DOWN, LEFT, DIRS };
struct BLOCK {
  int r, c;
  int w, h;
  char col;
  void edge(int dir, int& new_r, int& new_c) {
    dir %= DIRS;
    if (dir == UP) {
      new_r = r;
    } else if (dir == LEFT) {
      new_c = c;
    } else if (dir == RIGHT) {
      new_c = c + w - 1;
    } else if (dir == DOWN) {
      new_r = r + h - 1;
    } else {
      throw "Bad direction!";
    }
  }
};
void move(int r, int c, int dir, int& new_r, int& new_c) {
  new_r = r;
  new_c = c;
  if (dir == UP)
    new_r--;
  else if (dir == DOWN)
    new_r++;
  else if (dir == RIGHT)
    new_c++;
  else if (dir == LEFT)
    new_c--;
  else
    throw "BAD DIR!";
}
struct PTR {
  int bl;
  int dir;
  int rot;
  void fix() {
    if ((rot % DIRS) == LEFT) {
      rot = RIGHT;
    } else if ((rot % DIRS) == RIGHT) {
      rot = LEFT;
      dir++;
      dir %= DIRS;
    }
  }
} my_ptr;
string G[70];
int comp[70][70];
vector<BLOCK> block;
bool invalid(int r, int c, int M, int K) {
  if (r < 0) return true;
  if (c < 0) return true;
  if (r >= M) return true;
  if (c >= K) return true;
  return false;
}
void flood_fill(int r, int c, int b, int M, int K) {
  if (invalid(r, c, M, K)) return;
  if (comp[r][c] != (-1)) return;
  if (G[r][c] != block[b].col) return;
  comp[r][c] = b;
  int new_w = c - block[b].c + 1;
  int new_h = r - block[b].r + 1;
  block[b].w = max(block[b].w, new_w);
  block[b].h = max(block[b].h, new_h);
  for (int i = -1; i <= 1; i++) {
    for (int j = -1; j <= 1; j++) {
      int x = i;
      int y = j;
      if (x < 0) x *= -1;
      if (y < 0) y *= -1;
      if ((x + y) != 1) continue;
      flood_fill(r + i, c + j, b, M, K);
    }
  }
}
string s(int d) {
  if (d < 0) d += DIRS;
  if (d == UP) return "up";
  if (d == RIGHT) return "right";
  if (d == LEFT) return "left";
  if (d == DOWN) return "down";
  throw "wat!?";
}
int main() {
  int M, N;
  cin >> M >> N;
  cin.ignore();
  for (int r = 0; r < M; r++) {
    getline(cin, G[r]);
  }
  int K = G[0].size();
  for (int r = 0; r < M; r++) {
    for (int c = 0; c < K; c++) {
      comp[r][c] = (-1);
    }
  }
  for (int r = 0; r < M; r++) {
    for (int c = 0; c < K; c++) {
      if (G[r][c] == '0') continue;
      if (comp[r][c] == (-1)) {
        BLOCK nb;
        nb.r = r;
        nb.c = c;
        nb.w = 1;
        nb.h = 1;
        nb.col = G[r][c];
        block.push_back(nb);
        flood_fill(r, c, block.size() - 1, M, K);
      }
    }
  }
  my_ptr.bl = 0;
  my_ptr.dir = RIGHT;
  my_ptr.rot = LEFT;
  for (int i = 0; i < N; i++) {
    int r, c;
    block[my_ptr.bl].edge(my_ptr.dir, r, c);
    block[my_ptr.bl].edge((my_ptr.dir + my_ptr.rot) % DIRS, r, c);
    int rp, cp;
    move(r, c, my_ptr.dir, rp, cp);
    if ((invalid(rp, cp, M, K)) || (comp[rp][cp] == (-1))) {
      my_ptr.fix();
    } else {
      my_ptr.bl = comp[rp][cp];
    }
  }
  cout << block[my_ptr.bl].col << endl;
}
