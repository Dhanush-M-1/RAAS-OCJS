#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
void update(vector<int> &tree, int day, int diff) {
  while (day <= n) {
    tree[day] += diff;
    day += (-day & day);
  }
}
int sum(vector<int> &tree, int ed) {
  int sumv = 0;
  while (ed >= 1) {
    sumv += tree[ed];
    ed -= (-ed & ed);
  }
  return sumv;
}
int main() {
  vector<int> save(200001);
  vector<int> fta(200001);
  vector<int> ftb(200001);
  scanf("%d", &n);
  scanf("%d", &k);
  scanf("%d", &a);
  scanf("%d", &b);
  scanf("%d", &q);
  while (q--) {
    int q1 = 0;
    scanf("%d", &q1);
    if (q1 == 1) {
      int day, order;
      scanf("%d", &day);
      scanf("%d", &order);
      update(fta, day, min(save[day] + order, a) - min(save[day], a));
      update(ftb, day, min(save[day] + order, b) - min(save[day], b));
      save[day] += order;
    } else if (q1 == 2) {
      int sd;
      scanf("%d", &sd);
      int anw = sum(fta, n) - sum(fta, sd + k - 1) + sum(ftb, sd - 1);
      printf("%d\n", anw);
    }
  }
}
