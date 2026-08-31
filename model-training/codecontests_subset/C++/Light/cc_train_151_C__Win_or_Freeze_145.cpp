#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, tot = 0, N;
  cin >> n;
  N = n;
  vector<long long> v;
  for (long long i = 2; i * i <= n; i++)
    if (n % i == 0) {
      v.push_back(i);
      while (n % i == 0) n /= i, tot++;
    }
  if (n != 1) tot++, v.push_back(n);
  if (tot <= 1)
    cout << 1 << endl << 0 << endl;
  else if (tot == 2)
    cout << 2 << endl;
  else {
    long long div = 1;
    cout << 1 << endl;
    if (v.size() >= 2) {
      div = v[0] * v[1];
      cout << div << endl;
    } else {
      div = v[0] * v[0];
      cout << div << endl;
    }
  }
  return 0;
}
