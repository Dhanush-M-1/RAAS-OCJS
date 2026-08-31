#include <bits/stdc++.h>
using namespace std;
struct node {
  int x;
  int y;
};
int Max(int x, int y) { return x > y ? x : y; }
int Min(int x, int y) { return x < y ? x : y; }
int cmp(const void *a, const void *b) { return *(int *)a - *(int *)b; }
queue<int> Q;
stack<int> S;
int n, m;
int res, tmp;
char s[1005];
int a[30];
int main() {
  int i, j;
  while (scanf("%d", &n) != EOF) {
    scanf("%s", s);
    int len = strlen(s);
    memset(a, 0, sizeof(a));
    for (i = 0; i < len; ++i) {
      a[s[i] - 'a']++;
    }
    bool flag = true;
    for (i = 0; i < 26; ++i)
      if (a[i] % n) flag = false;
    if (!flag)
      puts("-1");
    else {
      int k;
      for (k = 1; k <= n; ++k) {
        for (i = 0; i < 26; ++i)
          for (j = 0; j < a[i] / n; ++j) printf("%c", i + 'a');
      }
      printf("\n");
    }
  }
  return 0;
}
