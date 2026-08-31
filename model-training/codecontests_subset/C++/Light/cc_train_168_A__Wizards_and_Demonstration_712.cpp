#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  double people = double(n * y) / 100;
  int all_people = int(people);
  if ((people - int(people)) > 0) {
    all_people++;
  }
  int res = all_people - x;
  if (res < 0) {
    res = 0;
  }
  printf("%d\n", res);
  return 0;
}
