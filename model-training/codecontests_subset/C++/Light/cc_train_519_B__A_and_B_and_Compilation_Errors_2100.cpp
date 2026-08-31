#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100005], b[100005], c[100005];
  memset(a, 0, sizeof(a));
  memset(b, 0, sizeof(b));
  memset(c, 0, sizeof(c));
  cin >> n;
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  for (int i = 0; i < n - 1; i++) scanf("%d", &b[i]);
  for (int i = 0; i < n - 2; i++) scanf("%d", &c[i]);
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  int j = 0, k = 0, ci, bi;
  for (int i = 0; i < n; i++)
    if (a[i] == b[j]) {
      j++;
      if (a[i] == c[k])
        k++;
      else
        ci = a[i];
    } else
      bi = a[i];
  cout << bi << endl << ci;
}
