#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double EPS = 1e-9;
const int nn = 1000;
struct item {
  int u, cnt;
  int id;
  item() {}
  item(const int a, const int b, const int c) : u(a), cnt(b), id(c) {}
};
int n, m, u = 0;
vector<item> mem;
int alloc(const int b) {
  int sz = (int((mem).size()));
  int last = 0;
  for (int i = 0; i < sz; ++i) {
    if (mem[i].u - last >= b) {
      mem.insert(mem.begin() + i, item(last, b, ++u));
      return u;
    }
    last = mem[i].u + mem[i].cnt;
  }
  if (m - last >= b) {
    mem.push_back(item(last, b, ++u));
    return u;
  }
  return -1;
}
int erase(const int id) {
  int sz = (int((mem).size()));
  for (int i = 0; i < sz; ++i)
    if (mem[i].id == id) {
      mem.erase(mem.begin() + i);
      return 0;
    }
  return 1;
}
void defragment() {
  int last = 0;
  int sz = (int((mem).size()));
  for (int i = 0; i < sz; ++i) {
    mem[i].u = last;
    last = mem[i].u + mem[i].cnt;
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    char com[256];
    int b;
    scanf("%s", com);
    if (!strcmp(com, "defragment"))
      defragment();
    else {
      scanf("%d\n", &b);
      if (!strcmp(com, "alloc")) {
        int t = alloc(b);
        if (t == -1)
          printf("NULL\n");
        else
          printf("%d\n", t);
      } else {
        if (erase(b)) printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    }
  }
  return 0;
}
