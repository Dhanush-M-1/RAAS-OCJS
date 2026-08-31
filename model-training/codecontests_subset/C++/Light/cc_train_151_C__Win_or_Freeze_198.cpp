#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  vector<long long int> v;
  for (long long int i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      v.push_back(i);
      n /= i;
    }
  }
  if (n > 2) v.push_back(n);
  if (v.size() <= 1) {
    cout << "1" << endl;
    cout << "0" << endl;
  } else if (v.size() == 2)
    cout << "2" << endl;
  else {
    cout << "1" << endl;
    cout << v[0] * v[1] << endl;
  }
}
