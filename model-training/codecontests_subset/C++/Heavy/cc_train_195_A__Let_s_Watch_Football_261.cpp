#include <bits/stdc++.h>
using namespace std;
using namespace std;
const int sz = 1e5;
bool isPrime[sz + 1];
bool iszero(int x) {
  while (x != 0) {
    int l = x % 10;
    if (l == 0) {
      return false;
    }
    x = x / 10;
  }
  return true;
}
void sieve() {
  memset(isPrime, true, sizeof(isPrime));
  isPrime[0] = isPrime[1] = false;
  for (int i = 2; i * i <= sz; i++) {
    if (isPrime[i]) {
      for (int j = i * i; j < sz; j += i) {
        isPrime[j] = false;
      }
    }
  }
}
void findPrimesD(int d) {
  int left = pow(10, d - 1);
  int right = pow(10, d) - 1;
  for (int i = left; i <= right; i++) {
    if (isPrime[i]) {
      if (iszero(i)) {
        cout << i << endl;
        break;
      }
    }
  }
}
bool isPowerOfTwo(int n) {
  if (n == 0) return false;
  return (ceil(log2(n)) == floor(log2(n)));
}
bool isPerfectSquare(long double x) {
  if (x >= 0) {
    long long sr = sqrt(x);
    return (sr * sr == x);
  }
  return false;
}
long long distance(int x1, int y1, int x2, int y2) {
  long long ans = pow((x2 - x1), 2) + pow((y2 - y1), 2);
  return ans;
}
int check(int x1, int y1, int x2, int y2, int x3, int y3) {
  if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) ||
      (x2 == x3 && y2 == y3))
    return 0;
  long long ans1 = distance(x1, y1, x2, y2);
  long long ans2 = distance(x1, y1, x3, y3);
  long long ans3 = distance(x2, y2, x3, y3);
  if (ans1 + ans2 == ans3) return 1;
  if (ans1 + ans3 == ans2) return 1;
  if (ans2 + ans3 == ans1) return 1;
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  float l, t;
  l = (a - b) * c;
  t = ceil(l / b);
  cout << t;
  return 0;
}
