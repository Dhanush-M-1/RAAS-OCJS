#include <bits/stdc++.h>
using namespace std;
map<int, int> mm;
struct s {
  int x, h;
} a[100005];
bool cmp(const s& xx, const s& yy) { return xx.h < yy.h; }
int hehe[300005], k, c[500005];
int lowbit(int t) { return t & (-t); }
void insert(int x, int d) {
  while (x <= k) {
    c[x] += d;
    x += lowbit(x);
  }
}
int get_sum(int x) {
  int sum = 0;
  while (x > 0) {
    sum += c[x];
    x -= lowbit(x);
  }
  return sum;
}
int main() {
  int n;
  scanf("%d", &n);
  k = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &a[i].x, &a[i].h);
    hehe[++k] = a[i].x;
    hehe[++k] = max(1, a[i].x - a[i].h);
    hehe[++k] = a[i].x + a[i].h;
  }
  sort(hehe + 1, hehe + k + 1);
  for (int i = 1; i <= k; i++) mm[hehe[i]] = i;
  for (int i = 0; i < n; i++) {
    insert(mm[a[i].x], 1);
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int L = max(a[i].x - a[i].h, 1);
    int R = a[i].x + a[i].h;
    int suml = get_sum(mm[a[i].x] - 1) - get_sum(mm[L] - 1);
    int sumr = get_sum(mm[R]) - get_sum(mm[a[i].x]);
    if (suml == 0 || sumr == 0) ans++;
    if (sumr == 0 && suml != 0) {
      insert(mm[R], 1);
    }
  }
  printf("%d\n", ans);
  return 0;
}
