#include <bits/stdc++.h>
using namespace std;
int main() {
  int long long n, element, sum1 = 0, sum2 = 0, sum3 = 0;
  vector<int> v1, v2, v3;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> element;
    v1.push_back(element);
    sum1 += element;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> element;
    v2.push_back(element);
    sum2 += element;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> element;
    v3.push_back(element);
    sum3 += element;
  }
  cout << sum1 - sum2 << endl << sum2 - sum3 << endl;
  return 0;
}
