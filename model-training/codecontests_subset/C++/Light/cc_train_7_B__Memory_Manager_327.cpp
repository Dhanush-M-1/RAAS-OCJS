#include <bits/stdc++.h>
using namespace std;
int ar[102];
char inp[100];
char inp2[100];
long long p;
int main() {
  gets(inp);
  int n, m;
  sscanf(inp, "%d%d", &n, &m);
  int cnt = 1;
  for (int i = 0; i < n; i++) {
    gets(inp);
    if (inp[0] == 'd') {
      vector<int> ch;
      for (int t = 0; t < m; t++) {
        if (ar[t] != 0) ch.push_back(ar[t]);
      }
      memset(ar, 0, sizeof(ar));
      int k = 0;
      for (int t = 0; t < m && k < ch.size(); t++, k++) {
        ar[t] = ch[k];
      }
    } else if (inp[0] == 'e') {
      sscanf(inp, "%s%lld", inp2, &p);
      bool got = false;
      if (p > 0)
        for (int t = 0; t < m; t++) {
          if (ar[t] == p) {
            ar[t] = 0;
            got = true;
          }
        }
      if (!got) {
        puts("ILLEGAL_ERASE_ARGUMENT");
      }
    } else {
      sscanf(inp, "%s%lld", inp2, &p);
      bool perf = false;
      for (int t = 0; t + p <= m; t++) {
        int j = t;
        for (; j < t + p; j++)
          if (ar[j] != 0) break;
        if (j == t + p) {
          j = t;
          for (; j < t + p; j++) ar[j] = cnt;
          perf = true;
          printf("%d\n", cnt);
          cnt++;
          break;
        }
      }
      if (!perf) puts("NULL");
    }
  }
  return 0;
}
