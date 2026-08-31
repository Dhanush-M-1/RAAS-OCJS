#include <bits/stdc++.h>
using namespace std;
struct data {
  int x, h, left, right;
};
data tree[100005];
int main() {
  int n, ans = 2;
  scanf("%d", &n);
  if (n == 1) {
    printf("1\n");
    return 0;
  }
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &tree[i].x, &tree[i].h);
  }
  for (int j = 1; j < n - 1; j++) {
    tree[j].left = tree[j].x - tree[j - 1].x;
    tree[j].right = tree[j + 1].x - tree[j].x;
  }
  for (int k = 1; k < n - 1; k++) {
    if (tree[k].left > tree[k].h)
      ans++;
    else if (tree[k].right > tree[k].h) {
      ans++;
      tree[k + 1].left -= tree[k].h;
    }
  }
  printf("%d\n", ans);
  return 0;
}
