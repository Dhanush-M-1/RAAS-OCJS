#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int max = 0;
  int last;
  cin >> last;
  for (int i = 1; i < a; i++) {
    int temp;
    cin >> temp;
    if (last - temp > max) max = last - temp;
    last = temp;
  }
  if (max - b < 0)
    cout << 0;
  else
    cout << (max - b);
  return 0;
}
