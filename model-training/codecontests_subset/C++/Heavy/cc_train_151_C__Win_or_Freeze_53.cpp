#include <bits/stdc++.h>
using namespace std;
bool isComposite(long long num) {
  for (long long i = 2; i * i <= num; i++)
    if (num % i == 0) return true;
  return false;
}
int main() {
  long long prime1 = -1, prime2 = -1, q;
  cin >> q;
  if (q == 1 || !isComposite(q)) {
    cout << "1\n0\n";
    return 0;
  }
  long long cnt = 0;
  for (long long i = 2; i * i <= q; i++) {
    while (q != 1 && q % i == 0) {
      cnt++;
      q /= i;
      if (prime1 == -1)
        prime1 = i;
      else if (prime2 == -1)
        prime2 = i;
    }
  }
  if (q != 1) {
    cnt++;
    if (prime2 == -1) prime2 = q;
  }
  if (cnt >= 3)
    cout << "1\n" << prime1 * prime2 << "\n";
  else
    cout << "2\n";
  return 0;
}
