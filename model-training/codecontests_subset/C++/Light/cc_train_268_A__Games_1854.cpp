#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, n;
  cin >> n;
  vector<int> v1, v2;
  for (int i = (0); i < (int)(n); i++) {
    cin >> a >> b;
    v1.push_back(a);
    v2.push_back(b);
  }
  int sum = 0;
  for (int i = 0; i < v2.size(); i++) {
    for (int j = 0; j < v1.size(); j++)
      if (v2[i] == v1[j]) sum++;
  }
  cout << sum;
  return 0;
}
