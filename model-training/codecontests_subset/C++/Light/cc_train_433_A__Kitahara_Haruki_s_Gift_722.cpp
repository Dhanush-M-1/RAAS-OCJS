#include <bits/stdc++.h>
using namespace std;
const int MAX = 505;
int n, sum, a, b, x;
bool ans;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      a++;
    else
      b++;
  }
  sum = 100 * a + 200 * b;
  if (sum % 200 != 0) {
    cout << "NO";
    return 0;
  }
  sum /= 2;
  for (int i = 0; i <= b; i++) {
    if (i * 200 <= sum && sum - 200 * i <= 100 * a) ans = true;
  }
  if (ans)
    cout << "YES";
  else
    cout << "NO";
}
