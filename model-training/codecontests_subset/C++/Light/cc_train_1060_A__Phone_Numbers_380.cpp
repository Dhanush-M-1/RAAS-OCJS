#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string number;
  int c = 0;
  scanf("%d", &n);
  cin >> number;
  for (int i = 0; i < number.size(); i++) {
    if (number[i] == '8') ++c;
  }
  printf("%d\n", min(c, (n / 11)));
  return 0;
}
