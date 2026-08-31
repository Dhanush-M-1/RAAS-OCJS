#include <bits/stdc++.h>
using namespace std;
string a;
int n;
int main() {
  cin >> a;
  scanf("%d", &n);
  int i;
  for (i = 0; i < a.size(); i++)
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] = 'a' + a[i] - 'A';
  for (i = 0; i < a.size(); i++)
    if (a[i] - 'a' + 1 <= n) a[i] = 'A' + a[i] - 'a';
  cout << a;
  return 0;
}
