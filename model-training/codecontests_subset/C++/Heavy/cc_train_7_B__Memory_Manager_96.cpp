#include <bits/stdc++.h>
using namespace std;
class manager {
  int *mem;
  int *block[3];
  int curBlock;
  int maxMem;
  int addBlock(int n, int pos);
  int moveBlock(int x);

 public:
  manager(int m, int t);
  ~manager();
  int alloc(int n);
  int erase(int x);
  int defrag();
  void print();
  void operate(char c, int n);
};
manager::manager(int m, int t) {
  curBlock = 0;
  maxMem = m;
  mem = new int[m];
  for (int i = 0; i < m; i++) {
    mem[i] = m - i;
  }
  block[0] = new int[t];
  block[1] = new int[t];
  block[2] = new int[t];
}
manager::~manager() {
  delete[] mem;
  delete[] block[0];
  delete[] block[1];
  delete[] block[2];
}
int manager::alloc(int n) {
  int pos = 0;
  while (pos < maxMem) {
    if (mem[pos] <= 0)
      pos = block[0][-mem[pos]] + block[1][-mem[pos]];
    else if (mem[pos] < n)
      pos += mem[pos];
    else
      return addBlock(n, pos);
  }
  return -1;
}
int manager::addBlock(int n, int pos) {
  block[0][curBlock] = pos;
  block[1][curBlock] = n;
  block[2][curBlock] = 1;
  for (int i = pos; i < pos + n; i++) mem[i] = -curBlock;
  return ++curBlock;
}
int manager::erase(int x) {
  --x;
  if (x < 0 || x >= curBlock || block[2][x] == 0) return -1;
  int i = block[0][x] + block[1][x] - 1;
  if (i == maxMem - 1 || mem[i + 1] < 0)
    mem[i] = 1;
  else
    mem[i] = mem[i + 1] + 1;
  --i;
  while (i >= 0 && (mem[i] == -x || mem[i] > 0)) {
    mem[i] = mem[i + 1] + 1;
    --i;
  }
  block[2][x] = 0;
  return 0;
}
int manager::defrag() {
  int pos = 0;
  while (pos < maxMem) {
    if (mem[pos] <= 0) {
      int b = -mem[pos];
      pos += block[1][b];
      moveBlock(b);
    } else
      pos += mem[pos];
  }
  return 0;
}
int manager::moveBlock(int x) {
  int pos = block[0][x];
  if (pos - 1 < 0 || mem[pos - 1] <= 0) {
    return 0;
  } else
    --pos;
  while (pos - 1 >= 0 && mem[pos - 1] > 0) --pos;
  int n = block[1][x];
  int endPos = block[0][x] + n - 1;
  int i;
  for (i = 0; i < n; i++) {
    mem[pos + i] = -x;
  }
  if (endPos == maxMem - 1 || mem[endPos + 1] <= 0) {
    mem[endPos] = 1;
  } else {
    mem[endPos] = mem[endPos + 1] + 1;
  }
  for (int j = endPos - 1; j >= pos + i; j--) {
    mem[j] = mem[j + 1] + 1;
  }
  block[0][x] = pos;
  return 0;
}
void manager::print() {
  for (int i = 0; i < maxMem; i++) {
    cout << mem[i] << " ";
  }
  cout << endl;
}
void manager::operate(char c, int n) {
  if (c == 'a') {
    int ans = alloc(n);
    if (ans == -1)
      cout << "NULL\n";
    else
      cout << ans << endl;
  } else if (c == 'e') {
    int ans = erase(n);
    if (ans == -1) cout << "ILLEGAL_ERASE_ARGUMENT\n";
  } else if (c == 'd') {
    defrag();
  }
}
int main() {
  int m, t;
  cin >> t >> m;
  manager man(m, t);
  string op;
  int n = 0;
  for (int i = 0; i < t; i++) {
    cin >> op;
    if (op[0] != 'd') cin >> n;
    man.operate(op[0], n);
  }
  return 0;
}
