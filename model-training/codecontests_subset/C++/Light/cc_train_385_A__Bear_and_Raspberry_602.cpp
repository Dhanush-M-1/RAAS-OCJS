#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int c;
  cin >> n >> c;
  int max(0);
  int x[n];
  for (int i = 0; i < n; i++) cin >> x[i];
  for (int i = 0; i < n - 1; i++) {
    int s(0);
    s += x[i];
    s -= x[i + 1];
    s -= c;
    if (s > max) max = s;
  }
  cout << max << endl;
}
