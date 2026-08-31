#include <bits/stdc++.h>
using namespace std;
int n, c, m;
int a[100100];
int main() {
  cin >> n >> c;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (int i = 1; i <= n - 1; i++) {
    m = max(m, a[i] - a[i + 1] - c);
  }
  cout << m;
}
