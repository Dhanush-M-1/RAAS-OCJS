#include <bits/stdc++.h>
using namespace std;
char c;
int a[110], n, num, p;
int main() {
  p = 1;
  num = 0;
  a[++num] = 1;
  while (scanf("%c", &c)) {
    if (c == '\n') break;
    if (c == '-') p--, a[++num] = -1;
    if (c == '+') p++, a[++num] = 1;
    if (c >= '0' && c <= '9') {
      n *= 10;
      n += c - '0';
    }
  }
  for (int i = 1; i <= num; i++) {
    while ((p < n) and (a[i] > 0) and (a[i] < n)) a[i]++, p++;
    while ((p > n) and (a[i] < 0) and (a[i] > -n)) a[i]--, p--;
  }
  if (p != n) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  for (int i = 1; i <= num; i++)
    cout << (i > 1 ? (a[i] < 0 ? "- " : "+ ") : "") << abs(a[i]) << " ";
  cout << "= " << n;
  return 0;
}
