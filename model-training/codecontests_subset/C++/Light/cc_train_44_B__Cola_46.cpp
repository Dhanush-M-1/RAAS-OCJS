#include <bits/stdc++.h>
using namespace std;
int main() {
  long double n, a, b, c, one, two;
  cin >> n >> a >> b >> c;
  long long int count = 0;
  for (int i = 0; i <= c; i++) {
    for (int j = 0; j <= b; j++) {
      one = j + (2 * i);
      if (n - one >= 0 && (.5 * a) >= n - one) {
        count++;
      }
    }
  }
  cout << count << endl;
}
