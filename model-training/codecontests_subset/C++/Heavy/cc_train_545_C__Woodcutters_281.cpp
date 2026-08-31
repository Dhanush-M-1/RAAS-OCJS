#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<long long> x(n);
  vector<long long> h(n);
  for (long long i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  vector<long long> f_back(n, 0);
  vector<long long> f_not(n, 0);
  vector<long long> f_front(n, 0);
  f_back[0] = 1;
  f_not[0] = 0;
  if (n == 1 || (n > 1 && x[1] - x[0] - 1 >= h[0])) {
    f_front[0] = 1;
  }
  for (long long i = 1; i < n; i++) {
    f_not[i] = max(max(f_not[i - 1], f_front[i - 1]), f_back[i - 1]);
    if (x[i] - x[i - 1] - 1 >= h[i])
      f_back[i] = max(f_back[i], max(f_not[i - 1], f_back[i - 1])) + 1;
    if (x[i] - x[i - 1] - 1 >= h[i] + h[i - 1])
      f_back[i] = max(f_back[i], f_front[i - 1] + 1);
    if (i == n - 1 || (i < n - 1 && x[i + 1] - x[i] - 1 >= h[i]))
      f_front[i] = max(f_back[i - 1], max(f_front[i - 1], f_not[i - 1])) + 1;
  }
  cout << max(max(f_front[n - 1], f_back[n - 1]), f_not[n - 1]);
  cin >> n;
  return 0;
}
