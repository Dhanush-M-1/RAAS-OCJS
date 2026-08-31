#include <bits/stdc++.h>
using namespace std;
int corners[4][2][2] = {
    {{0, 3}, {2, 3}}, {{2, 3}, {2, 1}}, {{2, 1}, {0, 1}}, {{0, 1}, {0, 3}}};
int steps[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
struct block {
  int data[4];
  block(int x, int y) {
    data[0] = x;
    data[1] = y;
    data[2] = 0;
    data[3] = 0;
  }
};
int m;
vector<block *> blocks[60];
string program[60];
vector<block *> cache;
bool ok(int a, int b) {
  return a >= 0 && a < m && b >= 0 && b < (int)program[0].size();
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> m >> n;
  for (int i = 0; i < m; ++i) cin >> program[i];
  for (int i = 0; i < m; ++i)
    for (size_t j = 0; j < program[i].size(); ++j)
      if (program[i][j] != '0') {
        char a = ok(i - 1, j) ? program[i - 1][j] : '0';
        char b = ok(i, j - 1) ? program[i][j - 1] : '0';
        if (a == program[i][j])
          blocks[i].push_back(blocks[i - 1][j]);
        else if (b == program[i][j])
          blocks[i].push_back(blocks[i][j - 1]);
        else {
          blocks[i].push_back(new block(i, j));
          cache.push_back(blocks[i][j]);
        }
        a = ok(i + 1, j) ? program[i + 1][j] : '0';
        b = ok(i, j + 1) ? program[i][j + 1] : '0';
        if (a != program[i][j] && b != program[i][j]) {
          blocks[i][j]->data[2] = i;
          blocks[i][j]->data[3] = j;
        }
      } else
        blocks[i].push_back(0);
  block *bp = blocks[0][0];
  int dp = 0;
  int cp = 0;
  for (int i = 0; i < n; ++i) {
    int x = bp->data[corners[dp][cp][0]] + steps[dp][0];
    int y = bp->data[corners[dp][cp][1]] + steps[dp][1];
    char c = ok(x, y) ? program[x][y] : '0';
    if (c != '0')
      bp = blocks[x][y];
    else {
      if (cp == 0)
        cp = 1;
      else {
        cp = 0;
        dp = (dp + 1) % 4;
      }
    }
  }
  cout << program[bp->data[0]][bp->data[1]] << endl;
  return 0;
}
