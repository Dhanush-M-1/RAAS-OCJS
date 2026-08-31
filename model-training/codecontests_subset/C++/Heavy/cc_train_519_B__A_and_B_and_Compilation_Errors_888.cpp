#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long int n;
  cin >> n;
  long int arr[n];
  vector<long int> v, v1, v2;
  for (long int i = 0; i < n; i++) {
    long int a;
    cin >> a;
    v.push_back(a);
  }
  sort(v.begin(), v.end());
  for (long int i = 0; i < n - 1; i++) {
    long int a;
    cin >> a;
    v1.push_back(a);
  }
  sort(v1.begin(), v1.end());
  for (long int i = 0; i < n - 2; i++) {
    long int a;
    cin >> a;
    v2.push_back(a);
  }
  sort(v2.begin(), v2.end());
  bool result = true;
  long int value;
  for (long int i = 0; i < n - 1; i++) {
    if (v[i] != v1[i]) {
      result = false;
      value = v[i];
      break;
    }
  }
  if (result) value = v[n - 1];
  cout << value << "\n";
  result = true;
  for (long int i = 0; i < n - 2; i++) {
    if (v2[i] != v1[i]) {
      result = false;
      value = v1[i];
      break;
    }
  }
  if (result) value = v1[n - 2];
  cout << value << "\n";
  return 0;
}
