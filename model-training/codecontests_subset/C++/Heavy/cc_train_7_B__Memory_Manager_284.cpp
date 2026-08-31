#include <bits/stdc++.h>
using namespace std;
struct data {
  int flag, x, next;
} a[105];
int main() {
  int n, m, head = 1, t = 0, x, p, q = 1, len, ans, f;
  string s;
  cin >> n >> m;
  a[1].flag = 0, a[1].x = m, a[1].next = 0;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    if (s[0] == 'a') {
      cin >> x;
      p = head;
      ans = 0;
      while (p > 0) {
        int x1 = a[p].x;
        if (a[p].flag == 0 && x1 >= x) {
          if (x1 == x)
            a[p].flag = ++t;
          else {
            a[p].flag = ++t;
            a[++q].flag = 0;
            a[q].next = a[p].next;
            a[p].next = q;
            a[p].x = x;
            a[q].x = x1 - x;
          }
          ans = t;
          break;
        }
        p = a[p].next;
      }
      if (ans == 0)
        cout << "NULL" << endl;
      else
        cout << ans << endl;
    }
    if (s[0] == 'e') {
      cin >> x;
      p = head;
      f = 0;
      while (p > 0) {
        if (a[p].flag == x && x != 0) {
          a[p].flag = 0;
          f = 1;
          break;
        }
        p = a[p].next;
      }
      if (f == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      p = head;
      while (p > 0) {
        int p1 = a[p].next;
        if (a[p].flag == 0 && a[p1].flag == 0 && p1 != 0) {
          a[p].x = a[p].x + a[p1].x;
          a[p].next = a[p1].next;
        } else
          p = a[p].next;
      }
    }
    if (s[0] == 'd') {
      p = head;
      len = 0;
      while (p > 0) {
        int p1 = a[p].next;
        if (a[p].flag == 0 && p1 != 0) {
          len += a[p].x;
          a[p] = a[p1];
        } else if (a[p].flag == 0 && p1 == 0) {
          a[p].x = a[p].x + len;
          break;
        } else if (a[p].flag != 0 && p1 == 0) {
          q++;
          a[p].next = q;
          a[q].flag = 0;
          a[q].x = len;
          break;
        }
        p = a[p].next;
      }
    }
  }
  return 0;
}
