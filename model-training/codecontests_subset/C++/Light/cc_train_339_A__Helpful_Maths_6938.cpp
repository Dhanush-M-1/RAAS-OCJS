#include <bits/stdc++.h>
using namespace std;
int a[105];
int n;
int main() {
  while (cin >> a[n++])
    ;
  sort(a, a + n);
  cout << a[1];
  for (int i = 2; i < n; i++) cout << '+' << a[i];
  return 0;
}
