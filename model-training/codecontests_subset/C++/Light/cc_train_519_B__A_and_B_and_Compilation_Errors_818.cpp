#include <bits/stdc++.h>
using namespace std;
int n, s1 = 0, s2 = 0, s3 = 0;
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    s1 += a;
  }
  for (int i = 0; i < n - 1; ++i) {
    int a;
    cin >> a;
    s2 += a;
  }
  for (int i = 0; i < n - 2; ++i) {
    int a;
    cin >> a;
    s3 += a;
  }
  cout << s1 - s2 << endl << s2 - s3 << endl;
}
