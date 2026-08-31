#include <bits/stdc++.h>
using namespace std;
const int N = 110;
struct node {
  int st, len, id;
} q[N];
bool s[N];
int t, m;
int main() {
  string ss;
  int a, id;
  while (cin >> t >> m) {
    id = 0;
    memset(s, false, sizeof(s));
    memset(q, 0, sizeof(q));
    for (int i = 0; i < t; i++) {
      cin >> ss;
      if (ss[0] == 'a') {
        cin >> a;
        int j = 1, k = 0;
        bool flag = false;
        while (1) {
          if (j > m || k > m) break;
          k = 0;
          while (1) {
            if (s[j + k] || j + k > m) break;
            k++;
          }
          if (k >= a) {
            for (int i = j; i <= j + a - 1; i++) {
              s[i] = true;
            }
            ++id;
            q[id] = (node){j, a, id};
            cout << id << endl;
            flag = true;
            break;
          }
          j++;
        }
        if (!flag) cout << "NULL" << endl;
      } else if (ss[0] == 'e') {
        cin >> a;
        if (a < 0 || a > id || q[a].id == 0) {
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        } else {
          for (int j = q[a].st; j <= q[a].st + q[a].len - 1; j++) {
            s[j] = false;
          }
          q[a].id = 0;
          q[a].st = 0;
          q[a].len = 0;
        }
      } else if (ss[0] == 'd') {
        int cnt = 0, k, j = 1, cur = 0;
        while (j <= m) {
          if (s[j]) {
            cnt++;
            for (k = 1; k <= id; k++)
              if (j == q[k].st) break;
            if (q[k].id > 0) {
              j += q[k].len - 1;
              if (cnt > 1) {
                q[k].st = cur + 1;
                cur += q[k].len;
              } else {
                cur = q[k].len;
                q[k].st = 1;
              }
            }
          }
          j++;
        }
        memset(s, false, sizeof(s));
        for (int j = 1; j <= cur; j++) {
          s[j] = true;
        }
      }
    }
  }
  return 0;
}
