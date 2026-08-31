#include <bits/stdc++.h>
using namespace std;
string zh(int n, int l) {
  string a;
  char b;
  while (n > 0) {
    b = n % l + '0';
    a = b + a;
    n /= l;
  }
  return a;
}
int main() {
  int n;
  string a;
  scanf("%d", &n);
  for (int i = 1; i <= n - 1; i++) {
    for (int j = 1; j <= n - 1; j++) {
      a = zh(i * j, n);
      cout << a << " ";
    }
    puts("");
  }
  return 0;
}
