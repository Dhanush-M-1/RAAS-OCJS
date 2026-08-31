#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long q;
  cin >> q;
  vector<long long> vec;
  for (long long i = 2; i * i <= q && vec.size() < 3; i++) {
    while (q % i == 0) {
      q /= i;
      vec.push_back(i);
      if (vec.size() == 3) break;
    }
  }
  if (q != 1 && vec.size() != 3) vec.push_back(q);
  if (vec.size() == 3)
    cout << "1\n" << vec[0] * vec[1] << endl;
  else if (vec.size() == 2)
    cout << 2 << endl;
  else
    cout << "1\n" << 0 << endl;
  return 0;
}
