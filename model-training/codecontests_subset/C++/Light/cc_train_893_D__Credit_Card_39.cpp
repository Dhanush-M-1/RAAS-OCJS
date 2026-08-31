#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  int n, d;
  cin >> n >> d;
  vector<long long> a(n);
  vector<long long> a0(n);
  cin >> a[0];
  a0[0] = a[0];
  for (int i = 1; i < n; i++) {
    int temp;
    cin >> temp;
    a0[i] = temp;
    a[i] = a[i - 1] + temp;
  }
  vector<long long> b(n);
  b[n - 1] = a[n - 1];
  for (int i = n - 2; i >= 0; i--) b[i] = max(b[i + 1], a[i]);
  if (b[0] > d) {
    cout << -1 << endl;
    return 0;
  }
  int count = 0;
  long long sum = 0;
  long long to_add;
  for (int i = 0; i < n; i++) {
    if (a0[i] == 0) {
      if (sum + a[i] < 0) {
        count++;
        sum = d - b[i];
        if (sum + a[i] < 0) {
          cout << -1 << endl;
          return 0;
        }
      }
    }
  }
  cout << count << endl;
  return 0;
}
