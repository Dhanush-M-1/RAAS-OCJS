#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const int INF = (int)1e8;
template <class T>
inline T getmin(T a, T b) {
  return a > b ? b : a;
}
template <class T>
inline T getmax(T a, T b) {
  return a > b ? a : b;
}
template <class T>
inline void checkmin(T& a, T b) {
  if (b < a) a = b;
}
template <class T>
inline void checkmax(T& a, T b) {
  if (b > a) a = b;
}
template <class T>
inline T getabs(T x) {
  return x > 0 ? x : -x;
}
const int MAXN = 105;
struct Node {
  bool flag;
  int ndx;
} dt[MAXN];
int t, m, x;
int fun1(int size) {
  for (int i = 0; i < m; i++) {
    if (dt[i].flag == false) {
      int tmp = 0;
      for (int j = 0; j < size && i + j < m; j++) {
        if (dt[i + j].flag == true) {
          break;
        } else
          tmp++;
      }
      if (tmp == size) {
        for (int j = 0; j < size && i + j < m; j++) {
          dt[i + j].ndx = x;
          dt[i + j].flag = true;
        }
        return 0;
      }
    }
  }
  return -1;
}
int fun2(int val) {
  if (val <= 0) return -1;
  bool flag = false;
  for (int i = 0; i < m; i++) {
    if (dt[i].ndx == val) {
      flag = true;
      dt[i].flag = false;
      dt[i].ndx = -1;
    }
  }
  if (!flag) return -1;
  return 0;
}
void fun3() {
  int ndx = 0;
  for (int i = 0; i < m; i++) {
    if (dt[i].flag == true) {
      dt[ndx].flag = true;
      dt[ndx++].ndx = dt[i].ndx;
    }
  }
  for (int i = ndx; i < m; i++) dt[i].flag = false, dt[i].ndx = -1;
}
int main() {
  char op[15];
  int val;
  while (scanf("%d%d", &t, &m) == 2) {
    x = 1;
    for (int i = 0; i < m; i++) dt[i].flag = false, dt[i].ndx = -1;
    while (t--) {
      scanf("%s", &op);
      if (op[0] == 'a') {
        scanf("%d", &val);
        int ret = fun1(val);
        if (ret == -1)
          puts("NULL");
        else
          printf("%d\n", x++);
      } else if (op[0] == 'e') {
        scanf("%d", &val);
        if (val == 0) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
        int ret = fun2(val);
        if (ret == -1) puts("ILLEGAL_ERASE_ARGUMENT");
      } else {
        fun3();
      }
    }
  }
  return 0;
}
