#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  long long n1 = n;
  vector<long long> div;
  for (long long i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      div.push_back(i);
      n = n / i;
    }
  }
  if (n > 1) div.push_back(n);
  if (div.size() == 1 || n1 == 1) {
    cout << 1 << endl << 0;
  } else if (div[0] * div[1] == n1) {
    cout << 2;
  } else {
    cout << 1 << endl << div[0] * div[1];
  }
}
