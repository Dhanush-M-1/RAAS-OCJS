#include <bits/stdc++.h>
using namespace std;
inline int log(const char* format, ...) { return 0; }
const double EPS = 10e-8;
const int MAX = 1000;
const int INF = 1 << 30;
int main(int argc, char** argv) {
  int n, n100 = 0, n200 = 0;
  int num;
  scanf("%d", &n);
  int sum = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &num);
    sum += num;
    if (num == 100)
      n100++;
    else
      n200++;
  }
  int t = sum / 2;
  sum /= 2;
  while (n200 > 0 && sum - 200 >= 0) {
    sum -= 200;
    n200--;
  }
  while (n100 > 0 && sum - 100 >= 0) {
    sum -= 100;
    n100--;
  }
  if (sum == 0 && (n100 * 100 + n200 * 200 == t)) {
    printf("YES");
  } else {
    printf("NO");
  }
  return EXIT_SUCCESS;
}
