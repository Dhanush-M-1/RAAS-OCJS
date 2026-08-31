#include <bits/stdc++.h>
using namespace std;
long long i;
bool isPrime(long long n) {
  if (n == 1) {
    return false;
  } else if (n == 2 || n == 3) {
    return true;
  } else {
    for (i = 2; i <= sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
  }
  return true;
}
long long gcd(long long a, long long b) {
  if (a == 0) {
    return b;
  } else {
    return gcd(b % a, a);
  }
}
long long lcm(long long a, long long b) {
  return (max(a, b) / gcd(a, b)) * min(a, b);
}
int main() {
  long long n;
  cin >> n;
  long long arr[n], brr[n - 1], crr[n - 2];
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (long long i = 0; i < n - 1; i++) {
    cin >> brr[i];
  }
  for (long long i = 0; i < n - 2; i++) {
    cin >> crr[i];
  }
  sort(arr, arr + n);
  sort(brr, brr + (n - 1));
  sort(crr, crr + (n - 2));
  bool state1 = false, state2 = false;
  for (long long i = 0; i < n - 1; i++) {
    if (arr[i] != brr[i]) {
      cout << arr[i] << endl;
      state1 = true;
      break;
    }
  }
  if (!state1) {
    cout << arr[n - 1] << endl;
  }
  for (long long i = 0; i < n - 2; i++) {
    if (brr[i] != crr[i]) {
      cout << brr[i] << endl;
      state2 = true;
      break;
    }
  }
  if (!state2) {
    cout << brr[n - 2] << endl;
  }
}
