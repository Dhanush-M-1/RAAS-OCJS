#include <bits/stdc++.h>
using namespace std;
int a[102];
int main() {
  int t, m;
  cin >> t >> m;
  int j = 1;
  a[m + 1] = 1000;
  while (t--) {
    string s;
    int n;
    cin >> s;
    if (s == "alloc" || s == "erase") {
      cin >> n;
    }
    if (s == "alloc") {
      int dem = 0;
      int i = 1;
      bool k = true;
      for (i = 1; i <= m + 1; i++) {
        if (a[i] == 0 && dem < n) {
          dem++;
        } else if (dem == n) {
          cout << j << endl;
          k = false;
          break;
        } else if (a[i] != 0 && dem < n) {
          dem = 0;
        }
      }
      if (k == true) {
        cout << "NULL" << endl;
        continue;
      } else if (k == false) {
        while (dem--) {
          a[i - 1] = j;
          i--;
        }
        j++;
      }
      continue;
    }
    if (s == "erase") {
      bool k = true;
      for (int i = 1; i <= m; i++) {
        if (a[i] == n) {
          k = false;
          a[i] = 0;
        }
      }
      if (k == true || n == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
      continue;
    }
    if (s == "defragment") {
      queue<int> q;
      for (int i = 1; i <= m; i++) {
        if (a[i] != 0) q.push(a[i]);
      }
      for (int i = 1; i <= m; i++) {
        if (q.size() != 0) {
          a[i] = q.front();
          q.pop();
        } else
          a[i] = 0;
      }
    }
  }
  return 0;
}
