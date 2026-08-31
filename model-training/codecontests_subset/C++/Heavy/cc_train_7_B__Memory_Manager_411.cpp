#include <bits/stdc++.h>
using namespace std;
struct node {
  int num, m, used;
};
int main() {
  int n, m;
  cin >> n >> m;
  int alloc_num = 0;
  vector<node> a;
  a.push_back(node{0, m, 0});
  while (n--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int t;
      cin >> t;
      int flag = 1;
      for (int i = 0; i < a.size(); i++) {
        if (a[i].used == 0 && a[i].m >= t) {
          cout << (++alloc_num) << endl;
          a[i].num = 0, a[i].used = 1;
          if (a[i].m > t) a.insert(a.begin() + i, node{0, a[i].m - t, 0});
          a.insert(a.begin() + i, node{alloc_num, t, 1});
          flag = 0;
          break;
        }
      }
      if (flag) cout << "NULL\n";
    } else if (s == "erase") {
      int t;
      cin >> t;
      int flag = 1;
      for (int i = 0; i < a.size(); i++) {
        if (a[i].num == t && a[i].used == 1) {
          a[i].used = 0, flag = 0;
          if (i >= 1 && a[i - 1].used == 0) {
            a[i].m += a[i - 1].m;
            a[i - 1].num = 0, a[i - 1].used = 1;
          }
          if (i + 1 < s.size() && a[i + 1].used == 0) {
            a[i].m += a[i + 1].m;
            a[i + 1].num = 0, a[i + 1].used = 1;
          }
        }
      }
      if (flag) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    } else {
      int sum = 0, flag = 0;
      for (int i = 0; i < a.size(); i++)
        if (a[i].used == 0) flag++;
      while (flag) {
        for (int i = 0; i < a.size(); i++) {
          if (a[i].used == 0) {
            sum += a[i].m;
            a.erase(a.begin() + i);
            flag--;
          }
        }
      }
      a.push_back(node{0, sum, 0});
    }
    int flag = 0;
    for (int i = 0; i < a.size(); i++)
      if (a[i].num == 0 && a[i].used == 1) flag++;
    while (flag) {
      for (int i = 0; i < a.size(); i++) {
        if (a[i].num == 0 && a[i].used == 1) {
          a.erase(a.begin() + i);
          flag--;
        }
      }
    }
  }
  return 0;
}
