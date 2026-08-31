#include <bits/stdc++.h>
using namespace std;
int N, x[60], y[60], r;
int main() {
  scanf("%d", &N);
  for (int i = 1; i <= N; ++i) {
    scanf("%d%d%d", &x[i], &y[i], &r);
    x[i] /= 2;
    y[i] /= 2;
  }
  for (int i = 1; i < N; ++i) cout << "(";
  for (int i = 1; i <= N; ++i) {
    if (i > 1) {
      cout << "+";
    }
    cout << "(" << x[i] << "*((1-abs((t-" << i - 1 << ")))+abs((abs((t-"
         << i - 1 << "))-1))))";
    if (i > 1) cout << ")";
  }
  cout << "\n";
  for (int i = 1; i < N; ++i) cout << "(";
  for (int i = 1; i <= N; ++i) {
    if (i > 1) {
      cout << "+";
    }
    cout << "(" << y[i] << "*((1-abs((t-" << i - 1 << ")))+abs((abs((t-"
         << i - 1 << "))-1))))";
    if (i > 1) cout << ")";
  }
  cout << "\n";
  return 0;
}
