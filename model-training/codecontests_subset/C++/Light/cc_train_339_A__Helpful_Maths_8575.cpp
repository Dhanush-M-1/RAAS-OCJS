#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[1000], n = 0;
  while (cin >> a[n++])
    ;
  sort(a, a + n);
  cout << a[1];
  for (int i = 2; i < n; i++) cout << '+' << a[i];
  return 0;
}
