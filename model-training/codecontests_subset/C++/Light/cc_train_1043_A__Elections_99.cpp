#include <bits/stdc++.h>
using namespace std;
int omadliRaqamlarSoni(int n);
int main(int argc, char** argv) {
  int n, a, sum = 0, max = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a;
    if (a > max) {
      max = a;
    }
    sum += a;
  }
  if (2 * sum / n + 1 >= max) {
    cout << 2 * sum / n + 1;
  } else {
    cout << max;
  }
  return 0;
}
