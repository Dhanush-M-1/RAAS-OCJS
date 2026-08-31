#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int n, tmp;
  cin >> n;
  tmp = n;
  long long int cnt = 0, prod = 1;
  bool isprime = true;
  for (long long int i = 2; i * i <= tmp; i++) {
    while (tmp % i == 0) {
      isprime = false;
      cnt++;
      prod *= i;
      if (cnt == 2 && prod != n) {
        cout << 1 << endl << prod << endl;
        return 0;
      }
      tmp /= i;
    }
  }
  if (isprime) {
    cout << 1 << endl << 0 << endl;
  } else {
    cout << 2 << endl;
  }
  return 0;
}
