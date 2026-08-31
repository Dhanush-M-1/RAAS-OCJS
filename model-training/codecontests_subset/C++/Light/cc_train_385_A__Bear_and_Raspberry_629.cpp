#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[n];
  int maxx = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if (a[i - 1] - a[i] - m > maxx && i > 1) {
      maxx = a[i - 1] - a[i] - m;
    }
  }
  cout << maxx << endl;
}
