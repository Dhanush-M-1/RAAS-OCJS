#include <bits/stdc++.h>
using namespace std;
double n, m, k, a, b, c;
string s;
vector<double> v;
int main() {
  scanf("%lf %lf %lf", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    printf("0\n");
    return 0;
  }
  if (b * b - 4 * a * c < 0) {
    printf("0\n");
    return 0;
  }
  if (a == 0) {
    printf("1\n");
    double cev = -c / b;
    printf("%lf", cev);
    return 0;
  }
  if (b * b - 4 * a * c == 0) {
    printf("1\n");
    double cev = -b / (2 * a);
    printf("%lf", cev);
    return 0;
  }
  printf("2\n");
  double cev = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
  double cevap = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
  v.push_back(cev);
  v.push_back(cevap);
  sort(v.begin(), v.end());
  printf("%lf\n", v[0]);
  printf("%lf\n", v[1]);
  return 0;
}
