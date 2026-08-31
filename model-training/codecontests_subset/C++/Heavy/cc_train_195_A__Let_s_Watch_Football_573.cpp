#include <bits/stdc++.h>
using namespace std;
bool isPrime(int n) {
  if (n == 1) {
    return false;
  }
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
int power(int x, unsigned int y, int p) {
  int res = 1;
  x = x % p;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long int findSubarraySum(long long int arr[], long long int n,
                              long long int sum) {
  unordered_map<int, int> prevSum;
  long long int res = 0;
  long long int currsum = 0;
  for (long long int i = 0; i < n; i++) {
    currsum += arr[i];
    if (currsum == sum) res++;
    if (prevSum.find(currsum - sum) != prevSum.end())
      res += (prevSum[currsum - sum]);
    prevSum[currsum]++;
  }
  return res;
}
int main() {
  float a, b, c;
  cin >> a >> b >> c;
  float dif = (a * c) - (b * c);
  float d = b;
  cout << ceil(dif / b);
}
