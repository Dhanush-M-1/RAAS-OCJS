#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int first = 0, second = 0, third = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    first += x;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    second += x;
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    third += x;
  }
  cout << first - second << endl << second - third;
  return 0;
}
