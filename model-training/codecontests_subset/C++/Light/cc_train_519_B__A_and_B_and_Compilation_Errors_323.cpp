#include <bits/stdc++.h>
using namespace std;
int main() {
  long long s1 = 0, s2 = 0, s3 = 0, num;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> num;
    s1 += num;
  }
  for (int i = 1; i < n; i++) {
    cin >> num;
    s2 += num;
  }
  for (int i = 2; i < n; i++) {
    cin >> num;
    s3 += num;
  }
  cout << s1 - s2 << endl;
  cout << s2 - s3;
}
