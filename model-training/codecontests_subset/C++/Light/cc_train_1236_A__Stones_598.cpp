#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  while (n--) {
    int a;
    int b;
    int c;
    cin >> a >> b >> c;
    int min1;
    int max1 = 0;
    min1 = min(a, b / 2);
    int min2 = b - 2 * min1;
    max1 = min1 + min1 * 2 + min(min2, c / 2) + 2 * min(min2, c / 2);
    int min3 = min(b, c / 2);
    int min4 = min(a, (b - min3) / 2);
    int max2 = min3 + min3 * 2 + 3 * min(a, (b - min3) / 2);
    cout << max(max1, max2) << endl;
  }
}
