#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> a;
  for (long long i = 2; i * i <= n; i++)
    for (; !(n % i); a.push_back(i), n /= i)
      ;
  if (n > 1) a.push_back(n);
  if (((int)(a).size()) < 2) {
    puts("1");
    puts("0");
  } else if (((int)(a).size()) == 2) {
    puts("2");
  } else {
    puts("1");
    cout << a[0] * a[1] << endl;
  }
  return 0;
}
