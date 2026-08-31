#include <bits/stdc++.h>
using namespace std;
int start_up() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  return 0;
}
int static r = start_up();
int main() {
  long long a, b;
  cin >> a >> b;
  long long sum = 0;
  sum = a;
  while (b <= a) {
    long long c = a / b;
    a = c + (a % b);
    sum = sum + c;
  }
  cout << sum;
  return 0;
}
