#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  int b;
  cin >> a >> b;
  int c[a];
  int sum = -1;
  for (int i = 1; i <= a; i++) {
    cin >> c[i];
  }
  for (int i = 2; i <= a; i++) {
    if (c[i - 1] - c[i] > sum) {
      sum = c[i - 1] - c[i];
    }
  }
  if (sum - b > -1)
    cout << sum - b;
  else
    cout << 0;
}
