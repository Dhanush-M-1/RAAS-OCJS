#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, l, r, d, i, f = 0, j;
  cin >> x;
  int* Arr = (int*)malloc(3 * x * sizeof(int));
  int z;
  for (z = 0; z < 3 * x; z++) {
    cin >> Arr[z];
  }
  int mod;
  for (i = 0; i < x; i++) {
    l = Arr[i * 3];
    r = Arr[3 * i + 1];
    d = Arr[3 * i + 2];
    n = d;
    f = 0;
    if (n < l || n > r)
      cout << d << endl;
    else {
      mod = r % n;
      n = n + r - mod;
      cout << n << endl;
    }
  }
  free(Arr);
  return 0;
}
