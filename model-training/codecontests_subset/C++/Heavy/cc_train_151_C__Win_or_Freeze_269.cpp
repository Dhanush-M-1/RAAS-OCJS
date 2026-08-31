#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<long long int> v;
  long long int i, j, n, resp;
  while (cin >> n) {
    j = n;
    while (n > 1 && (n % 2) == 0) {
      n /= 2;
      v.push_back(2);
    }
    for (i = 3; (i * i) <= n; i += 2) {
      while (n > 1 && (n % i) == 0) {
        n /= i;
        v.push_back(i);
      }
    }
    if (n > 1) v.push_back(n);
    if (j == 1 || (v.size() == 1)) {
      cout << "1\n0\n";
    } else if (v.size() == 2) {
      cout << "2\n";
    } else {
      sort(v.begin(), v.end());
      resp = v[0] * v[1];
      cout << "1\n" << resp << endl;
    }
    v.clear();
  }
  return 0;
}
