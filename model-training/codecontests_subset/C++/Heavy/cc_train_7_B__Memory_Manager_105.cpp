#include <bits/stdc++.h>
using namespace std;
int a[101];
int b[101];
struct item {
  int loc;
  int len;
  int num;
};
struct item v[100];
int main() {
  memset(a, 0, sizeof(int) * 101);
  memset(b, 0, sizeof(int) * 101);
  int t, m;
  cin >> t >> m;
  list<item> vf;
  struct item it = {0, m, 0};
  vf.push_back(it);
  int c = 0;
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int at;
      cin >> at;
      bool flag = false;
      for (list<item>::iterator j = vf.begin(); j != vf.end(); j++) {
        if (j->len > at) {
          struct item it = {j->loc, at, ++c};
          struct item ti = {j->loc + at, j->len - at, 0};
          v[c] = it;
          b[j->loc] = c;
          a[c] = 1;
          *j = ti;
          flag = true;
          break;
        } else {
          if (j->len == at) {
            struct item it = {j->loc, at, ++c};
            v[c] = it;
            b[j->loc] = c;
            a[c] = 1;
            vf.erase(j);
            flag = true;
            break;
          }
        }
      }
      if (flag == false) {
        cout << "NULL" << endl;
      } else {
        cout << c << endl;
      }
    } else {
      if (s == "erase") {
        int at;
        cin >> at;
        if (0 <= at && at <= t && a[at] == 1) {
          a[at] = 0;
          struct item ti = v[at];
          b[v[at].loc] = 0;
          list<item>::iterator j = vf.begin();
          for (; j != vf.end();) {
            if (j->loc + j->len == ti.loc) {
              struct item it = {j->loc, j->len + ti.len, 0};
              ti = it;
              j = vf.erase(j);
            } else {
              if (ti.loc + ti.len == j->loc) {
                struct item it = {ti.loc, j->len + ti.len, 0};
                ti = it;
                j = vf.erase(j);
              } else {
                if (j->loc > ti.loc) {
                  break;
                }
                j++;
              }
            }
          }
          vf.insert(j, ti);
        } else {
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        }
      } else {
        int s = 0;
        for (int j = 0; j < 100; j++) {
          if (b[j]) {
            v[b[j]].loc = s;
            b[s] = b[j];
            if (j != s) {
              b[j] = 0;
            }
            s += v[b[s]].len;
          }
        }
        struct item it = {s, m - s, 0};
        vf.clear();
        vf.push_back(it);
      }
    }
  }
  return 0;
}
