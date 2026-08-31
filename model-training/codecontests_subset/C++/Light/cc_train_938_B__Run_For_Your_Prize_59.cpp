#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int N = 1e4 + 7;
const long long int inf = 1e17;
long long int en = 1000000;
int main() {
  long long int i, j, k, n, l;
  cin >> n;
  long long int a[n + 1];
  for (i = 0; i < n; i++) scanf("%lld", &a[i]);
  vector<long long int> vec;
  for (i = 0; i < n; i++) {
    long long int x = a[i] - 1;
    long long int y = en - a[i];
    if (x > y)
      vec.push_back(y);
    else
      vec.push_back(x);
  }
  sort(vec.begin(), vec.end(), greater<long long int>());
  cout << (*vec.begin());
  return 0;
}
