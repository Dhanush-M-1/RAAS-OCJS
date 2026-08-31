#include <bits/stdc++.h>
using namespace std;
const long long A = 100000000000000LL, N = 10000;
string a;
long long i, j, n, m;
int main() {
  cin >> a;
  n = a.size();
  cin >> m;
  for (i = 0; i < n; i++)
    if (a[i] >= 'A' && a[i] <= 'Z') a[i] = a[i] - 'A' + 'a';
  for (i = 0; i < n; i++)
    if (a[i] < 'a' + m) a[i] = a[i] - 'a' + 'A';
  cout << a;
}
