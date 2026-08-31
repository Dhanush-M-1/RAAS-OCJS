#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
int b[N], no[N], n0, n, sum, cnt = 0, to[N], vis[N], ran[N];
vector<int> vec[N];
struct nd {
  int id, vl;
} a[N];
struct edge {
  int to, id;
};
vector<edge> e[N];
bool cmp(nd x, nd y) { return x.vl < y.vl; }
void init() {
  int i;
  for (i = 1; i <= n0; i++)
    if (b[i] == a[i].vl) no[i] = 1;
  n = 0;
  for (i = 1; i <= n0; i++)
    if (!no[i]) {
      a[++n].id = n;
      a[n].vl = a[i].vl;
      to[n] = i;
    }
}
void go0() {
  int i, l;
  printf("1\n");
  l = vec[1].size();
  printf("%d\n", l);
  for (i = 0; i < l; i++) printf("%d ", to[vec[1][i]]);
  printf("\n");
}
void go1() {
  int i, j, l;
  printf("%d\n", cnt);
  for (i = 1; i <= cnt; i++) {
    l = vec[i].size();
    printf("%d\n", l);
    for (j = 0; j < l; j++) printf("%d ", to[vec[i][j]]);
    printf("\n");
  }
}
void go2() {
  int i, j, l;
  printf("2\n");
  printf("%d\n", n);
  for (i = 1; i <= cnt; i++) {
    l = vec[i].size();
    for (j = 0; j < l; j++) printf("%d ", to[vec[i][j]]);
  }
  printf("\n");
  printf("%d\n", cnt);
  for (i = cnt; i; i--) printf("%d ", to[vec[i][0]]);
  printf("\n");
}
void go3() {
  int i, j, l;
  printf("%d\n", cnt - (sum - n) + 2);
  l = 0;
  for (i = 1; i <= sum - n; i++) l += vec[i].size();
  printf("%d\n", l);
  for (i = 1; i <= sum - n; i++) {
    l = vec[i].size();
    for (j = 0; j < l; j++) printf("%d ", to[vec[i][j]]);
  }
  printf("\n");
  printf("%d\n", sum - n);
  for (i = sum - n; i; i--) printf("%d ", to[vec[i][0]]);
  printf("\n");
  for (i = sum - n + 1; i <= cnt; i++) {
    l = vec[i].size();
    printf("%d\n", l);
    for (j = 0; j < l; j++) printf("%d ", to[vec[i][j]]);
    printf("\n");
  }
}
void euler(int x) {
  edge i;
  vis[x] = 1;
  while (!e[x].empty()) {
    i = e[x][e[x].size() - 1];
    e[x].pop_back();
    euler(i.to);
    vec[cnt].push_back(i.id);
  }
}
int main() {
  int i, j, k, l;
  scanf("%d%d", &n0, &sum);
  for (i = 1; i <= n0; i++) {
    scanf("%d", &a[i].vl);
    b[i] = a[i].vl;
  }
  sort(b + 1, b + n0 + 1);
  init();
  if (!n) {
    printf("0\n");
    return 0;
  }
  if (sum < n) {
    printf("-1\n");
    return 0;
  }
  sort(a + 1, a + n + 1, cmp);
  int num = 0;
  for (i = 1; i <= n; i = j + 1) {
    num++;
    j = i;
    while ((j < n) && (a[j + 1].vl == a[i].vl)) j++;
    for (k = i; k <= j; k++) ran[k] = num;
  }
  for (i = 1; i <= n; i++) e[ran[a[i].id]].push_back((edge){ran[i], a[i].id});
  for (i = 1; i <= num; i++)
    if (!vis[i]) {
      ++cnt;
      euler(i);
    }
  for (i = 1; i <= cnt; i++) {
    for (j = 0; j < vec[i].size(); j++) b[j] = vec[i][j];
    reverse(b, b + vec[i].size());
    for (j = 0; j < vec[i].size(); j++) vec[i][j] = b[j];
  }
  if (cnt == 1)
    go0();
  else if (sum - n <= 2)
    go1();
  else if (n + cnt <= sum)
    go2();
  else
    go3();
  return 0;
}
