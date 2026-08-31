#include <bits/stdc++.h>
using namespace std;
struct Block {
  int no;
  int start;
  int end;
};
vector<Block> blocks;
int m;
int h;
void alloc(int x) {
  for (int i = 0; i + 1 < blocks.size(); ++i) {
    if (blocks[i + 1].start - 1 - blocks[i].end >= x) {
      Block b;
      b.no = h + 1;
      b.start = blocks[i].end + 1;
      b.end = b.start + x - 1;
      blocks.insert(blocks.begin() + i + 1, b);
      cout << ++h << "\n";
      return;
    }
  }
  cout << "NULL\n";
}
void erase(int x) {
  for (int i = 1; i + 1 < blocks.size(); ++i) {
    if (blocks[i].no == x) {
      blocks.erase(blocks.begin() + i);
      return;
    }
  }
  cout << "ILLEGAL_ERASE_ARGUMENT\n";
}
void defragment() {
  for (int i = 1; i + 1 < blocks.size(); ++i) {
    int d = (blocks[i].start - blocks[i - 1].end - 1);
    blocks[i].start -= d;
    blocks[i].end -= d;
  }
}
int main() {
  int t;
  cin >> t >> m;
  Block end;
  Block start;
  start.no = -1;
  start.start = 0;
  start.end = 0;
  end.no = -1;
  end.start = m + 1;
  end.end = m + 1;
  blocks.push_back(start);
  blocks.push_back(end);
  while (t--) {
    string op;
    cin >> op;
    if (op == "alloc") {
      int x;
      cin >> x;
      alloc(x);
    } else if (op == "erase") {
      int x;
      cin >> x;
      erase(x);
    } else {
      defragment();
    }
  }
}
