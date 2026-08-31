#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int a[n], b[n - 1], c[n - 2];
  unordered_map<long long int, long long int> hash1;
  unordered_map<long long int, long long int> hash2;
  unordered_map<long long int, long long int> hash3;
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
    hash1[a[i]]++;
  }
  for (long long int i = 0; i < n - 1; i++) {
    cin >> b[i];
    hash2[b[i]]++;
  }
  for (long long int i = 0; i < n - 2; i++) {
    cin >> c[i];
    hash3[c[i]]++;
  }
  for (long long int i = 0; i < n; i++) {
    if (hash2[a[i]] != hash1[a[i]]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (long long int i = 0; i < n - 1; i++) {
    if (hash3[b[i]] != hash2[b[i]]) {
      cout << b[i] << endl;
      break;
    }
  }
  return 0;
}
