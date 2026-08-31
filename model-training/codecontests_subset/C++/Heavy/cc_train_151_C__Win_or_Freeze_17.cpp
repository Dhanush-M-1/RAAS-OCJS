#include <bits/stdc++.h>
using namespace std;
bool isprime(long long N) {
  if (N == 1) return 1;
  for (long long i = 2; i * i <= N; i++) {
    if (N % i == 0) return 0;
  }
  return 1;
}
int main() {
  long long N;
  cin >> N;
  if (isprime(N)) {
    printf("1\n0\n");
    return 0;
  }
  long long Nval = N;
  long long cnt = 0;
  long long myprime1 = -1;
  long long myprime2 = -1;
  for (long long i = 2; i * i <= N; i++) {
    while (N != 1 && N % i == 0) {
      N = N / i;
      cnt++;
      if (myprime1 == -1)
        myprime1 = i;
      else
        myprime2 = i;
    }
  }
  if (N != 1) {
    cnt++;
    myprime2 = N;
  }
  if (cnt >= 3) {
    cout << 1 << endl << myprime1 * myprime2 << endl;
    return 0;
  } else {
    cout << 2 << endl;
  }
  return 0;
}
