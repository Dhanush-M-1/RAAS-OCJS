#include <bits/stdc++.h>
inline int _abs(const int x) { return x >= 0 ? x : -x; }
inline int _max(const int x, const int y) { return x >= y ? x : y; }
inline int _min(const int x, const int y) { return x <= y ? x : y; }
inline int _gcd(const int x, const int y) { return y ? _gcd(y, x % y) : x; }
inline int _lcm(const int x, const int y) { return x * y / _gcd(x, y); }
inline int read() {
  int fh = 1, x = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') fh = -1;
    ch = getchar();
  }
  while ('0' <= ch && ch <= '9') {
    x = (x << 3) + (x << 1) + ch - '0';
    ch = getchar();
  }
  return fh * x;
}
inline void write(const int x, const char &ch) {
  int top = 0, cp = _abs(x);
  char stk[25];
  if (x == 0) {
    putchar('0');
    putchar(ch);
    return;
  }
  while (cp) stk[++top] = (cp % 10) + 48, cp /= 10;
  if (x < 0) stk[++top] = '-';
  while (top) putchar(stk[top--]);
  putchar(ch);
}
int t, m, it = 1;
int memory[105];
inline void alloc(const int x) {
  int find = 0, st = 0;
  for (int i = 1; i <= m; i++) {
    if (memory[i] == 0 && find == 0)
      find++, st = i;
    else if (memory[i] == 0)
      find++;
    else
      find = 0;
    if (find >= x) {
      for (int j = st; j <= i; j++) memory[j] = it;
      write(it, '\n');
      it++;
      return;
    }
  }
  printf("NULL\n");
}
inline void erase(const int x) {
  if (x < 1 || x > it) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  for (int i = 1; i <= m; i++)
    if (memory[i] == x) {
      int p = i;
      while (memory[p] == x) memory[p++] = 0;
      return;
    }
  printf("ILLEGAL_ERASE_ARGUMENT\n");
}
inline void defragment() {
  std::queue<int> Q;
  for (int i = 1; i <= m; i++)
    if (memory[i] != 0) Q.push(memory[i]);
  int i = 1;
  memset(memory, 0, sizeof(memory));
  while (Q.size()) {
    memory[i++] = Q.front();
    Q.pop();
  }
}
signed main() {
  t = read(), m = read();
  for (int i = 1; i <= t; i++) {
    std::string st;
    std::cin >> st;
    if (st == "alloc") alloc(read());
    if (st == "erase") erase(read());
    if (st == "defragment") defragment();
  }
  return 0;
}
