#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, num, s1 = 0, s2 = 0, s3 = 0;
  cin >> n;
  for (int k = 0; k < n; k++) {
    cin >> num;
    s1 += num;
  }
  for (int k = 0; k < n - 1; k++) {
    cin >> num;
    s2 += num;
  }
  for (int k = 0; k < n - 2; k++) {
    cin >> num;
    s3 += num;
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3 << endl;
}
