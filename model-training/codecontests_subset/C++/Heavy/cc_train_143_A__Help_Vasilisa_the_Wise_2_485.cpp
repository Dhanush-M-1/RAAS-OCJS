#include <bits/stdc++.h>
using namespace std;
int main() {
  int x0, x1, y0, y1;
  int in1, in2, in3, in4, in5, in6;
  scanf("%d%d%d%d%d%d", &in1, &in2, &in3, &in4, &in5, &in6);
  x0 = (in3 + in5 - in2) / 2;
  x1 = in3 - x0;
  y0 = in1 - x0;
  y1 = in5 - x0;
  if (x0 <= 0 || x1 <= 0 || y0 <= 0 || y1 <= 0) {
    printf("-1");
    return 0;
  }
  int arr[4];
  arr[0] = x0;
  arr[1] = x1;
  arr[2] = y0;
  arr[3] = y1;
  if (x0 >= 10 || x0 <= 0 || x1 >= 10 || x1 <= 0 || y0 >= 10 || y0 <= 0 ||
      y1 >= 10 || y1 <= 0) {
    printf("-1");
    return 0;
  }
  for (int(i) = (0); (i) < (4); (i)++) {
    for (int(j) = (i + 1); (j) < (4); (j)++) {
      if (arr[i] == arr[j]) {
        printf("-1");
        return 0;
      }
    }
  }
  printf("%d %d\n%d %d", x0, y0, x1, y1);
  return 0;
}
