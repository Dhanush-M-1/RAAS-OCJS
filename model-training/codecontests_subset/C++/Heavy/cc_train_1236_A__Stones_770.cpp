#include <bits/stdc++.h>
int main(void) {
  int t, k, count, a, b, c, pick_from_a, pick_from_b;
  scanf("%d", &t);
  while (t) {
    scanf("%d %d %d", &a, &b, &c);
    count = 0;
    if (b < 2 * a) {
      pick_from_a = b / 2;
    } else {
      pick_from_a = a;
    }
    if (c < 2 * b) {
      pick_from_b = c / 2;
    } else {
      pick_from_b = b;
    }
    int count1 = 0, count2 = 0;
    count1 = pick_from_a * 3;
    k = b - 2 * pick_from_a;
    if (2 * k > c)
      count1 = count1 + 3 * (c / 2);
    else
      count1 = count1 + 3 * k;
    count2 = pick_from_b * 3;
    k = b - pick_from_b;
    if (2 * a > k)
      count2 = count2 + 3 * (k / 2);
    else
      count2 = count2 + 3 * a;
    if (count2 > count1)
      count = count2;
    else
      count = count1;
    printf("%d\n", count);
    t--;
  }
  return 0;
}
