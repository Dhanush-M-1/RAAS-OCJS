#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, x, arr[100005], a, b;
  map<long long, long long> before;
  map<long long, long long> after1;
  map<long long, long long> after2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
    before[arr[i]]++;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> x;
    after1[x]++;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> x;
    after2[x]++;
  }
  for (int i = 0; i < n; i++) {
    if (before[arr[i]] - 1 == after1[arr[i]]) {
      a = arr[i];
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (after1[arr[i]] - 1 == after2[arr[i]]) {
      b = arr[i];
      break;
    }
  }
  cout << a << " " << b << endl;
  return 0;
}
