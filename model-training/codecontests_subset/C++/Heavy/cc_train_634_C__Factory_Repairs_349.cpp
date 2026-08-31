#include <bits/stdc++.h>
using namespace std;
int n, k, a, b;
int orders[200007];
int can_produce[2][200007];
int tree[2][200007];
void update(int t, int i, int a) {
  while (i < 200007) {
    tree[t][i] += a;
    i += i & (-i);
  }
}
long long get(int t, int i) {
  long long sum = 0;
  while (i > 0) {
    sum += tree[t][i];
    i -= i & (-i);
  }
  return sum;
}
void add_order(int day, int val) {
  orders[day] += val;
  int old_can_produce[2] = {can_produce[0][day], can_produce[1][day]};
  can_produce[0][day] = min(b, orders[day]);
  can_produce[1][day] = min(a, orders[day]);
  for (int t = 0; t < (2); t++) {
    update(t, day, can_produce[t][day] - old_can_produce[t]);
  }
}
int main() {
  int q;
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0; i < (q); i++) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int d, a;
      scanf("%d%d", &d, &a);
      add_order(d, a);
    } else {
      int p;
      scanf("%d", &p);
      printf("%d\n",
             (int)(get(0, p - 1) + get(1, 200007 - 1) - get(1, p + k - 1)));
    }
  }
  return 0;
}
