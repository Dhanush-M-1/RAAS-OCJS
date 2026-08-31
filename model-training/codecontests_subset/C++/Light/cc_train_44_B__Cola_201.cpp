#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int n, a, b, c, count = 0, flag = 1;
  cin >> n >> a >> b >> c;
  for (int i = -1; i < a; ++i)
    if ((i + 1) % 2 == 0)
      for (int k = -1; k < c; ++k)
        if ((n - (i + 1) * 0.5 - (k + 1) * 2 >= 0) &&
            (n - (i + 1) * 0.5 - (k + 1) * 2 <= b)) {
          count++;
        }
  cout << count;
  return 0;
}
