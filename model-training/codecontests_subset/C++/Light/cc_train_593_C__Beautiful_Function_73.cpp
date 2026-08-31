#include <bits/stdc++.h>
using namespace std;
int n;
void go(int arr[]) {
  for (int i = 0; i < n - 1; i++) {
    printf("(");
  }
  for (int i = 0; i < n; i++) {
    if (i) {
      printf("+");
    }
    printf("(%d*(abs((abs((t-%d))-1))-(abs((t-%d))-1)))", arr[i] / 2, i, i);
    if (i) {
      printf(")");
    }
  }
  printf("\n");
}
int main() {
  cin >> n;
  int x[100];
  int y[100];
  for (int i = 0; i < n; i++) {
    cin >> x[i];
    cin >> y[i];
    int g;
    cin >> g;
  }
  go(x);
  go(y);
  return 0;
}
