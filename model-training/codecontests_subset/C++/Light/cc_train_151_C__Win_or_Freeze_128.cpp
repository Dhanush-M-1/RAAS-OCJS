#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x;
  cin >> x;
  vector<long long> vi;
  for (long long i = 2; i * i <= x; i++) {
    while (x % i == 0 && i != x) {
      x /= i;
      vi.push_back(i);
    }
  }
  if (!vi.size())
    cout << 1 << endl << 0;
  else if (vi.size() == 1)
    cout << 2;
  else
    cout << 1 << endl << vi[0] * vi[1] << endl;
  return 0;
}
