#include <bits/stdc++.h>
using namespace std;
void inout() {}
unsigned long long int mmi(unsigned long long int x) {
  unsigned long long int result = 1, e = 1000000007 - 2;
  while (e) {
    if (e & 1) result = (result * x) % 1000000007;
    x = (x * x) % 1000000007;
    e >>= 1;
  }
  return result;
}
unsigned long long int fmod(int a) {
  unsigned long long int f = 1;
  for (long long i = 2; i < a + 1; i++) {
    f = (f * i) % 1000000007;
  }
  return f;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  inout();
  long long n;
  cin >> n;
  long long sum = 0;
  long long c2 = 0;
  for (long long i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (x == 200) {
      ++c2;
    }
    sum += x;
  }
  if (c2 == n && c2 % 2 != 0) {
    cout << "NO";
    return 0;
  }
  if (c2 == 0 && sum % 200 == 0) {
    cout << "YES";
  } else if (sum % 200 == 0)
    cout << "YES";
  else
    cout << "NO";
}
