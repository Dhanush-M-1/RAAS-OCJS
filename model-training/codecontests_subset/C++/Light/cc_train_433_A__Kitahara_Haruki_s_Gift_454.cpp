#include <bits/stdc++.h>
using namespace std;
const int oo = (int)1e9;
const double eps = 1e-9;
int main() {
  int n;
  cin >> n;
  int c100 = 0, c200 = 0, temp;
  for (int i = 0; i < n; i++) {
    cin >> temp;
    if (temp == 200) {
      c200++;
    } else {
      c100++;
    }
  }
  if (c200 == 0) {
    if (c100 % 2 == 0) {
      printf("YES\n");
      return 0;
    } else {
      printf("NO\n");
      return 0;
    }
  } else {
    if (c100) {
      if (c100 % 2 == 0) {
        printf("YES\n");
        return 0;
      } else {
        printf("NO\n");
        return 0;
      }
    } else {
      if (c200 % 2 == 0) {
        printf("YES\n");
        return 0;
      }
    }
  }
  printf("NO");
  return 0;
}
