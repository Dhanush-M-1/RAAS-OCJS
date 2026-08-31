#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int n;
  scanf("%d", &n);
  cin >> str;
  if (n >= 11) {
    int num = count(str.begin(), str.end(), '8');
    if (n / 11 <= num) {
      printf("%d\n", n / 11);
    } else {
      printf("%d\n", num);
    }
  } else {
    printf("%d\n", 0);
  }
}
