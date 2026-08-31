#include <bits/stdc++.h>
using namespace std;
void converter(int n, int b) {
  if (n < b) {
    cout << n;
    return;
  } else {
    converter(n / b, b);
    cout << n % b;
  }
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      converter(i * j, k);
      cout << ' ';
    }
    cout << endl;
  }
}
