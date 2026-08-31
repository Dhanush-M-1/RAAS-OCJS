#include <bits/stdc++.h>
using namespace std;
struct Block {
  int color;
  int right_up;
  int right_down;
  int down_right;
  int down_left;
  int left_down;
  int left_up;
  int up_left;
  int up_right;
  int top;
  int bottom;
  int left;
  int right;
  Block(int c, int l, int r, int t, int b)
      : color(c), left(l), right(r), top(t), bottom(b) {}
  Block() {}
};
void block_map_fill(int, int, vector<string>&, vector<Block>&,
                    vector<vector<short> >&);
void blocks_charact_fill(int, int, Block&, vector<vector<short> >&);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int k;
  int h;
  int m;
  cin >> h;
  cin >> k;
  vector<string> vec(h);
  cin >> vec[0];
  m = vec[0].length();
  vector<vector<short> > block_map(h, vector<short>(m, 0));
  for (int i = 1; i < h; ++i) {
    cin >> vec[i];
  }
  vector<Block> blocks(1);
  block_map_fill(h, m, vec, blocks, block_map);
  for (int i = 1; i < blocks.size(); i++) {
    blocks_charact_fill(h, m, blocks[i], block_map);
  }
  int status = 0;
  int cur = 1;
  for (int i = 0; i < k; ++i) {
    if (status == 0 && blocks[cur].right_up != 0) {
      cur = blocks[cur].right_up;
    } else if (status == 1 && blocks[cur].right_down != 0) {
      cur = blocks[cur].right_down;
    } else if (status == 2 && blocks[cur].down_right != 0) {
      cur = blocks[cur].down_right;
    } else if (status == 3 && blocks[cur].down_left != 0) {
      cur = blocks[cur].down_left;
    } else if (status == 4 && blocks[cur].left_down != 0) {
      cur = blocks[cur].left_down;
    } else if (status == 5 && blocks[cur].left_up != 0) {
      cur = blocks[cur].left_up;
    } else if (status == 6 && blocks[cur].up_left != 0) {
      cur = blocks[cur].up_left;
    } else if (status == 7 && blocks[cur].up_right != 0) {
      cur = blocks[cur].up_right;
    } else {
      ++status;
      status %= 8;
    }
  }
  cout << blocks[cur].color - '0';
}
void block_map_fill(int h, int m, vector<string>& vec, vector<Block>& blocks,
                    vector<vector<short> >& block_map) {
  short num = 1;
  for (int i = 0; i < h; ++i) {
    for (int j = 0; j < m; ++j) {
      if (block_map[i][j] == 0 && vec[i][j] != '0') {
        int fin_x = i;
        int fin_y = j;
        while (fin_x + 1 < h && vec[fin_x + 1][j] == vec[i][j]) {
          ++fin_x;
        }
        while (fin_y + 1 < m && vec[i][fin_y + 1] == vec[i][j]) {
          ++fin_y;
        }
        for (int x = i; x <= fin_x; ++x) {
          for (int y = j; y <= fin_y; ++y) {
            block_map[x][y] = num;
          }
        }
        blocks.push_back(Block(vec[i][j], j, fin_y, i, fin_x));
        ++num;
      }
    }
  }
}
void blocks_charact_fill(int h, int m, Block& thisBlock,
                         vector<vector<short> >& block_map) {
  if (thisBlock.right + 1 < m) {
    thisBlock.right_down = block_map[thisBlock.bottom][thisBlock.right + 1];
    thisBlock.right_up = block_map[thisBlock.top][thisBlock.right + 1];
  } else {
    thisBlock.right_down = 0;
    thisBlock.right_up = 0;
  }
  if (thisBlock.left - 1 >= 0) {
    thisBlock.left_down = block_map[thisBlock.bottom][thisBlock.left - 1];
    thisBlock.left_up = block_map[thisBlock.top][thisBlock.left - 1];
  } else {
    thisBlock.left_down = 0;
    thisBlock.left_up = 0;
  }
  if (thisBlock.bottom + 1 < h) {
    thisBlock.down_right = block_map[thisBlock.bottom + 1][thisBlock.right];
    thisBlock.down_left = block_map[thisBlock.bottom + 1][thisBlock.left];
  } else {
    thisBlock.down_right = 0;
    thisBlock.down_left = 0;
  }
  if (thisBlock.top - 1 >= 0) {
    thisBlock.up_right = block_map[thisBlock.top - 1][thisBlock.right];
    thisBlock.up_left = block_map[thisBlock.top - 1][thisBlock.left];
  } else {
    thisBlock.up_right = 0;
    thisBlock.up_left = 0;
  }
}
