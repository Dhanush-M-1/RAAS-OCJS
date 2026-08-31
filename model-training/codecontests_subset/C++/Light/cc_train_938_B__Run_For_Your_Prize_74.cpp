#include <bits/stdc++.h>
using namespace std;
int mn = 1000005, k;
int main() {
  int a, p;
  scanf("%i", &a);
  for (int i = 0; i < a; i++) {
    scanf("%i", &p);
    if (abs(p - 500000) < mn || (abs(p - 500000) <= mn && p > 500000)) {
      mn = abs(p - 500000);
      k = p;
    }
  }
  printf("%i", min(abs(k - 1), abs(k - 1000000)));
  return 0;
}
