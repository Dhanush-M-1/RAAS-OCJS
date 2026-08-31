#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int menor = 10000;
  for (int i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    if (k % tmp == 0) {
      menor = (k / tmp < menor) ? k / tmp : menor;
    }
  }
  cout << menor << endl;
}
