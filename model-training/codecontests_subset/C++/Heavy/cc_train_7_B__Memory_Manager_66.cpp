#include <bits/stdc++.h>
using namespace std;
int t, m, n, mem[100], i, j, cur;
pair<int, int> blocks[101];
char str[50];
bool found, yes;
int main() {
  scanf("%d %d", &t, &m);
  for (i = 1; i <= 100; ++i) blocks[i].first = -1;
  for (int q = 0; q < t; ++q) {
    scanf("%s", &str);
    switch (str[0]) {
      case 'a':
        scanf(" %d", &n);
        found = false;
        for (i = 0; i <= m - n; ++i) {
          yes = true;
          for (j = i; j < i + n; ++j)
            if (mem[j] > 0) {
              yes = false;
              break;
            }
          if (yes) {
            found = true;
            blocks[++cur] = make_pair(i, n);
            for (j = i; j < i + n; ++j) mem[j] = cur;
            break;
          }
        }
        if (found)
          printf("%d\n", cur);
        else
          printf("NULL\n");
        break;
      case 'e':
        scanf(" %d", &n);
        if (n <= 0 || n > cur || blocks[n].first == -1)
          printf("ILLEGAL_ERASE_ARGUMENT\n");
        else {
          for (j = blocks[n].first; j < blocks[n].first + blocks[n].second; ++j)
            mem[j] = 0;
          blocks[n].first = -1;
        }
        break;
      case 'd':
        for (j = 1; j < m; ++j)
          while (j >= 1 && mem[j] > 0 && mem[j - 1] == 0) {
            int nmb = mem[j];
            mem[j + blocks[nmb].second - 1] = 0;
            mem[j - 1] = nmb;
            --blocks[nmb].first;
            j--;
          }
    }
    getchar();
  }
}
