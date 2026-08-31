#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, counter = 0;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      if (n - i * 0.5 - j <= c * 2 && fmod(n - i * 0.5 - j, 2) == 0 &&
          n - i * 0.5 - j >= 0)
        counter++;
    }
  }
  cout << counter;
  return 0;
}
