#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[201];
struct infor {
  int kind;
  int num;
};
infor cao[201];
void init_infor() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    string p;
    cin >> p;
    if (p == "alloc") {
      cao[i].kind = 1;
      cin >> cao[i].num;
    } else if (p == "erase") {
      cao[i].kind = 2;
      cin >> cao[i].num;
    } else {
      cao[i].kind = 3;
    }
  }
  a[m + 1] = -1;
}
void solve_infor() {
  init_infor();
  int hao = 0;
  bool ok;
  for (int i = 1; i <= n; i++) {
    if (cao[i].kind == 1) {
      ok = false;
      for (int j = 1; j <= m; j++) {
        if (a[j] == 0) {
          int k = j;
          while (a[k] == 0 && k - j + 1 <= cao[i].num && k <= m) k++;
          k--;
          if (k - j + 1 >= cao[i].num) {
            hao++;
            for (int z = j; z <= j + cao[i].num - 1; z++) {
              a[z] = hao;
            }
            ok = true;
            break;
          }
          j = k;
        }
      }
      if (ok == false) {
        cout << "NULL" << endl;
      } else {
        cout << hao << endl;
      }
    } else if (cao[i].kind == 2) {
      ok = false;
      for (int j = 1; j <= m; j++) {
        if (a[j] == cao[i].num) {
          a[j] = 0;
          ok = true;
        }
      }
      if (ok == false || cao[i].num == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      int k = 0;
      int w = 0;
      while (w < m) {
        w++;
        if (a[w] != 0) {
          k++;
          a[k] = a[w];
          if (k != w) a[w] = 0;
        }
      }
    }
  }
}
int main() {
  solve_infor();
  return 0;
}
