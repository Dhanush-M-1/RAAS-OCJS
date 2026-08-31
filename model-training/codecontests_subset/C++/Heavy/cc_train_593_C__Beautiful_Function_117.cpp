#include <bits/stdc++.h>
using namespace std;
int n;
int x[50], y[50];
void print(int i, bool isx) {
  int v;
  if (isx) {
    v = x[i] / 2;
  } else {
    v = y[i] / 2;
  }
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", v, i, i);
}
void print_sum(int i, bool isx) {
  if (i == n - 1) {
    print(i, isx);
  } else {
    cout << "(";
    print(i, isx);
    cout << "+";
    print_sum(i + 1, isx);
    cout << ")";
  }
}
int main() {
  cin >> n;
  int r;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i] >> r;
  }
  if (n == 1) {
    cout << x[0] << endl << y[0];
  } else {
    print_sum(0, true);
    cout << endl;
    print_sum(0, false);
  }
  return 0;
}
