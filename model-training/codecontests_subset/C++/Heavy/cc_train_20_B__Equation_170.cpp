#include <bits/stdc++.h>
using namespace std;
vector<double> roots;
int main() {
  double a, b, c;
  scanf("%lf%lf%lf", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    printf("0\n");
    return 0;
  }
  if (a == 0) {
    printf("1\n");
    printf("%.5lf\n", -c / b);
    return 0;
  }
  if (b * b < 4 * a * c) {
    printf("0\n");
    return 0;
  }
  roots.push_back((-b + sqrt(b * b - 4 * a * c)) / (2 * a));
  if ((-b + sqrt(b * b - 4 * a * c)) / (2 * a) !=
      (-b - sqrt(b * b - 4 * a * c)) / (2 * a))
    roots.push_back((-b - sqrt(b * b - 4 * a * c)) / (2 * a));
  sort(roots.begin(), roots.end());
  printf("%d\n", roots.size());
  for (int i = 0; i < roots.size(); i++) printf("%.5lf\n", roots[i]);
  return 0;
}
