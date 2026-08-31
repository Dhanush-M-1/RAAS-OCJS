#include <bits/stdc++.h>
using namespace std;
long long n;
vector<long long> v;
int main() {
  cin >> n;
  if (n == 1) {
    cout << "1" << endl << "0";
    return 0;
  }
  for (long long i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      v.push_back(i);
      n /= i;
    }
  }
  if (n > 1) v.push_back(n);
  if (v.size() == 1)
    cout << "1" << endl << "0";
  else if (v.size() == 2)
    cout << "2";
  else {
    cout << "1" << endl;
    cout << v[0] * v[1];
  }
  return 0;
}
