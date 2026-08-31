#include <bits/stdc++.h>
using namespace std;
const int maxn = 205;
int pos[maxn];
int num;
string s;
int d;
int n, m;
void add() {
  cin >> d;
  int flag = -1;
  for (int j = 1; j <= m; j++) {
    int p = 0;
    for (int k = j; k <= j + d - 1 && k <= m; k++)
      if (pos[k] == 0) p++;
    if (p == d) {
      flag = j;
      break;
    }
  }
  if (flag == -1) {
    printf("NULL\n");
    return;
  } else {
    num++;
    for (int i = flag; i <= flag + d - 1; i++) pos[i] = num;
    printf("%d\n", num);
  }
}
void del() {
  int d;
  cin >> d;
  if (d <= 0) {
    printf("ILLEGAL_ERASE_ARGUMENT\n");
    return;
  }
  int flag = -1;
  for (int i = 1; i <= m; i++)
    if (pos[i] == d) flag = 1, pos[i] = 0;
  if (flag == -1) printf("ILLEGAL_ERASE_ARGUMENT\n");
}
void getsort() {
  int i = 1, j = 1;
  for (i = 1; i <= m; i++)
    if (pos[i]) pos[j++] = pos[i];
  for (; j <= m; j++) pos[j] = 0;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    cin >> s;
    if (s == "alloc") add();
    if (s == "erase") del();
    if (s == "defragment") getsort();
  }
}
