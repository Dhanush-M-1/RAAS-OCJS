#include <bits/stdc++.h>
using namespace std;
int k, a[105][105];
void bang() {
  for (int i = (1); i <= (k - 1); i++)
    for (int j = (1); j <= (k - 1); j++) a[i][j] = i * j;
}
int chuyen(int i, int j) { return (i * j / k) * 10 + (i * j % k); }
void doi() {
  if (k == 10) return;
  for (int i = (1); i <= (k - 1); i++)
    for (int j = (1); j <= (k - 1); j++)
      if (a[i][j] >= k) a[i][j] = chuyen(i, j);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie();
  cout.tie();
  cin >> k;
  bang();
  doi();
  for (int i = (1); i <= (k - 1); i++) {
    for (int j = (1); j <= (k - 1); j++) cout << a[i][j] << " ";
    cout << "\n";
  }
  return 0;
}
