#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  printf("%.0f", ceil((a - b) * c / (double)b));
  return 0;
}
