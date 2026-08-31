#include <bits/stdc++.h>
using namespace std;
long long v[110];
int main() {
  memset(v, 0, sizeof(v));
  int n, m;
  scanf("%d%d", &n, &m);
  long long id = 1;
  for (int i = 0; i < n; i++) {
    string str;
    cin >> str;
    if (str[0] == 'a') {
      long long vi;
      cin >> vi;
      int ok = 0;
      for (int j = 0; j < m; j++) {
        if (v[j]) continue;
        long long c = 0;
        for (int k = j; k < m; k++) {
          if (v[k]) break;
          c++;
        }
        if (c >= vi) {
          for (int k = j; k < m; k++) {
            v[k] = id;
            vi--;
            if (!vi) break;
          }
          ok = 1;
          break;
        }
      }
      if (ok)
        cout << (id++) << endl;
      else
        printf("NULL\n");
    } else if (str[0] == 'e') {
      long long f;
      cin >> f;
      if (f == 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      int ok = 0;
      for (int j = 0; j < m; j++) {
        if (v[j] == f) {
          ok = 1;
          for (int k = j; k < m; k++) {
            if (v[k] == f)
              v[k] = 0;
            else
              break;
          }
          break;
        }
      }
      if (!ok) printf("ILLEGAL_ERASE_ARGUMENT\n");
    } else {
      for (int i = 0; i < m; i++) {
        if (!v[i]) {
          for (int j = i + 1; j < m; j++) {
            if (v[j]) {
              swap(v[i], v[j]);
              break;
            }
          }
        }
      }
    }
  }
}
