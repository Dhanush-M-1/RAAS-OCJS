#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  long int a[10000], s = 0, i, j, cont = 0;
  while (n--) {
    int x;
    cin >> x;
    j = s;
    s += x;
    for (i = j; i < s; i++) {
      cin >> a[i];
    }
  }
  sort(a, a + s);
  for (i = 0; i < s; i++) {
    if (a[i] == cont + 1) cont++;
  }
  if (cont == m)
    cout << "YES";
  else
    cout << "NO";
}
