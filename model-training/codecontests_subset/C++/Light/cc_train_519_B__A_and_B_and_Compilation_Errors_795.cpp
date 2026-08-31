#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int x1[N], x2[N], x3[N];
int n;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x1[i];
  for (int i = 0; i < n - 1; i++) cin >> x2[i];
  for (int i = 0; i < n - 2; i++) cin >> x3[i];
  sort(x1, x1 + n);
  sort(x2, x2 + (n - 1));
  sort(x3, x3 + (n - 2));
  for (int i = 0; i < n; i++)
    if (x1[i] != x2[i]) {
      cout << x1[i] << endl;
      break;
    }
  for (int i = 0; i < (n - 1); i++)
    if (x2[i] != x3[i]) {
      cout << x2[i];
      break;
    }
  return 0;
}
