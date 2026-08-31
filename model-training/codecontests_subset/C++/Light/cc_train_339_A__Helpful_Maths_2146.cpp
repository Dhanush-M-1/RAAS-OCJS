#include <bits/stdc++.h>
using namespace std;
bool compare(int a, int b) { return a < b; }
int main() {
  int n, i, j, t;
  int sum1 = 0;
  int sum2 = 0;
  char c[1000];
  char z[1000];
  char k[1000];
  cin >> c;
  if (c[1] == '\0')
    cout << c[0] << endl;
  else {
    for (n = 0; c[n] != '\0'; n++)
      if (c[n] == '+') {
        k[sum1] = '+';
        sum1++;
      } else {
        z[sum2] = c[n];
        sum2++;
      }
    sort(z, z + sum2, compare);
    for (i = 0; i < sum1; i++) {
      printf("%c", z[i]);
      printf("%c", k[i]);
    }
    printf("%c\n", z[sum2 - 1]);
  }
  return 0;
}
