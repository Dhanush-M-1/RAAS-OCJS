#include <bits/stdc++.h>
using namespace std;
int n, a[100005], b[100005], c[100005], first;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  sort(a + 1, a + n + 1);
  n--;
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  sort(b + 1, b + n + 1);
  n--;
  for (int i = 1; i <= n; i++) {
    cin >> c[i];
  }
  n += 2;
  int i = 1;
  while (a[i] == b[i]) {
    i++;
  }
  first = a[i];
  cout << a[i] << '\n';
  c[n - 1] = first;
  sort(c + 1, c + n);
  i = 1;
  while (a[i] == c[i]) {
    i++;
  }
  cout << a[i];
}
