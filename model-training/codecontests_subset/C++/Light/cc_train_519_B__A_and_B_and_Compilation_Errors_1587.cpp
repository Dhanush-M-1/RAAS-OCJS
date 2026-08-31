#include <bits/stdc++.h>
using namespace std;
int main() {
  int num;
  cin >> num;
  vector<int> v1(num);
  vector<int> v2(num - 1);
  vector<int> v3(num - 2);
  int a = 0, b = 0, c = 0;
  for (int i = 0; i < num; i++) {
    cin >> v1[i];
    a += v1[i];
  }
  for (int i = 0; i < num - 1; i++) {
    cin >> v2[i];
    b += v2[i];
  }
  for (int i = 0; i < num - 2; i++) {
    cin >> v3[i];
    c += v3[i];
  }
  cout << a - b << " " << b - c << endl;
  return 0;
}
