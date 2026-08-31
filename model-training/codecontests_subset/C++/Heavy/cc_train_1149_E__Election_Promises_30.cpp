#include <bits/stdc++.h>
const int max_N = 202401;
int n, m, A[max_N], topo[max_N], mex[max_N], xor_sum[max_N];
std::vector<int> G[max_N];
int read_int() {
  char c = getchar();
  int ans = 0;
  bool neg = false;
  while (!isdigit(c)) neg |= (c == '-'), c = getchar();
  while (isdigit(c)) ans = 10 * ans + c - '0', c = getchar();
  return neg ? -ans : ans;
}
void write_int(int x) {
  if (x < 0) putchar('-'), x = -x;
  if (x < 10)
    putchar(x + '0');
  else
    write_int(x / 10), putchar(x % 10 + '0');
}
int min(int x, int y) { return x < y ? x : y; }
int max(int x, int y) { return x > y ? x : y; }
void _min(int &x, int y) {
  if (x > y) x = y;
}
void _max(int &x, int y) {
  if (x < y) x = y;
}
void topo_sort() {
  static int deg[max_N];
  for (int i = 1; i <= n; i++)
    for (int j : G[i]) deg[j]++;
  std::queue<int> Q;
  for (int i = 1; i <= n; i++)
    if (!deg[i]) Q.push(i);
  while (!Q.empty()) {
    int cur = Q.front();
    Q.pop();
    topo[++*topo] = cur;
    for (int i : G[cur])
      if (!--deg[i]) Q.push(i);
  }
}
int main() {
  n = read_int(), m = read_int();
  for (int i = 1; i <= n; i++) A[i] = read_int();
  for (int i = 1, u, v; i <= m; i++)
    u = read_int(), v = read_int(), G[u].push_back(v);
  topo_sort();
  for (int i = n; i; i--) {
    static int tmp[max_N];
    for (int j : G[topo[i]]) tmp[mex[j]]++;
    while (tmp[mex[topo[i]]]) mex[topo[i]]++;
    for (int j : G[topo[i]]) tmp[mex[j]]--;
    xor_sum[mex[topo[i]]] ^= A[topo[i]];
  }
  if (std::count(xor_sum, xor_sum + n + 1, 0) == n + 1)
    puts("LOSE");
  else {
    puts("WIN");
    int X = n, Y = -1;
    while (xor_sum[X] == 0) X--;
    for (int i = 1; i <= n; i++)
      if (mex[i] == X && (A[i] ^ xor_sum[X]) < A[i]) {
        Y = i;
        break;
      }
    A[Y] ^= xor_sum[X];
    for (int i : G[Y])
      if (xor_sum[mex[i]]) A[i] ^= xor_sum[mex[i]], xor_sum[mex[i]] = 0;
    for (int i = 1; i <= n; i++) write_int(A[i]), putchar(i == n ? '\n' : ' ');
  }
  return 0;
}
