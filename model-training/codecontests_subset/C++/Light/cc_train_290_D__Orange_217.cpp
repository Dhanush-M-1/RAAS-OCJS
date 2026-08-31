#include <bits/stdc++.h>
using namespace std;
const int N = 20;
int main() {
  char a[100];
  int b;
  cin >> a >> b;
  for (int i = 0; a[i]; i++) {
    if (a[i] <= 'Z') a[i] = a[i] + 32;
    if (a[i] < b + 97) a[i] = a[i] - 32;
  }
  puts(a);
  return 0;
}
