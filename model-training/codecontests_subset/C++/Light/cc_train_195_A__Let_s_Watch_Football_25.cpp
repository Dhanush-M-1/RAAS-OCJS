#include <bits/stdc++.h>
using namespace std;
int a, b, c;
bool isok(int t0) {
  int tmp = b * t0;
  for (int i = 1; i <= c; i++)
    if (tmp + b * i < a * i) return false;
  return true;
}
int main() {
  cin >> a >> b >> c;
  for (int i = 0; i <= 1000000; i++)
    if (isok(i)) {
      printf("%d\n", i);
      return 0;
    }
  return 0;
}
