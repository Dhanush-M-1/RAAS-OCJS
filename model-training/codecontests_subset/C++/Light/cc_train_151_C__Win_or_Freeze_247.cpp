#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q;
  cin >> q;
  long long org = q;
  vector<int> f;
  int i;
  for (i = 2; i <= (int)sqrt((double)(q + 1)); ++i) {
    while (q % i == 0) {
      f.push_back(i);
      q /= i;
    }
    if (f.size() >= 3) break;
    if (q == 1) break;
  }
  if (q != org && q != 1) f.push_back(q);
  if (f.size() == 0) {
    printf("1\n");
    printf("0\n");
  } else if (f.size() == 2) {
    printf("2\n");
  } else {
    printf("1\n");
    cout << f[0] * f[1] << endl;
  }
  return 0;
}
