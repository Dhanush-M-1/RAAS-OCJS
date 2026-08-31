#include <bits/stdc++.h>
using namespace std;
long long a;
int main() {
  cin >> a;
  int b = 0, sum = 0;
  for (int i = 0; i < a; i++) {
    int n;
    cin >> n;
    sum += n;
    if (n > b) b = n;
  }
  while ((a * b) - sum <= sum) b++;
  cout << b << endl;
  return 0;
}
