#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, n;
  cin >> n >> a >> b >> c;
  int count = 0;
  for (int i = 0; i <= b; i++) {
    for (int j = 0; j <= c; j++) {
      int num = n - i - 2 * j;
      if (num >= 0 && 2 * num <= a) count++;
    }
  }
  cout << count << endl;
}
