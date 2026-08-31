#include <bits/stdc++.h>
using namespace std;
struct t {
  int h;
  int g;
  t() {}
  t(int a, int b) {
    h = a;
    g = b;
  }
};
int main() {
  int n;
  t a[50];
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i].h;
    cin >> a[i].g;
  }
  int sum = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (a[i].h == a[j].g && i != j) {
        sum++;
      }
    }
  }
  cout << sum;
  return 0;
}
