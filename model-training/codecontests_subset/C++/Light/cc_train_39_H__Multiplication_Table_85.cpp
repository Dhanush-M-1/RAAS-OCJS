#include <bits/stdc++.h>
using namespace std;
void work(int a, int n) {
  if (a >= n) cout << a / n % n;
  cout << a % n << " ";
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++, cout << endl)
    for (int j = 1; j < n; j++) work(i * j, n);
  return 0;
}
