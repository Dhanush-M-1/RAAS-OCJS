#include <bits/stdc++.h>
using namespace std;
int n;
int X[55], Y[55], R[55];
void p(int* m, int i) {
  if (i + 1 < n) {
    cout << "(";
  }
  int temp = m[i] / 2;
  cout << "(" << temp << "*((1-abs((t-" << i << ")))+abs((abs((t-" << i
       << "))-1))))";
  if (i + 1 < n) {
    cout << "+";
    p(m, i + 1);
    cout << ")";
  }
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> X[i] >> Y[i] >> R[i];
  }
  p(X, 0);
  cout << endl;
  p(Y, 0);
  cout << endl;
  return 0;
}
