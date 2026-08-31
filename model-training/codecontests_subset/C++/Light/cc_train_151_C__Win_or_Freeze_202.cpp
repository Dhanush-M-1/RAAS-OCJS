#include <bits/stdc++.h>
using namespace std;
int main() {
  long long q;
  cin >> q;
  vector<long long> v1;
  for (long long i = 2; i <= sqrt(q);) {
    if (q % i == 0) {
      v1.push_back(i);
      q = q / i;
    } else
      i++;
  }
  if (q > 1) v1.push_back(q);
  if (v1.size() <= 1)
    cout << 1 << "\n" << 0;
  else if (v1.size() == 2)
    cout << 2;
  else {
    cout << 1 << "\n" << v1[0] * v1[1];
  }
}
