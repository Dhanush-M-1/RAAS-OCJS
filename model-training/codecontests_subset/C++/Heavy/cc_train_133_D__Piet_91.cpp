#include <bits/stdc++.h>
using namespace std;
int N, M, L;
char board[100][100];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int save_r[100][100][4];
int save_c[100][100][4];
int R, C, DP, CP;
bool on_board(int r, int c) { return 0 <= r && r < M && 0 <= c && c < L; }
void move_in_dir(int dir) {
  int *mem_r = &save_r[R][C][dir];
  int *mem_c = &save_c[R][C][dir];
  if (*mem_r == -1) {
    int next_r = R + dy[dir];
    int next_c = C + dx[dir];
    while (on_board(next_r, next_c) && board[next_r][next_c] == board[R][C]) {
      R = next_r;
      C = next_c;
      next_r += dy[dir];
      next_c += dx[dir];
    }
    *mem_r = R;
    *mem_c = C;
  } else {
    R = *mem_r;
    C = *mem_c;
  }
}
void step() {
  move_in_dir(DP);
  move_in_dir((DP + CP) % 4);
  int next_r = R + dy[DP];
  int next_c = C + dx[DP];
  if (!on_board(next_r, next_c) || board[next_r][next_c] == '0') {
    if (CP == 3)
      CP = 1;
    else {
      CP = 3;
      DP = (DP + 1) % 4;
    }
  } else {
    R = next_r;
    C = next_c;
  }
}
int main() {
  scanf("%d %d ", &M, &N);
  for (int i = 0; i < M; i++) gets(board[i]);
  L = strlen(board[0]);
  memset(save_r, -1, sizeof(save_r));
  memset(save_c, -1, sizeof(save_c));
  R = C = 0;
  DP = 1;
  CP = 3;
  for (int i = 0; i < N; i++) step();
  printf("%c\n", board[R][C]);
  return 0;
}
